package CS5721.project.employee.controller.rest;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CS5721.project.employee.entity.Employee;
import CS5721.project.employee.service.EmployeeFindAllInTeamService;

@RestController
@RequestMapping(path = "/api/v1")
public class EmployeeListRestController {

	private final EmployeeFindAllInTeamService employeeFindAllInTeamService;

	@Inject
	public EmployeeListRestController(EmployeeFindAllInTeamService employeeFindAllInTeamService) {
		super();
		this.employeeFindAllInTeamService = employeeFindAllInTeamService;
	}

	@GetMapping(path = "/employee/list/{teamName}")
	public List<Employee> getTeamMembers(@PathVariable("teamName") String teamName) {
		return employeeFindAllInTeamService.execute(teamName);
	}

}
