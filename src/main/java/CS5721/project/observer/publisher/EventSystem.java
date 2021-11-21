package CS5721.project.observer.publisher;

import java.util.List;

import CS5721.project.calendar.entity.CalendarEvent;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.listeners.EventListener;

public class EventSystem extends EventManager {

	private static EventSystem eventSystemInstance;

	public EventSystem(OPERATIONS[] operations) {
		super(operations);
	}

	@Override
	public void notify(OPERATIONS operation) {
		List<EventListener> users = listeners.get(operation);
		for (EventListener listener : users) {
			listener.update(operation);
		}
	}

	public void notifyRequestValidation(long eventID, long employeeID){
		List<EventListener> users = listeners.get(OPERATIONS.VALIDATE_REQUEST);
		for (EventListener listener : users) {
			listener.update(OPERATIONS.VALIDATE_REQUEST, eventID, employeeID);
		}
	}

	public void notifyEvent(OPERATIONS operation, CalendarEvent event, Long employeeID) {
		List<EventListener> users = listeners.get(operation);
		for (EventListener listener : users) {
			listener.update(operation, event, employeeID);
		}
	}

	public static EventSystem getEventSystemInstance(OPERATIONS[] operations) {
		if (EventSystem.eventSystemInstance == null) {
			EventSystem.eventSystemInstance = new EventSystem(operations);
		}
		return EventSystem.eventSystemInstance;
	}

}
