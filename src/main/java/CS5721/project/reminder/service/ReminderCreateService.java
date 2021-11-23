package CS5721.project.reminder.service;

import java.util.Objects;

import CS5721.project.employee.entity.CompanyEntity;
import org.springframework.stereotype.Service;

import CS5721.project.decorator.DescriptionConcreteDecorator;
import CS5721.project.decorator.LocationConcreteDecorator;
import CS5721.project.decorator.ReminderDecorator;
import CS5721.project.decorator.TitleConcreteDecorator;
import CS5721.project.employee.entity.Employee;
import CS5721.project.reminder.entity.Reminder;

@Service
public class ReminderCreateService {

    public void execute(CompanyEntity employee, String title, String description, String location) {

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

