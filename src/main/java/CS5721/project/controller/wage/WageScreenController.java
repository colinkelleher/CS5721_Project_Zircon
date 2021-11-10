package CS5721.project.controller.wage;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CS5721.project.EmployeeData;
import CS5721.project.entity.calendar.Calendar;
import CS5721.project.entity.person.Employee;
import CS5721.project.service.wage.WageService;

@Controller
@RequestMapping(path = "")
public class WageScreenController {

	public final WageService wageService;

	@Inject
	public WageScreenController(WageService wageService) {
		super();
		this.wageService = wageService;
	}

	@GetMapping(path = "/wage")
	public String wage(Model model, @RequestParam String employeeName, @RequestParam Long employeeId) {

		model.addAttribute("employeeName", employeeName);
		model.addAttribute("employeeId", employeeId);

		Employee employee = EmployeeData.getEmployeeDetails(employeeId);
		Calendar employeeCalendar = employee.getCalendar();

		double weeklyWage = wageService.getWeeklyWage(employeeCalendar);
		double monthlyWage = wageService.getMonthlyWage(employeeCalendar);

		model.addAttribute("weeklyWage", weeklyWage);
		model.addAttribute("monthlyWage", monthlyWage);

		return "wage.html";
	}
}
