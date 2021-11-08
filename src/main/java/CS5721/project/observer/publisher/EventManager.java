package CS5721.project.observer.publisher;

import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.listeners.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class EventManager {
    Map<OPERATIONS, List<EventListener>> listeners = new HashMap<>();

    public EventManager(OPERATIONS[] operations) {
        for (OPERATIONS operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }
    public void subscribe(OPERATIONS operation, EventListener listener) {
        List<EventListener> users = listeners.get(operation);
        users.add(listener);
    }

    public void unsubscribe(OPERATIONS operation, EventListener listener) {
        List<EventListener> users = listeners.get(operation);
        users.add(listener);
    }

    public abstract void notify(OPERATIONS operation);

    public abstract void notifyEvent(OPERATIONS operation, CalendarEvent event, Long id);
}
