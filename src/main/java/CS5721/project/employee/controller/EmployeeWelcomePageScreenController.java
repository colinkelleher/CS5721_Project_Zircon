package CS5721.project.employee.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CS5721.project.employee.entity.CompanyEntity;
import CS5721.project.employee.service.EmployeeFinderService;

@Controller
@RequestMapping(path = "")
public class EmployeeWelcomePageScreenController {

	public final EmployeeFinderService employeeFinderService;

	@Inject
	public EmployeeWelcomePageScreenController(EmployeeFinderService employeeFinderService) {
		super();
		this.employeeFinderService = employeeFinderService;
	}

	@GetMapping(path = "/menu")
	public String login(Model model, @RequestParam Long employeeId) {

		CompanyEntity employee = employeeFinderService.execute(employeeId);
		String employeeName = employee.getName();

		model.addAttribute("employeeName", employeeName);
		model.addAttribute("employeeId", employeeId);

		return "employeeWelcomePage.html";
	}

}
