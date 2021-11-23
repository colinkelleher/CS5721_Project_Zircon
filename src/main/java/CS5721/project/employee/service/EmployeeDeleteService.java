package CS5721.project.employee.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import CS5721.project.employee.repository.CompanyEntityRepository;

@Service
public class EmployeeDeleteService {

	private final CompanyEntityRepository employeeRepository;

	@Inject
	public EmployeeDeleteService(CompanyEntityRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public void execute(Long employeeId) {
		employeeRepository.deleteById(employeeId);
	}
}
