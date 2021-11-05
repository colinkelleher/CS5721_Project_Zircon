package CS5721.project.observer.listeners;

import CS5721.project.entity.calendar.CalendarEvent;

import java.io.File;

public interface EventListener {
    void update (String eventType, CalendarEvent event);

    void update (String eventType, CalendarEvent event, Long employeeID);
}
