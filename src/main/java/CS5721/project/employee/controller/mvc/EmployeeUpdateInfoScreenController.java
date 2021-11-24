package CS5721.project.employee.controller.mvc;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CS5721.project.employee.dto.CompanyEntityDto;
import CS5721.project.employee.entity.CompanyEntity;
import CS5721.project.employee.entity.DEPARTMENT;
import CS5721.project.employee.service.EmployeeFinderService;

@Controller
@RequestMapping(path = "")
public class EmployeeUpdateInfoScreenController {

	public final EmployeeFinderService employeeFinderService;

	@Inject
	public EmployeeUpdateInfoScreenController(EmployeeFinderService employeeFinderService) {
		super();
		this.employeeFinderService = employeeFinderService;
	}

	@GetMapping(path = "/info/update")
	public String personalInfo(Model model, @RequestParam Long employeeId) {

		CompanyEntity employee = employeeFinderService.execute(employeeId);
		CompanyEntityDto employeeDto = new CompanyEntityDto(employee);
		model.addAttribute("employee", employeeDto);

		DEPARTMENT[] departmentList = DEPARTMENT.values();
		model.addAttribute("departmentList", departmentList);

		return "employeeUpdateInfo.html";
	}

}
