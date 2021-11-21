package CS5721.project.service.employee;

import CS5721.project.entity.person.Employee;
import CS5721.project.entity.reminder.ReminderList;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class EmployeeFindReminderListService {

    private final EmployeeFinderService employeeFinderService;

    @Inject
    public EmployeeFindReminderListService(EmployeeFinderService employeeFinderService) {
        this.employeeFinderService = employeeFinderService;
    }

    public ReminderList execute(Long employeeId) {

        Employee employee = employeeFinderService.execute(employeeId);
        return employee.getReminderList();

    }
}
