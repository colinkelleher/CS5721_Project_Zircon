package CS5721.project.employee.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import CS5721.project.employee.dto.CompanyEntityDto;
import CS5721.project.employee.entity.CompanyEntity;
import CS5721.project.employee.entity.DEPARTMENT;
import CS5721.project.employee.repository.CompanyEntityRepository;

@Service
public class EmployeeUpdateInfoService {

	private final CompanyEntityRepository employeeRepository;
	private final EmployeeFinderService employeeFinderService;

	@Inject
	public EmployeeUpdateInfoService(CompanyEntityRepository employeeRepository,
			EmployeeFinderService employeeFinderService) {
		this.employeeRepository = employeeRepository;
		this.employeeFinderService = employeeFinderService;
	}

	public void execute(CompanyEntityDto employeeDto) {

		Long employeeId = employeeDto.getId();
		CompanyEntity employee = employeeFinderService.execute(employeeId);

		String name = employeeDto.getName();
		DEPARTMENT department = employeeDto.getDepartment();

		employee.setName(name);
		employee.setDepartment(department);
		employeeRepository.save(employee);

	}

}
