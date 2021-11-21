package CS5721.project;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CS5721.project.calendar.entity.CalendarEvent;
import CS5721.project.calendar.entity.OvertimeEvent;
import CS5721.project.clocking.entity.Shift;
import CS5721.project.employee.entity.DEPARTMENT;
import CS5721.project.employee.entity.Employee;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.publisher.EventSystem;

public class EmployeeData {

	private static final Map<Long, Employee> employees = new HashMap<>();
	private static final EventSystem eventSystem = EventSystem.getEventSystemInstance(OPERATIONS.values());

	static {
		Employee employee1 = new Employee(1L, "Ewen", DEPARTMENT.BUSINESS_DEPARTMENT, new Shift(), eventSystem,
				OPERATIONS.values());
		CalendarEvent event1 = new OvertimeEvent(LocalDateTime.of(2021, 11, 5, 9, 0),
				LocalDateTime.of(2021, 11, 5, 18, 30), 1L);
		eventSystem.notifyEvent(OPERATIONS.CREATE_EVENT, event1, 1L);

		Employee employee2 = new Employee(2L, "Colin", DEPARTMENT.RESEARCH_DEPARTMENT, new Shift(), eventSystem,
				OPERATIONS.values());

		employees.put(1L, employee1);
		employees.put(2L, employee2);

	}

	public static List<Employee> getAllEmployees() {
		return new ArrayList<>(employees.values());
	}

	public static Employee getEmployeeDetails(Long employeeId) {
		return employees.get(employeeId);
	}

	public static void addEmployee(Employee employee) {
		Long id = employee.getId();
		employees.put(id, employee);
	}

	public static void removeEmployee(Long employeeId) {
		employees.remove(employeeId);
	}

	public static EventSystem getEventSystem() {
		return eventSystem;
	}

}
