package CS5721.project.entity.reminder;

public class ReminderDecorator implements ReminderInterface {

    private ReminderInterface wrapper;

    public ReminderDecorator(ReminderInterface wrapper){
        this.wrapper = wrapper;
    }

    @Override
    public String printReminder(){
        return wrapper.printReminder();
    }

}
