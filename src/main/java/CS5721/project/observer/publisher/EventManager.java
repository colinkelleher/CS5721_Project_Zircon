package CS5721.project.observer.publisher;

import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.observer.listeners.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class EventManager {
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String...operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }
    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public abstract void notify(String eventType);

    public abstract void notifyEvent(String eventType, CalendarEvent event, Long id);
}
