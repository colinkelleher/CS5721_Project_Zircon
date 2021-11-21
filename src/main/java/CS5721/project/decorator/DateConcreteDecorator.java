package CS5721.project.decorator;

import CS5721.project.entity.reminder.ReminderInterface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import CS5721.project.reminder.entity.ReminderInterface;

public class DateConcreteDecorator extends ReminderDecorator {
    public DateConcreteDecorator(ReminderInterface wrapper) {
        super(wrapper);
    }

    @Override
    public String printReminder() {
        String reminder = super.printReminder();
        return addDate(reminder);
    }

    public String addDate(String reminder) {
        LocalDateTime _date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        String date = _date.format(formatter);
        return reminder + date;
    }
}
