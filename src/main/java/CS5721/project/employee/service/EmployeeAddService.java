package CS5721.project.employee.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import CS5721.project.employee.entity.Employee;
import CS5721.project.employee.repository.EmployeeRepository;

@Service
public class EmployeeAddService {

	private final EmployeeRepository employeeRepository;

	@Inject
	public EmployeeAddService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public void execute(Employee employee) {
		employeeRepository.save(employee);
	}
}