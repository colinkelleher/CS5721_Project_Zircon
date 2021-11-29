package CS5721.project.employee.controller.rest;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CS5721.project.builder.Director;
import CS5721.project.builder.EmployeeBuilder;
import CS5721.project.employee.dto.CompanyEntityDto;
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
	public void addNewEmployeeToATeam(@RequestBody CompanyEntityDto employeeDto,
			@PathVariable("teamName") String teamName) {

		Director director = new Director();
		EmployeeBuilder employeeBuilder = new EmployeeBuilder();
		director.constructFromDto(employeeBuilder, employeeDto);
		Employee employee = employeeBuilder.getResult();

		employeeAddToATeamService.execute(employee, teamName);
	}

}
