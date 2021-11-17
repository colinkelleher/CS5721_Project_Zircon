package CS5721.project.controller.reminder;

import CS5721.project.decorator.ReminderDecorator;
import CS5721.project.entity.reminder.Reminder;
import CS5721.project.entity.reminder.ReminderList;
import CS5721.project.service.employee.EmployeeFindCalendarService;
import CS5721.project.service.employee.EmployeeFindReminderListService;
import CS5721.project.service.wage.WageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.ArrayList;

@Controller
@RequestMapping(path = "")
public class ReminderListScreenController {

    public final EmployeeFindReminderListService employeeFindReminderListService;

    @Inject
    public ReminderListScreenController(EmployeeFindReminderListService employeeFindReminderListService) {
        super();
        this.employeeFindReminderListService = employeeFindReminderListService;
    }

    @GetMapping(path = "/reminderList")
    public String reminderList(Model model, @RequestParam Long employeeId) {

        ReminderList reminderList = employeeFindReminderListService.execute(employeeId);
        ArrayList<Reminder> reminders = reminderList.getReminderList();
        /*for(int i=0; i<reminders.size(); i++){
            String reminder = reminders.get(i).printReminder();
            model.addAttribute("reminder"+i, reminder);
        }*/

        model.addAttribute("employeeId", employeeId);
        model.addAttribute("reminders", reminders);
        return "reminderList.html";
    }
}
