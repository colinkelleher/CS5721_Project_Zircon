package CS5721.project.entity.reminder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateDecorator extends ReminderDecorator{
    public DateDecorator(ReminderInterface wrapper) {
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
