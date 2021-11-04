package CS5721.project.Wage;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import CS5721.project.entity.calendar.*;
import CS5721.project.entity.person.Employee;
import CS5721.project.entity.wage.Wage;

public class WeeklyMonthlyWageTest {

	public static final LocalDateTime EVENT_START_DATE = LocalDateTime.of(2021, 10, 31, 18, 30);
	public static final LocalDateTime EVENT_END_DATE = LocalDateTime.of(2021, 10, 31, 19, 30);

	@Test
	public void weeklyMonthlyWageTest() {
		
		Employee employee1 = new Employee(1L, "employeeName1", new Wage(), new Calendar());
		Calendar calendar1 = employee1.getCalendar();
		CalendarEvent event1 = new OvertimeEvent(EVENT_START_DATE, EVENT_END_DATE);
		CalendarEvent event2 = new RegularEvent(EVENT_START_DATE, EVENT_END_DATE);
		CalendarEvent event3 = new TrainingEvent(EVENT_START_DATE, EVENT_END_DATE);
		calendar1.addEvent(event1);
		calendar1.addEvent(event2);
		calendar1.addEvent(event3);

		double employeeMonthly1Wage = employee1.getMonthlyWage();
		double employeeWeekly1Wage = employee1.getWeeklyWage();

		Assertions.assertEquals(0, employeeMonthly1Wage); // passing
		Assertions.assertEquals(26.20, employeeWeekly1Wage); 	  // not passing ->need fix on getWeeklyWage()

	}

}
