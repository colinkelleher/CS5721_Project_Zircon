package CS5721.project.calendar.controller;

import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CS5721.project.calendar.entity.Calendar;
import CS5721.project.calendar.entity.CalendarEvent;
import CS5721.project.employee.service.EmployeeFindCalendarService;

@Controller
@RequestMapping(path = "")
public class CalendarScreenController {

	public final EmployeeFindCalendarService employeeFindCalendarService;

	@Inject
	public CalendarScreenController(EmployeeFindCalendarService employeeFindCalendarService) {
		super();
		this.employeeFindCalendarService = employeeFindCalendarService;
	}

	@GetMapping(path = "/calendar")
	public String wage(Model model, @RequestParam Long employeeId) {

		Calendar employeeCalendar = employeeFindCalendarService.execute(employeeId);
		Set<CalendarEvent> events = employeeCalendar.getEvents();

		model.addAttribute("employeeId", employeeId);
		model.addAttribute("events", events);

		return "calendar.html";
	}
}
