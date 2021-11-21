package CS5721.project.wage.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CS5721.project.calendar.entity.Calendar;
import CS5721.project.employee.service.EmployeeFindCalendarService;
import CS5721.project.wage.service.WageService;

import java.time.Month;

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
	public String wage(Model model, @RequestParam Long employeeId, @RequestParam(required = false) String previousMonthWage) {

		Calendar employeeCalendar = employeeFindCalendarService.execute(employeeId);

		double weeklyWage = wageService.getWeeklyWage(employeeCalendar);
		double monthlyWage = wageService.getMonthlyWage(employeeCalendar);

		model.addAttribute("employeeId", employeeId);
		model.addAttribute("weeklyWage", weeklyWage);
		model.addAttribute("monthlyWage", monthlyWage);
		model.addAttribute("previousMonthWage", previousMonthWage);

		return "wage.html";
	}
}
