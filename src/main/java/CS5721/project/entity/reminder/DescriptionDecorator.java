package CS5721.project.entity.reminder;

public class DescriptionDecorator extends ReminderDecorator {

    public DescriptionDecorator(ReminderInterface wrapper){
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

}
