package CS5721.project.Clock;

import java.time.LocalDateTime;

import CS5721.project.builder.Director;
import CS5721.project.builder.EmployeeBuilder;
import CS5721.project.calendar.entity.OvertimeEvent;
import CS5721.project.calendar.repository.CalendarEventRepository;
import CS5721.project.calendar.repository.CalendarRepository;
import CS5721.project.clocking.repository.ClockingInfoRepository;
import CS5721.project.employee.entity.CompanyEntity;
import CS5721.project.employee.repository.CompanyEntityRepository;
import CS5721.project.request.observer.service.EventSystemCreateEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import CS5721.project.EmployeeData;
import CS5721.project.clocking.entity.ClockingInfo;
import CS5721.project.clocking.entity.Shift;
import CS5721.project.clocking.service.ClockingService;
import CS5721.project.employee.entity.DEPARTMENT;
import CS5721.project.employee.entity.Employee;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.publisher.EventSystem;
import org.springframework.beans.factory.annotation.Autowired;

public class ClockingInOutTest {
	static private EventSystemCreateEvent eventSystemCreateEvent;

	@Autowired
	private ClockingInfoRepository clockingInfoRepository;

	@Autowired
	private CalendarRepository calendarRepository;

	@Autowired
	private CompanyEntityRepository companyEntityRepository;

	@Autowired
	private CalendarEventRepository calendarEventRepository;

	ClockingService clockingService = new ClockingService(clockingInfoRepository,calendarRepository,companyEntityRepository,calendarEventRepository,eventSystemCreateEvent);


	static CompanyEntity new_employee;

	@BeforeAll
	static void setUp() {
		Director director = new Director();
		EmployeeBuilder employeeBuilder = new EmployeeBuilder();
		eventSystemCreateEvent = new EventSystemCreateEvent();
		director.constructNameOnly(employeeBuilder,"Test Employee");
		new_employee = employeeBuilder.getResult();
	}

	@Test
	public void clockingInOutTest() {

		LocalDateTime today = LocalDateTime.now();
		LocalDateTime laterToday = today.plusHours(1);

		String clockingStatus1 = clockingService.execute(new_employee, today);
		String clockingStatus2 = clockingService.execute(new_employee, laterToday);

		Assertions.assertEquals("in", clockingStatus1);
		Assertions.assertEquals("out", clockingStatus2);

		ClockingInfo employeeClockingInfo = new_employee.getClockingInfo();
		LocalDateTime clockingInTime = employeeClockingInfo.getClockingInTime();
		LocalDateTime clockingOutTime = employeeClockingInfo.getClockingOutTime();

		Assertions.assertEquals(today, clockingInTime);
		Assertions.assertEquals(laterToday, clockingOutTime);
	}

}
