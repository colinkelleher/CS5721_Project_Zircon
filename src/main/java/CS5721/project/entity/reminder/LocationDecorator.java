package CS5721.project.entity.reminder;

public class LocationDecorator extends ReminderDecorator {

    public LocationDecorator(ReminderInterface wrapper){
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