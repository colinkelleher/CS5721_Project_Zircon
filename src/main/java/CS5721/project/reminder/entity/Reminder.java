package CS5721.project.entity.reminder;

public class Reminder extends ReminderAbstract {

    public Reminder(String _details) {
        this.details = _details;
    }

    public String addDetails(String detail) {
        return details;
    }

    public String getDetails(){
        return details;
    }

}
