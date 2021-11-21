package CS5721.project.wage.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CS5721.project.calendar.entity.Calendar;
import CS5721.project.employee.service.EmployeeFindCalendarService;
import CS5721.project.wage.service.WagePreviousMonthService;

@Controller
@RequestMapping(path = "")
public class WageActionController {

	public final WagePreviousMonthService wagePreviousMonthService;
	public final EmployeeFindCalendarService employeeFindCalendarService;

	@Inject
	public WageActionController(WagePreviousMonthService wagePreviousMonthService,
			EmployeeFindCalendarService employeeFindCalendarService) {
		super();
		this.wagePreviousMonthService = wagePreviousMonthService;
		this.employeeFindCalendarService = employeeFindCalendarService;
	}

	@PostMapping(path = "/previousMonthWage")
	public String previousWage(Model model, @RequestParam Long employeeId, @RequestParam String month) {

		Calendar calendar = employeeFindCalendarService.execute(employeeId);

		DateTimeFormatter _formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(month, _formatter);

		double previousMonthWage = wagePreviousMonthService.getMonthlyWage(calendar, date.getMonth());

		return "redirect:" + "/wage?employeeId=" + employeeId + "&previousMonthWage=" + previousMonthWage;
	}
}
