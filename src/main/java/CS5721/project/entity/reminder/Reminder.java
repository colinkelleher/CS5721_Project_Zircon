package CS5721.project.entity.reminder;

public class Reminder implements ReminderInterface {

    private long reminderID;
    private String title;
    private String description;

    public Reminder(long reminderID, String title, String reminderDesc){
        this.reminderID = reminderID;
        this.title = title;
        this.description = reminderDesc ;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public long getReminderID() {
        return reminderID;
    }
    public void setReminderID(long reminderID) {
        this.reminderID = reminderID;
    }

    public String printReminder(){
        return this.title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String reminderDesc) {
        this.description = reminderDesc;
    }

}
