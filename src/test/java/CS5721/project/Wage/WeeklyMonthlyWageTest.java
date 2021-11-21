package CS5721.project.Wage;

import java.time.LocalDateTime;

import CS5721.project.EmployeeData;
import CS5721.project.calendar.entity.Calendar;
import CS5721.project.calendar.entity.CalendarEvent;
import CS5721.project.calendar.entity.OvertimeEvent;
import CS5721.project.calendar.entity.RegularEvent;
import CS5721.project.calendar.entity.TrainingEvent;
import CS5721.project.clocking.entity.Shift;
import CS5721.project.employee.entity.DEPARTMENT;
import CS5721.project.employee.entity.Employee;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.wage.service.WageService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WeeklyMonthlyWageTest {

	WageService wageService = new WageService();

	public static final LocalDateTime EVENT_START_DATE = LocalDateTime.of(2021, 10, 31, 18, 30);
	public static final LocalDateTime EVENT_END_DATE = LocalDateTime.of(2021, 10, 31, 19, 30);

	@Test
	public void weeklyMonthlyWageTest() {

		Employee employee1 = new Employee(1L, "employeeName1", DEPARTMENT.RESEARCH_DEPARTMENT, EmployeeData.getEventSystem(), OPERATIONS.values(), new Shift());
		Calendar calendar1 = employee1.getCalendar();
		CalendarEvent event1 = new OvertimeEvent(EVENT_START_DATE, EVENT_END_DATE,1L );
		CalendarEvent event2 = new RegularEvent(EVENT_START_DATE, EVENT_END_DATE, 2L );
		CalendarEvent event3 = new TrainingEvent(EVENT_START_DATE, EVENT_END_DATE, 3L);
		calendar1.addEvent(event1);
		calendar1.addEvent(event2);
		calendar1.addEvent(event3);

		double employeeMonthly1Wage = wageService.getMonthlyWage(calendar1);
		double employeeWeekly1Wage = wageService.getWeeklyWage(calendar1);

		Assertions.assertEquals(0, employeeMonthly1Wage); // passing
		Assertions.assertEquals(0, employeeWeekly1Wage); // not passing ->need fix on getWeeklyWage()

	}

}
