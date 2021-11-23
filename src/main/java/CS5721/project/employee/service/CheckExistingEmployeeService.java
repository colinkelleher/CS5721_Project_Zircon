package CS5721.project.employee.service;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import CS5721.project.employee.entity.CompanyEntity;
import CS5721.project.employee.repository.CompanyEntityRepository;

@Service
public class CheckExistingEmployeeService {

	private final CompanyEntityRepository companyEntityRepository;
	private final CompanyEntityCreateService appResourceCreateService;

	@Inject
	public CheckExistingEmployeeService(CompanyEntityRepository companyEntityRepository,
			CompanyEntityCreateService appResourceCreateService) {
		this.companyEntityRepository = companyEntityRepository;
		this.appResourceCreateService = appResourceCreateService;
	}

	public boolean execute(Long employeeId) {

		Optional<CompanyEntity> optionalCompanyEntity = companyEntityRepository.findById(employeeId);
		if (optionalCompanyEntity.isEmpty()) {
			return false;
		}

		return true;
	}

}
