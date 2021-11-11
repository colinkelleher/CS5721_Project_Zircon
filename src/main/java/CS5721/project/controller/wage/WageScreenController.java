package CS5721.project.controller.wage;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CS5721.project.entity.calendar.Calendar;
import CS5721.project.service.employee.EmployeeFindCalendarService;
import CS5721.project.service.wage.WageService;

@Controller
@RequestMapping(path = "")
public class WageScreenController {

	public final WageService wageService;
	public final EmployeeFindCalendarService employeeFindCalendarService;

	@Inject
	public WageScreenController(WageService wageService, EmployeeFindCalendarService employeeFindCalendarService) {
		super();
		this.wageService = wageService;
		this.employeeFindCalendarService = employeeFindCalendarService;
	}

	@GetMapping(path = "/wage")
	public String wage(Model model, @RequestParam Long employeeId) {

		Calendar employeeCalendar = employeeFindCalendarService.execute(employeeId);

		double weeklyWage = wageService.getWeeklyWage(employeeCalendar);
		double monthlyWage = wageService.getMonthlyWage(employeeCalendar);

		model.addAttribute("employeeId", employeeId);
		model.addAttribute("weeklyWage", weeklyWage);
		model.addAttribute("monthlyWage", monthlyWage);

		return "wage.html";
	}
}
