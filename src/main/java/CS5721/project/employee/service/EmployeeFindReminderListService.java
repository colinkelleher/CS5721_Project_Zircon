package CS5721.project.employee.service;

import CS5721.project.employee.entity.Employee;
import CS5721.project.reminder.entity.ReminderList;

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
