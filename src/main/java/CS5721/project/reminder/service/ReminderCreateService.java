package CS5721.project.reminder.service;

import java.util.Objects;

import CS5721.project.employee.entity.CompanyEntity;
import CS5721.project.reminder.entity.ReminderList;
import CS5721.project.reminder.repository.ReminderListRepository;
import CS5721.project.reminder.repository.ReminderRepository;
import org.springframework.stereotype.Service;

import CS5721.project.decorator.DescriptionConcreteDecorator;
import CS5721.project.decorator.LocationConcreteDecorator;
import CS5721.project.decorator.ReminderDecorator;
import CS5721.project.decorator.TitleConcreteDecorator;
import CS5721.project.employee.entity.Employee;
import CS5721.project.reminder.entity.Reminder;

@Service
public class ReminderCreateService {

    public final ReminderRepository reminderRepository;
    public final ReminderListRepository reminderListRepository;

    public ReminderCreateService(ReminderRepository reminderRepository,
                                 ReminderListRepository reminderListRepository) {
        this.reminderRepository = reminderRepository;
        this.reminderListRepository = reminderListRepository;
    }

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
        ReminderList list = employee.getReminderList();
        reminder.setReminderList(list);
        reminderRepository.save(reminder);
        reminderListRepository.save(list);
        list.addReminder(reminder);

    }
}

