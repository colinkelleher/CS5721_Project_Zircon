package CS5721.project.employee.service;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import CS5721.project.employee.entity.Employee;
import CS5721.project.employee.repository.EmployeeRepository;

@Service
public class CheckExistingEmployeeService {

	private final EmployeeRepository employeeRepository;

	@Inject
	public CheckExistingEmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public boolean execute(Long employeeId) {

		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
		if (optionalEmployee.isEmpty()) {
			return false;
		}
		return true;
	}

}
