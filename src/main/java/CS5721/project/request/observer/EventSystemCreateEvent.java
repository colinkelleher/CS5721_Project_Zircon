package CS5721.project.request.observer;

import CS5721.project.calendar.entity.CalendarEvent;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.publisher.EventSystem;


public class EventSystemCreateEvent {
    public void execute(CalendarEvent calendarEvent, long employeeID){
        EventSystem.getEventSystemInstance(OPERATIONS.values()).notifyEvent(OPERATIONS.CREATE_EVENT, calendarEvent,employeeID);
    }
}
