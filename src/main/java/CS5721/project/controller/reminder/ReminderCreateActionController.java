package CS5721.project.controller.reminder;

import CS5721.project.entity.person.Employee;
import CS5721.project.service.employee.EmployeeFinderService;
import CS5721.project.service.reminder.ReminderCreateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

@Controller
@RequestMapping(path = "")
public class ReminderCreateActionController {

    public final ReminderCreateService reminderCreateService;
    public final EmployeeFinderService employeeFinderService;

    @Inject
    public ReminderCreateActionController(ReminderCreateService reminderCreateService, EmployeeFinderService employeeFinderService){
        super();
        this.reminderCreateService = reminderCreateService;
        this.employeeFinderService = employeeFinderService;
    }

    @PostMapping(path = "/createReminder")
    public String createReminder(@RequestParam Long employeeId, @RequestParam String title,
                                 @RequestParam(required = false) String description){

        Employee employee = employeeFinderService.execute(employeeId);
        reminderCreateService.execute(employee, title, description);

        return "redirect:" + "/reminderList?employeeId="+ employeeId;
    }
}
