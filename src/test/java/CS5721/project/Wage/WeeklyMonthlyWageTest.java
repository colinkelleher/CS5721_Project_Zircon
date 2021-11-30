package CS5721.project.Wage;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import CS5721.project.calendar.entity.Calendar;
import CS5721.project.calendar.entity.CalendarEvent;
import CS5721.project.calendar.entity.OvertimeEvent;
import CS5721.project.calendar.entity.RegularEvent;
import CS5721.project.calendar.entity.TrainingEvent;
import CS5721.project.employee.entity.Employee;
import CS5721.project.wage.service.WageService;

public class WeeklyMonthlyWageTest {

	WageService wageService = new WageService();

	public static final LocalDateTime EVENT_START_DATE = LocalDateTime.now().minusDays(14);
	public static final LocalDateTime EVENT_END_DATE =  LocalDateTime.now().minusDays(14).plusHours(5);

	@Test
	public void weeklyMonthlyWageTest() {

		Employee employee1 = new Employee();
		Calendar calendar1 = employee1.getCalendar();
		CalendarEvent event1 = new OvertimeEvent(EVENT_START_DATE, EVENT_END_DATE);
		CalendarEvent event2 = new RegularEvent(EVENT_START_DATE, EVENT_END_DATE);
		CalendarEvent event3 = new TrainingEvent(EVENT_START_DATE, EVENT_END_DATE);
		calendar1.addEvent(event1);
		calendar1.addEvent(event2);
		calendar1.addEvent(event3);

		double employeeMonthly1Wage = wageService.getMonthlyWage(calendar1);
		double employeeWeekly1Wage = wageService.getWeeklyWage(calendar1);

		Assertions.assertEquals(141, employeeMonthly1Wage);
		Assertions.assertEquals(0, employeeWeekly1Wage);

	}

}
