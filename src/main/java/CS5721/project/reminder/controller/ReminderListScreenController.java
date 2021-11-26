package CS5721.project.reminder.controller;

import java.util.Set;

import javax.inject.Inject;

import CS5721.project.employee.entity.CompanyEntity;
import CS5721.project.employee.entity.Employee;
import CS5721.project.employee.service.EmployeeFinderService;
import CS5721.project.reminder.entity.ReminderAbstract;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CS5721.project.employee.service.EmployeeFindReminderListService;
import CS5721.project.reminder.entity.Reminder;
import CS5721.project.reminder.entity.ReminderList;

@Controller
@RequestMapping(path = "")
public class ReminderListScreenController {

	public final EmployeeFindReminderListService employeeFindReminderListService;
	public final EmployeeFinderService employeeFinderService;

	@Inject
	public ReminderListScreenController(EmployeeFindReminderListService employeeFindReminderListService, EmployeeFinderService employeeFinderService) {
		super();
		this.employeeFindReminderListService = employeeFindReminderListService;
		this.employeeFinderService = employeeFinderService;
	}

	@GetMapping(path = "/reminderList")
	public String reminderList(Model model, @RequestParam Long employeeId) {

		CompanyEntity employee = employeeFinderService.execute(employeeId);
		ReminderList reminderList = employeeFindReminderListService.execute(employeeId);
		Set<Reminder> reminders = reminderList.getReminderList();

		model.addAttribute("employeeName", employee.getName());
		model.addAttribute("employeeId", employeeId);
		model.addAttribute("reminders", reminders);
		return "reminderList.html";
	}
}
