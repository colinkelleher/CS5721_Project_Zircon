package CS5721.project.request.observer;

import CS5721.project.EmployeeData;
import CS5721.project.calendar.entity.CalendarEvent;
import CS5721.project.observer.OPERATIONS;


public class EventSystemCreateEvent {
    public void execute(CalendarEvent calendarEvent, long employeeID){
        EmployeeData.getEventSystem().notifyEvent(OPERATIONS.CREATE_EVENT, calendarEvent,employeeID);
    }
}
