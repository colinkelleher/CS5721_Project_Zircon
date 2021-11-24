package CS5721.project.employee.controller.mvc;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import CS5721.project.employee.dto.CompanyEntityDto;
import CS5721.project.employee.service.EmployeeUpdateInfoService;

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
	public String updateEmployeeInfo(@ModelAttribute("employee") CompanyEntityDto employeeDto) {

		employeeUpdateInfoService.execute(employeeDto);

		return "redirect:" + "/info?employeeId=" + employeeDto.getId();

	}

}
