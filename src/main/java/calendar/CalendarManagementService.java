package calendar;

import java.sql.Time;
import java.util.List;
import java.util.UUID;

public interface CalendarManagementService {
    public boolean createEvent(UUID hostId, List<UUID> attendees, Time startTime, Time endTime, String location, String agenda);

    public List<Event> viewEvents(UUID userId) ;

    public void updateEvent(UUID eventId, List<UUID> attendees, Time startTime, Time endTime, UUID hostId, String location, String agenda);
    public void deleteEvent (UUID eventId, UUID hostId);
}
