package CS5721.project.observer.listeners;

import CS5721.project.entity.calendar.CalendarEvent;

public interface EventListener {

    void update(String eventType);

    void update (String eventType, CalendarEvent event, Long employeeID);
}
