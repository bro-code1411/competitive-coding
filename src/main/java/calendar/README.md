


- create update delete an event
- see other user's calendar and send an invite


- good to have 
- common time


User
String name
Address address
String email
String id
Contact contact


Calendar
User user
PriorityQueue<Event>
updateEvent(String eventId , Event event)
addEvent(Event event)
deleteEvent()
updateEventStatus(String eventId, Status status)


Event
String eventId
User host
User attendees 
Location
Type
Time startTime
Time endTime
Status ACCEPTED, REJECTED, NEUTRAL, PENDING


MService
HashMap<String, Calendar> userCalendarMap

createEvent(String hostId, List<User> attendees, Time startTime, Time endTime)
-add event in each users calendar

viewEvents(String userId)
return all event from hashmap

updateEvent(String eventId, List<User> attendees, Time startTime, Time endTime)
getEvent()
createEventObject -> host
update(String eventId, Event event) attendees


deleteEvent (String eventId)
getEvent()
delete(String eventId)
