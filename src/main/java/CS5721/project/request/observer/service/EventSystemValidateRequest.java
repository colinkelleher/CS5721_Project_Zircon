package CS5721.project.request.observer.service;

import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.publisher.EventSystem;
import org.springframework.stereotype.Service;

@Service
public class EventSystemValidateRequest {
    public void execute(long eventID, long employeeID){
        EventSystem.getEventSystemInstance(OPERATIONS.values()).notifyRequestValidation(eventID, employeeID);
    }
}
