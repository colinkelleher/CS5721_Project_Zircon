package CS5721.project.employee.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import CS5721.project.employee.entity.CompanyEntity;
import CS5721.project.employee.entity.Employee;
import CS5721.project.employee.repository.CompanyEntityRepository;

@Service
public class EmployeeAddToATeamService {

	private final TeamFinderService teamFinderService;
	private final CompanyEntityRepository companyEntityRepository;

	@Inject
	public EmployeeAddToATeamService(TeamFinderService teamFinderService,
			CompanyEntityRepository companyEntityRepository) {
		this.teamFinderService = teamFinderService;
		this.companyEntityRepository = companyEntityRepository;
	}

	public void execute(Employee employee, String teamName) {
		companyEntityRepository.save(employee);

		CompanyEntity team = teamFinderService.execute(teamName);
		team.add(employee);
		companyEntityRepository.save(team);
	}

}
