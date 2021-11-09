package CS5721.project.controller.loging;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import CS5721.project.entity.person.Employee;

@Controller
@RequestMapping(path = "")
public class LoginScreenController {

	@GetMapping(path = "/login")
	public String login(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "login.html";
	}

}
