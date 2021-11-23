package CS5721.project.employee.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import CS5721.project.employee.entity.CompanyEntity;
import CS5721.project.employee.repository.CompanyEntityRepository;

@Service
public class CompanyEntityCreateService {
	private final CompanyEntityRepository companyEntityRepository;

	@Inject
	public CompanyEntityCreateService(CompanyEntityRepository companyEntityRepository) {
		this.companyEntityRepository = companyEntityRepository;
	}

	public void execute(CompanyEntity appResource) {
		companyEntityRepository.save(appResource);
	}
}
