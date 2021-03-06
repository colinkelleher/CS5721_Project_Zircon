package CS5721.project.employee.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import CS5721.project.calendar.entity.Calendar;
import CS5721.project.employee.entity.CompanyEntity;

@Service
public class EmployeeFindCalendarService {

	private final EmployeeFinderService employeeFinderService;

	@Inject
	public EmployeeFindCalendarService(EmployeeFinderService employeeFinderService) {
		this.employeeFinderService = employeeFinderService;
	}

	public Calendar execute(Long employeeId) {

		CompanyEntity employee = employeeFinderService.execute(employeeId);
		return employee.getCalendar();

	}

}
