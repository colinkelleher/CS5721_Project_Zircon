package CS5721.project.controller.logingInOut;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "")
public class EmployeeWelcomePageScreenController {

	@GetMapping(path = "/menu")
	public String login(Model model, @RequestParam String employeeName, @RequestParam Long employeeId) {
		model.addAttribute("employeeName", employeeName);
		model.addAttribute("employeeId", employeeId);
		return "employeeWelcomePage.html";
	}

}
