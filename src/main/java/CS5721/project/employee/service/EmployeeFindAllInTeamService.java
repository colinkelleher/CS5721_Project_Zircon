package CS5721.project.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import CS5721.project.employee.entity.CompanyEntity;
import CS5721.project.employee.entity.Employee;
import CS5721.project.employee.repository.CompanyEntityRepository;

@Service
public class EmployeeFindAllInTeamService {

	private final CompanyEntityRepository companyEntityRepository;

	@Inject
	public EmployeeFindAllInTeamService(CompanyEntityRepository companyEntityRepository) {
		this.companyEntityRepository = companyEntityRepository;
	}

	public List<Employee> execute(String teamName) {
		Optional<CompanyEntity> optionalTeam = companyEntityRepository.findByName(teamName);
		if (optionalTeam.isEmpty()) {
			return null;
		} else {
			CompanyEntity team = optionalTeam.get();
			List<Employee> teamEmployees = team.getChildrenEntities(new ArrayList<>());
			return teamEmployees;
		}
	}

}
