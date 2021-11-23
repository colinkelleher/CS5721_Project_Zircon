package CS5721.project.request.observer;

import CS5721.project.EmployeeData;
import CS5721.project.calendar.entity.CalendarEvent;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.publisher.EventSystem;


public class EventSystemCreateRequest {
    public void execute(CalendarEvent calendarEvent, long employeeID){
        EventSystem.getEventSystemInstance(OPERATIONS.values()).notifyEvent(OPERATIONS.CREATE_REQUEST, calendarEvent,employeeID);
    }
}
