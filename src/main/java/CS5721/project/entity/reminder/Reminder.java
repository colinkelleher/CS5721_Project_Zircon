package CS5721.project.entity.reminder;

public class Reminder implements ReminderInterface {

    private long reminderID;
    private String title;

    public Reminder() {}

    public Reminder(long reminderID, String title){
        this.reminderID = reminderID;
        this.title = title;
    }

    public long getId() {
        return reminderID;
    }
    public void setId(long id) {
        this.reminderID = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String printReminder(){
        return "text\n";
    }
}
