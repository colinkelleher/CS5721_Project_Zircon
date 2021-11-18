package CS5721.project.service.reminder;

import CS5721.project.decorator.DescriptionConcreteDecorator;
import CS5721.project.decorator.ReminderDecorator;
import CS5721.project.entity.person.Employee;
import CS5721.project.entity.reminder.Reminder;
import org.springframework.stereotype.Service;

@Service
public class ReminderCreateService {

    public void execute(Employee employee, String title, String description) {

        ReminderDecorator withDescription = new DescriptionConcreteDecorator(new Reminder(1L,"Reminder"));
        withDescription.printReminder();


        Reminder reminder = new Reminder(3L, title);
        reminder.setDescription(description);
        employee.getReminderList().addReminder(reminder);
    }
}
