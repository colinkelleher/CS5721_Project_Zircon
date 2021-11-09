package CS5721.project.controller.loging;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import CS5721.project.entity.person.Employee;

@Controller
@RequestMapping(path = "")
public class LoginActionController {

	@PostMapping(path = "/login")
	public String login(@ModelAttribute Employee employee) {

		return "redirect:" + "/menu?employeeId=" + employee.getId();

	}

}
