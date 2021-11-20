package CS5721.project.service.reminder;

import CS5721.project.decorator.DescriptionConcreteDecorator;
import CS5721.project.decorator.LocationConcreteDecorator;
import CS5721.project.decorator.ReminderDecorator;
import CS5721.project.decorator.TitleConcreteDecorator;
import CS5721.project.entity.person.Employee;
import CS5721.project.entity.reminder.Reminder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ReminderCreateService {

    public void execute(Employee employee, String title, String description, String location) {

        ReminderDecorator dReminder = new TitleConcreteDecorator(new Reminder(""), title);

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

        Reminder reminder = dReminder.newReminder(dReminder.addDetails(""));
        employee.getReminderList().addReminder(reminder);

    }
}

