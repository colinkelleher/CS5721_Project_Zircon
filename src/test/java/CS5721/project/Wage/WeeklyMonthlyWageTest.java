package CS5721.project.Wage;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import CS5721.project.entity.calendar.Calendar;
import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.entity.calendar.OvertimeEvent;
import CS5721.project.entity.calendar.RegularEvent;
import CS5721.project.entity.calendar.TrainingEvent;
import CS5721.project.entity.person.Employee;
import CS5721.project.entity.wage.Wage;

public class WeeklyMonthlyWageTest {

	public static final LocalDateTime EVENT_START_DATE = LocalDateTime.of(2021, 11, 25, 18, 30);
	public static final LocalDateTime EVENT_END_DATE = LocalDateTime.of(2021, 11, 25, 19, 30);

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

		Wage employee1Wage = employee1.getWage();
		double employeeMonthly1Wage = employee1Wage.getMonthlyWage(employee1.getCalendar());
		double employeeWeekly1Wage = employee1Wage.getWeeklyWage(employee1.getCalendar());

		Assertions.assertEquals(26.20, employeeMonthly1Wage); // passing
		Assertions.assertEquals(0, employeeWeekly1Wage); 	  // not passing ->need fix on getWeeklyWage()

	}

}
