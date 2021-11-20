package CS5721.project.decorator;

import CS5721.project.entity.reminder.ReminderAbstract;

public class LocationConcreteDecorator extends ReminderDecorator {

    private final ReminderAbstract wrapper;
    private String location;

    public LocationConcreteDecorator(ReminderAbstract wrapper, String description){
        this.wrapper = wrapper;
        this.location = description;
    }

    @Override
    public String addDetails(String detail) {
        return wrapper.addDetails(detail) + " - Location: " + location;
    }

}