package CS5721.project.observer.publisher;

import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.observer.listeners.EventListener;

import java.util.List;

public class EventSystem extends EventManager{

    public EventSystem(String... operations) {
        super(operations);
    }

    @Override
    public void notify(String eventType) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener: users) {
            listener.update(eventType);
        }
    }

    public void notifyEvent(String eventType, CalendarEvent event, Long id) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener: users) {
            listener.update(eventType, event, id);
        }
    }
}
