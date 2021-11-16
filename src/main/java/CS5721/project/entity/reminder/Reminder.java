package CS5721.project.entity.reminder;

public class Reminder implements ReminderInterface {

    private long employeeID;
    private long reminderID;
    private String title;

    public Reminder() {}

    public Reminder(long employeeID, long reminderID, String title){
        this.employeeID = employeeID;
        this.reminderID = reminderID;
        this.title = title;
    }

    public long getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
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
