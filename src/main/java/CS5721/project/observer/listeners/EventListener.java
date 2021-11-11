package CS5721.project.observer.listeners;

import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.observer.OPERATIONS;

public interface EventListener {

    void update(OPERATIONS operation);

    void update(OPERATIONS operation, long id);

    void update (OPERATIONS operation, CalendarEvent event, Long employeeID);
}
