package CS5721.project.controller.logingInOut;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CS5721.project.service.logingInOut.CheckExistingEmployeeService;

@Controller
@RequestMapping(path = "")
public class LoginActionController {

	public final CheckExistingEmployeeService checkExistingEmployeeService;

	@Inject
	public LoginActionController(CheckExistingEmployeeService checkExistingEmployeeService) {
		super();
		this.checkExistingEmployeeService = checkExistingEmployeeService;
	}

	@PostMapping(path = "/login")
	public String login(@RequestParam Long employeeId) {

		boolean isExisting = checkExistingEmployeeService.execute(employeeId);

		if (!isExisting) {
			return null;
		}
		return "redirect:" + "/menu?employeeId=" + employeeId;

	}

}
