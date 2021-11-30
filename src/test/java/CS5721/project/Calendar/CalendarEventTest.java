package CS5721.project.Calendar;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import CS5721.project.builder.Director;
import CS5721.project.builder.EmployeeBuilder;
import CS5721.project.calendar.entity.Calendar;
import CS5721.project.calendar.entity.CalendarEvent;
import CS5721.project.calendar.entity.OvertimeEvent;
import CS5721.project.employee.entity.Employee;

public class CalendarEventTest {
	static Employee new_employee;
	public static final LocalDateTime EVENT_START_DATE = LocalDateTime.of(2021, 11, 5, 9, 0);
	public static final LocalDateTime EVENT_END_DATE = LocalDateTime.of(2021, 11, 5, 18, 30);
	static Calendar calendar1;
	static CalendarEvent overtimeEvent;

	@BeforeAll
	static void setUp() {
		Director director = new Director();
		EmployeeBuilder employeeBuilder = new EmployeeBuilder();

		director.constructNameOnly(employeeBuilder, "Test Employee");
		new_employee = employeeBuilder.getResult();
		calendar1 = new_employee.getCalendar();
		overtimeEvent = new OvertimeEvent(EVENT_START_DATE, EVENT_END_DATE);
	}

	@Test
	public void getStartDate() {
		calendar1.addEvent(overtimeEvent);
		LocalDateTime startDate = overtimeEvent.getStartDate();
		Assertions.assertNotEquals((LocalDateTime.of(2021, 11, 4, 9, 0)), startDate);
	}

	@Test
	public void isOvertime() {
		calendar1.addEvent(overtimeEvent);
		boolean result = overtimeEvent.isOvertime();
		Assertions.assertTrue(result);
	}
}
