package CS5721.project.employee.controller.mvc.logInOut;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "")
public class LogoutScreenController {

	@GetMapping(path = "/logout")
	public String logout(Model model) {
		return "redirect:";
	}

}
