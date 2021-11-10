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

public class EmployeeData {

	private static Map<Long, Employee> employees = new HashMap<>();

	static {
		Employee employee1 = new Employee();
		employee1.setId(1L);
		employee1.setName("Ewen");
		Calendar calendar1 = employee1.getCalendar();
		CalendarEvent event1 = new OvertimeEvent(LocalDateTime.of(2021, 11, 5, 9, 0),
				LocalDateTime.of(2021, 11, 5, 18, 30));
		calendar1.addEvent(event1);

		Employee employee2 = new Employee();
		employee2.setId(2L);
		employee2.setName("Colin");

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
