package CS5721.project.decorator;

import CS5721.project.entity.reminder.ReminderInterface;

public class LocationConcreteDecorator extends ReminderDecorator {

    public LocationConcreteDecorator(ReminderInterface wrapper){
        super(wrapper);
    }

    @Override
    public String printReminder() {
        String _text = super.printReminder();
        return addTitle(_text);
    }

    private String addTitle(String text){
        return "Here is a location.\n" + text;
    }

}