package CS5721.project.employee.service;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import CS5721.project.employee.entity.CompanyEntity;
import CS5721.project.employee.repository.CompanyEntityRepository;

@Service
public class TeamFinderService {

	private final CompanyEntityRepository companyEntityRepository;

	@Inject
	public TeamFinderService(CompanyEntityRepository companyEntityRepository) {
		this.companyEntityRepository = companyEntityRepository;
	}

	public CompanyEntity execute(String teamName) {

		Optional<CompanyEntity> optionalCompanyEntity = companyEntityRepository.findByName(teamName);
		if (optionalCompanyEntity.isEmpty()) {
			return null;
		}
		return optionalCompanyEntity.get();

	}

}