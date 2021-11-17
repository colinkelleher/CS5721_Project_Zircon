package CS5721.project.decorator;

import CS5721.project.entity.reminder.Reminder;
import CS5721.project.entity.reminder.ReminderInterface;

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
        Reminder reminder = new Reminder();
        reminder.setDescription(description);
    }
}
