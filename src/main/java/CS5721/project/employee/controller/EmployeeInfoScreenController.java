package CS5721.project.employee.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CS5721.project.employee.entity.Employee;
import CS5721.project.employee.service.EmployeeFinderService;

@Controller
@RequestMapping(path = "")
public class EmployeeInfoScreenController {

	public final EmployeeFinderService employeeFinderService;

	@Inject
	public EmployeeInfoScreenController(EmployeeFinderService employeeFinderService) {
		super();
		this.employeeFinderService = employeeFinderService;
	}

	@GetMapping(path = "/info")
	public String personalInfo(Model model, @RequestParam Long employeeId) {

		Employee employee = employeeFinderService.execute(employeeId);
		model.addAttribute("employee", employee);

		return "employeeInfo.html";
	}

}
