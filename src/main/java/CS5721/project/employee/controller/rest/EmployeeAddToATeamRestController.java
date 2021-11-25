package CS5721.project.employee.controller.rest;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CS5721.project.employee.entity.Employee;
import CS5721.project.employee.service.EmployeeAddToATeamService;

@RestController
@RequestMapping(path = "/api/v1")
public class EmployeeAddToATeamRestController {

	private final EmployeeAddToATeamService employeeAddToATeamService;

	@Inject
	public EmployeeAddToATeamRestController(EmployeeAddToATeamService employeeAddToATeamService) {
		super();
		this.employeeAddToATeamService = employeeAddToATeamService;
	}

	@PostMapping(path = "/employee/add/{teamName}")
	public void addNewEmployeeToATeam(@RequestBody Employee employee, @PathVariable("teamName") String teamName) {
		employeeAddToATeamService.execute(employee, teamName);
	}

}
