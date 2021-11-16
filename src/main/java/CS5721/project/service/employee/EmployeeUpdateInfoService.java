package CS5721.project.service.employee;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import CS5721.project.entity.DEPARTMENT;
import CS5721.project.entity.person.Employee;

@Service
public class EmployeeUpdateInfoService {

	private final EmployeeFinderService employeeFinderService;

	@Inject
	public EmployeeUpdateInfoService(EmployeeFinderService employeeFinderService) {
		this.employeeFinderService = employeeFinderService;
	}

	public void execute(Long employeeId, String name, DEPARTMENT department) {

		Employee employee = employeeFinderService.execute(employeeId);
		
		employee.setName(name);
		employee.setDepartment(department);

	}

}
