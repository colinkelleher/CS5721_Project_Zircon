package CS5721.project.employee.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import CS5721.project.employee.dto.EmployeeDto;
import CS5721.project.employee.entity.DEPARTMENT;
import CS5721.project.employee.entity.Employee;
import CS5721.project.employee.repository.EmployeeRepository;

@Service
public class EmployeeUpdateInfoService {

	private final EmployeeRepository employeeRepository;
	private final EmployeeFinderService employeeFinderService;

	@Inject
	public EmployeeUpdateInfoService(EmployeeRepository employeeRepository,
			EmployeeFinderService employeeFinderService) {
		this.employeeRepository = employeeRepository;
		this.employeeFinderService = employeeFinderService;
	}

	public void execute(EmployeeDto employeeDto) {

		Long employeeId = employeeDto.getId();
		Employee employee = employeeFinderService.execute(employeeId);

		String name = employeeDto.getName();
		DEPARTMENT department = employeeDto.getDepartment();

		employee.setName(name);
		employee.setDepartment(department);
		employeeRepository.save(employee);

	}

}
