package CS5721.project.employee.service;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import CS5721.project.employee.entity.CompanyEntity;
import CS5721.project.employee.repository.CompanyEntityRepository;

@Service
public class EmployeeFinderService {

	private final CompanyEntityRepository companyEntityRepository;

	@Inject
	public EmployeeFinderService(CompanyEntityRepository companyEntityRepository) {
		this.companyEntityRepository = companyEntityRepository;
	}

	public CompanyEntity execute(Long id) {

		Optional<CompanyEntity> optionalCompanyEntity = companyEntityRepository.findById(id);
		if (optionalCompanyEntity.isEmpty()) {
			return null;
		}
		return optionalCompanyEntity.get();

	}

}
