package CS5721.project.controller.clocking;

import java.time.LocalDateTime;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CS5721.project.entity.person.Employee;
import CS5721.project.service.clocking.ClockingService;
import CS5721.project.service.employee.EmployeeFinderService;

@Controller
@RequestMapping(path = "")
public class ClockingActionController {

	public final ClockingService clockingService;
	public final EmployeeFinderService employeeFinderService;

	@Inject
	public ClockingActionController(ClockingService clockingService, EmployeeFinderService employeeFinderService) {
		super();
		this.clockingService = clockingService;
		this.employeeFinderService = employeeFinderService;
	}

	@PostMapping(path = "/clocking")
	public String clocking(Model model, @RequestParam Long employeeId) {

		Employee employee = employeeFinderService.execute(employeeId);

		LocalDateTime clockingTime = LocalDateTime.now();
		String clockingStatus = clockingService.execute(employee, clockingTime);

		model.addAttribute("employeeId", employeeId);
		model.addAttribute("clockingStatus", clockingStatus);
		model.addAttribute("clockingTime", clockingTime);

		return "clockingConfirmation.html";
	}
}
