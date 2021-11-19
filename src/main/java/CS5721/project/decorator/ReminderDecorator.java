package CS5721.project.decorator;

import CS5721.project.entity.reminder.ReminderInterface;

public class ReminderDecorator implements ReminderInterface {

    private final ReminderInterface wrapper;

    public ReminderDecorator(ReminderInterface wrapper){
        this.wrapper = wrapper;
    }

    @Override
    public String printReminder(){
        return wrapper.printReminder();
    }

}
