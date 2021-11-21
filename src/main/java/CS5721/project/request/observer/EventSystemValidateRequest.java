package CS5721.project.request.observer;

import CS5721.project.EmployeeData;

public class EventSystemValidateRequest {
    public void execute(long eventID, long employeeID){
        EmployeeData.getEventSystem().notifyRequestValidation(eventID, employeeID);
    }
}
