package calendar;

import java.sql.Time;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Event {
    private UUID eventId;
    private UUID hostId;
    private List<UUID> attendees;
    private String location;
    private Time startTime;
    private Time endTime;
    private String agenda;
    private EventStatus eventStatus;

    public Event(UUID hostId, List<UUID> attendees, String location, Time startTime, Time endTime, String agenda) {
        this.eventId = UUID.randomUUID();
        this.hostId = hostId;
        this.attendees = attendees;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.agenda = agenda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(eventId, event.eventId) &&
                Objects.equals(hostId, event.hostId) &&
                Objects.equals(attendees, event.attendees) &&
                Objects.equals(location, event.location) &&
                Objects.equals(startTime, event.startTime) &&
                Objects.equals(endTime, event.endTime) &&
                Objects.equals(agenda, event.agenda) &&
                eventStatus == event.eventStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, hostId, attendees, location, startTime, endTime, agenda, eventStatus);
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public EventStatus getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(EventStatus eventStatus) {
        this.eventStatus = eventStatus;
    }


    public UUID getEventId() {
        return eventId;
    }

    public UUID getHostId() {
        return hostId;
    }

    public void setHostId(UUID hostId) {
        this.hostId = hostId;
    }

    public List<UUID> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<UUID> attendees) {
        this.attendees = attendees;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
