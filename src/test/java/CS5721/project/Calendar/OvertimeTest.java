package CS5721.project.Calendar;

import java.time.LocalDateTime;

import CS5721.project.builder.Director;
import CS5721.project.builder.EmployeeBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import CS5721.project.calendar.entity.CalendarEvent;
import CS5721.project.calendar.entity.OvertimeEvent;
import CS5721.project.clocking.entity.Shift;
import CS5721.project.employee.entity.DEPARTMENT;
import CS5721.project.employee.entity.Employee;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.publisher.EventSystem;

public class OvertimeTest {
	public static final long ID = 122354L;
	public static final LocalDateTime EVENT_START_DATE = LocalDateTime.of(2021, 11, 5, 9, 0);
	public static final LocalDateTime EVENT_END_DATE = LocalDateTime.of(2021, 11, 5, 18, 30);
	private static OvertimeEvent overtimeEvent;
	private static Employee new_employee;

	// First we create the eventSystem and we assign to it the different operations
	// possible
	EventSystem eventSystem = new EventSystem(OPERATIONS.values());


	@BeforeAll
	static void setUp() {
		Director director = new Director();
		EmployeeBuilder employeeBuilder = new EmployeeBuilder();

		director.constructNameAndID(employeeBuilder,"Test Employee", ID);
		new_employee = employeeBuilder.getResult();
		overtimeEvent = new OvertimeEvent(EVENT_START_DATE, EVENT_END_DATE);
	}

	@Test
	public void overtimeTest() {
		// We create the event this way : the operation to create the event, and then
		// the ID of the employee concerned
		eventSystem.notifyEvent(OPERATIONS.CREATE_EVENT, overtimeEvent, ID);
		Assertions.assertTrue(overtimeEvent.isOvertime());
	}

	@Test
	public void overtimePayTest() {
		Assertions.assertNotEquals(0, overtimeEvent.getPay());
	}

	@Test
	public void overtimePayTest2() {
		Assertions.assertEquals(144, overtimeEvent.getPay());
	}

	@Test
	public void overtimeIsTrainingTest() {
		Assertions.assertFalse(overtimeEvent.isTraining());
	}
}
