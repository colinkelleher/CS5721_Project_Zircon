package CS5721.project.controller.employee;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CS5721.project.entity.DEPARTMENT;
import CS5721.project.service.employee.EmployeeUpdateInfoService;

@Controller
@RequestMapping(path = "")
public class EmployeeUpdateInfoActionController {

	public final EmployeeUpdateInfoService employeeUpdateInfoService;

	@Inject
	public EmployeeUpdateInfoActionController(EmployeeUpdateInfoService employeeUpdateInfoService) {
		super();
		this.employeeUpdateInfoService = employeeUpdateInfoService;
	}

	@PostMapping(path = "/info/update")
	public String updateEmployeeInfo(@RequestParam Long id, @RequestParam String name,
			@RequestParam DEPARTMENT department) {

		employeeUpdateInfoService.execute(id, name, department);

		return "redirect:" + "/info?employeeId=" + id;

	}

}
