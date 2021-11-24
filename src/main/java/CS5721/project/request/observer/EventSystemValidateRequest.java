package CS5721.project.request.observer;

import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.publisher.EventSystem;

public class EventSystemValidateRequest {
    public void execute(long eventID, long employeeID){
        EventSystem.getEventSystemInstance(OPERATIONS.values()).notifyRequestValidation(eventID, employeeID);
    }
}
