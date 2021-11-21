package CS5721.project.reminder.service;

import CS5721.project.decorator.DescriptionConcreteDecorator;
import CS5721.project.decorator.LocationConcreteDecorator;
import CS5721.project.decorator.ReminderDecorator;
import CS5721.project.employee.entity.Employee;
import CS5721.project.reminder.entity.Reminder;

import org.springframework.stereotype.Service;

@Service
public class ReminderCreateService {

    public void execute(Employee employee, String title, String description) {

        ReminderDecorator withDescription = new DescriptionConcreteDecorator(new Reminder(1L,"Reminder",description));
        withDescription.printReminder();

        // Only description
        if (!Objects.equals(description, "") && Objects.equals(location, "")) {
            dReminder = new DescriptionConcreteDecorator(dReminder, description);
        } else { // description AND location
            if (!Objects.equals(description, "") && !Objects.equals(location, "")) {
                dReminder = new LocationConcreteDecorator(new DescriptionConcreteDecorator(dReminder, description), location);
            } else { // Only location
                if (Objects.equals(description, "") && !Objects.equals(location, "")) {
                    dReminder = new LocationConcreteDecorator(dReminder, location);
                }
            }
        }

        Reminder reminder = new Reminder(3L, title,description);
        reminder.setDescription(description);
        employee.getReminderList().addReminder(reminder);

    }
}

