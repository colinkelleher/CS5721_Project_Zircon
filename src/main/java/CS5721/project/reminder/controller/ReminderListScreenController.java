package CS5721.project.controller.reminder;

import CS5721.project.entity.reminder.Reminder;
import CS5721.project.entity.reminder.ReminderAbstract;
import CS5721.project.entity.reminder.ReminderList;
import CS5721.project.service.employee.EmployeeFindReminderListService;
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

        model.addAttribute("employeeId", employeeId);
        model.addAttribute("reminders", reminders);
        return "reminderList.html";
    }
}
