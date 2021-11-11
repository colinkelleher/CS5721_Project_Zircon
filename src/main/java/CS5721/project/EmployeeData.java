package CS5721.project;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CS5721.project.entity.calendar.Calendar;
import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.entity.calendar.OvertimeEvent;
import CS5721.project.entity.person.Employee;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.publisher.EventSystem;

public class EmployeeData {

	private static final Map<Long, Employee> employees = new HashMap<>();

	static {
		EventSystem eventSystem = new EventSystem(OPERATIONS.values());
		Employee employee1 = new Employee(1L,"Ewen",eventSystem, OPERATIONS.values());
		CalendarEvent event1 = new OvertimeEvent(LocalDateTime.of(2021, 11, 5, 9, 0),
				LocalDateTime.of(2021, 11, 5, 18, 30));
		eventSystem.notifyEvent(OPERATIONS.CREATE_EVENT,event1,1L);

		Employee employee2 = new Employee(2L,"Colin",eventSystem, OPERATIONS.values());

		employees.put(1L, employee1);
		employees.put(2L, employee2);

	}

	public static List<Employee> getAllEmployees() {
		return new ArrayList<>(employees.values());
	}

	public static Employee getEmployeeDetails(Long employeeId) {
		return employees.get(employeeId);
	}

}
