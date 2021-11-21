package CS5721.project.employee.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import CS5721.project.employee.repository.EmployeeRepository;

@Service
public class EmployeeDeleteService {

	private final EmployeeRepository employeeRepository;

	@Inject
	public EmployeeDeleteService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public void execute(Long employeeId) {
		employeeRepository.deleteById(employeeId);
	}
}
