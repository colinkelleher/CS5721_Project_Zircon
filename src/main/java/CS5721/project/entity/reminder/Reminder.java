package CS5721.project.entity.reminder;

public class Reminder implements ReminderInterface {

    private long employeeID;
    private long toDoID;
    private String title;

    public Reminder() {}

    public Reminder(long employeeID, long toDoID, String title){
        this.employeeID = employeeID;
        this.toDoID = toDoID;
        this.title = title;
    }

    public long getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public long getToDoID() {
        return toDoID;
    }
    public void setToDoID(long toDoID) {
        this.toDoID = toDoID;
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
