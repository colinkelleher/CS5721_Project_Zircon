package CS5721.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import CS5721.project.employee.entity.Employee;

@Controller
@RequestMapping(path = "")
public class ZirconWelcomePageController {

	@GetMapping(path = "/")
	public String welcomePage(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
//		return "index.html";
		return "clock.html";
	}

}
