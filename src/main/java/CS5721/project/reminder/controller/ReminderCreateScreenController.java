package CS5721.project.reminder.controller;

import CS5721.project.employee.entity.Employee;
import CS5721.project.employee.service.EmployeeFinderService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

@Controller
@RequestMapping(path = "")
public class ReminderCreateScreenController {

    public final EmployeeFinderService employeeFinderService;

    @Inject
    public ReminderCreateScreenController(EmployeeFinderService employeeFinderService) {
        super();
        this.employeeFinderService = employeeFinderService;
    }

    @GetMapping(path = "/createReminder")
    public String createReminder(Model model, @RequestParam Long employeeId) {

        Employee employee = employeeFinderService.execute(employeeId);
        model.addAttribute("employee", employee);

        return "createReminder.html";
    }
}
