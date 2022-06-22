package calendar;

import java.sql.Time;
import java.util.*;
import java.util.stream.Collectors;

public class CalendarManagementServiceImpl implements  CalendarManagementService{

    private HashMap<UUID , Calendar> userCalendarMap;

    @Override
    public boolean createEvent(UUID hostId, List<UUID> attendees, Time startTime, Time endTime, String location, String agenda) {
        Event event = new Event(hostId,attendees,location,startTime,endTime,agenda);
        try {
            userCalendarMap.get(hostId).addEvent(event);
            for (UUID id : attendees) {
                userCalendarMap.get(id).addEvent(event);
            }
        }catch (Exception e){
            return false;
        }
        return true;

    }

    @Override
    public List<Event> viewEvents(UUID userId) {
        return userCalendarMap.get(userId).getEvents();
    }

    @Override
    public void updateEvent(UUID eventId, List<UUID> attendees, Time startTime, Time endTime, UUID hostId, String location, String agenda) {
        Event event = new Event(hostId,attendees,location,startTime,endTime,agenda);
        if(userCalendarMap.containsKey(hostId)){
            List<UUID>users= userCalendarMap.get(hostId).getEvent(eventId).getAttendees().stream().filter(user-> !attendees.contains(user)).collect(Collectors.toList());
            for (UUID user : users) {
                userCalendarMap.get(user).deleteEvent(eventId);
            }
            userCalendarMap.get(hostId).updateEvent(eventId,event);
        }
        for(UUID user: attendees){
            userCalendarMap.get(user).updateEvent(eventId, event);
        }
    }

    @Override
    public void deleteEvent(UUID eventId, UUID hostId) {
        List<UUID>users= userCalendarMap.get(hostId).getEvent(eventId).getAttendees();
        for (UUID user : users) {
            userCalendarMap.get(user).deleteEvent(eventId);
        }
    }
}
