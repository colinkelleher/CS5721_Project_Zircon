package CS5721.project.service.observer;

import CS5721.project.EmployeeData;
import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.observer.OPERATIONS;


public class EventSystemCreateRequest {
    public void execute(CalendarEvent calendarEvent, long employeeID){
        EmployeeData.getEventSystem().notifyEvent(OPERATIONS.CREATE_REQUEST, calendarEvent,employeeID);
    }
}
