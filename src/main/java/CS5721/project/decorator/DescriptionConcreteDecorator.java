package CS5721.project.decorator;

import CS5721.project.reminder.entity.Reminder;
import CS5721.project.reminder.entity.ReminderInterface;

public class DescriptionConcreteDecorator extends ReminderDecorator {

    public DescriptionConcreteDecorator(ReminderInterface wrapper){
        super(wrapper);
    }

    @Override
    public String printReminder() {
        String _text = super.printReminder();
        return addDescription(_text);
    }
    private String addDescription(String text){
        return text + "Here is a description.\n";
    }

    public void setDescription(String description){
        Reminder reminder = new Reminder(1L,"Reminder","description goes here");
        reminder.setDescription(description);
    }
}
