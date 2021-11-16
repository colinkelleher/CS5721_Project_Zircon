package CS5721.project.entity.reminder;

import CS5721.project.entity.calendar.CalendarEvent;

import java.util.ArrayList;

public class ReminderList {
    private final ArrayList<Reminder> reminders;

    public ReminderList() {
        this.reminders = new ArrayList<>();
    }

    public void addReminder(Reminder reminder) {
        reminders.add(reminder);
    }

    public ArrayList<Reminder> getReminderList() {return reminders;}

}
