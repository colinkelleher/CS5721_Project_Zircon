package CS5721.project.Employee;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import CS5721.project.builder.Director;
import CS5721.project.builder.EmployeeBuilder;
import CS5721.project.calendar.entity.Calendar;
import CS5721.project.calendar.entity.CalendarEvent;
import CS5721.project.calendar.entity.RegularEvent;
import CS5721.project.employee.entity.DEPARTMENT;
import CS5721.project.employee.entity.Employee;
import CS5721.project.employee.entity.Team;

public class CompanyEntityWeeklyWorkedHoursTest {

	static LocalDateTime EVENT_START_DATE = LocalDateTime.now().minusHours(9);
	static LocalDateTime EVENT_END_DATE = LocalDateTime.now();

	static Team superTeam;
	static Team redTeam;
	static Team blueTeam;

	static Employee employeeTop;
	static Employee employeeRed1;
	static Employee employeeBlue1;
	static Employee employeeBlue2;

	@BeforeAll
	static void setUp() {
		Director director = new Director();
		EmployeeBuilder employeeBuilder = new EmployeeBuilder();

		superTeam = new Team("top", DEPARTMENT.EXECUTIVE_DEPARTMENT);

		director.constructNameOnly(employeeBuilder, "employeeTop");
		employeeTop = employeeBuilder.getResult();
		Calendar employeeTopCalendar = employeeTop.getCalendar();
		CalendarEvent event1 = new RegularEvent(EVENT_START_DATE, EVENT_END_DATE);
		employeeTopCalendar.addEvent(event1);

		superTeam.getCompanyEntities().add(employeeTop);

		redTeam = new Team("red", DEPARTMENT.EXECUTIVE_DEPARTMENT);

		director.constructNameOnly(employeeBuilder, "employeeRed1");
		employeeRed1 = employeeBuilder.getResult();
		Calendar employeeRed1Calendar = employeeRed1.getCalendar();
		CalendarEvent event2 = new RegularEvent(EVENT_START_DATE, EVENT_END_DATE);
		employeeRed1Calendar.addEvent(event2);

		redTeam.getCompanyEntities().add(employeeRed1);

		blueTeam = new Team("blue", DEPARTMENT.EXECUTIVE_DEPARTMENT);

		director.constructNameOnly(employeeBuilder, "employeeBlue1");
		employeeBlue1 = employeeBuilder.getResult();
		Calendar employeeBlue1Calendar = employeeBlue1.getCalendar();
		CalendarEvent event3 = new RegularEvent(EVENT_START_DATE, EVENT_END_DATE);
		employeeBlue1Calendar.addEvent(event3);

		blueTeam.getCompanyEntities().add(employeeBlue1);

		director.constructNameOnly(employeeBuilder, "employeeBlue2");
		employeeBlue2 = employeeBuilder.getResult();
		Calendar employeeBlue2Calendar = employeeBlue2.getCalendar();
		CalendarEvent event4 = new RegularEvent(EVENT_START_DATE, EVENT_END_DATE);
		employeeBlue2Calendar.addEvent(event4);

		blueTeam.getCompanyEntities().add(employeeBlue2);

		superTeam.getCompanyEntities().add(redTeam);
		superTeam.getCompanyEntities().add(blueTeam);
	}

	@Test
	public void employeeWeeklyWorkedHoursTest() {
		long employeeTopWeeklyWorkedHours = employeeTop.getWeeklyWorkedHours();
		Assertions.assertEquals(9, employeeTopWeeklyWorkedHours);
	}

	@Test
	public void teamWeeklyWorkedHoursTest() {
		long superTeamWeeklyWorkedHours = superTeam.getWeeklyWorkedHours();
		Assertions.assertEquals(36, superTeamWeeklyWorkedHours);
	}

}
