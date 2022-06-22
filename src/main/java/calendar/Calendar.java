package calendar;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Calendar {
    User user;
    HashMap<UUID,Event> events;

    public Calendar(User user) {
        this.user = user;
        this.events = new HashMap<>();
    }

    public User getUser() {
        return user;
    }


    public List<Event> getEvents() {
        return (List<Event>) events.values();
    }

    public Event getEvent(UUID eventId) {
        return events.get(eventId);
    }


    public void updateEvent(UUID eventId, Event event){
        event.setEventStatus(EventStatus.PENDING);
        events.put(eventId, event);
    }

    public boolean deleteEvent(UUID eventId){
        if(events.containsKey(eventId)) {
            events.remove(eventId);
            return true;
        }
        return false;
    }

    public boolean updateEventStatus(UUID eventId, EventStatus status){
        if(events.containsKey(eventId)){
            events.get(eventId).setEventStatus(status);
            return true;
        }
        return false;
    }
    public boolean addEvent(Event event){
        if(events.containsKey(event.getEventId())){
            return false;
        }
        events.put(event.getEventId(),event);
        return true;
    }
}
