package CS5721.project.controller;

import CS5721.project.entity.person.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "")
public class EmployeeWelcomePageScreenController {

	@GetMapping(path = "/menu")
	public String login(Model model, @RequestParam Long employeeId) {
		model.addAttribute("employeeId", employeeId);
		return "employeeWelcomePage.html";
	}

}
