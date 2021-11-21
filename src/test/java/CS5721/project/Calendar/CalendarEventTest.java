package CS5721.project.Calendar;

import java.time.LocalDateTime;

import CS5721.project.EmployeeData;
import CS5721.project.calendar.entity.Calendar;
import CS5721.project.calendar.entity.CalendarEvent;
import CS5721.project.calendar.entity.OvertimeEvent;
import CS5721.project.clocking.entity.Shift;
import CS5721.project.employee.entity.DEPARTMENT;
import CS5721.project.employee.entity.Employee;
import CS5721.project.observer.OPERATIONS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalendarEventTest {
	Employee new_employee = new Employee(122354L, "Test Employee", DEPARTMENT.RESEARCH_DEPARTMENT, EmployeeData.getEventSystem(), OPERATIONS.values(), new Shift());
	public static final LocalDateTime EVENT_START_DATE = LocalDateTime.of(2021, 11, 5, 9, 0);
	public static final LocalDateTime EVENT_END_DATE = LocalDateTime.of(2021, 11, 5, 18, 30);
	Calendar calendar1 = new_employee.getCalendar();
	CalendarEvent overtimeEvent = new OvertimeEvent(EVENT_START_DATE, EVENT_END_DATE, 1L);

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
