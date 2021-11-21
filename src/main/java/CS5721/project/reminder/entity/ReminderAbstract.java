package CS5721.project.entity.reminder;

public abstract class ReminderAbstract {
    String details = "";

    public String addDetails(String detail) {
        return detail;
    }

    public Reminder newReminder(String _details){
        //String _details = addDetails("");
        return new Reminder(_details);
    }

}
