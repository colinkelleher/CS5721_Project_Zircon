package CS5721.project.Clock;

import java.time.LocalDateTime;

import CS5721.project.builder.Director;
import CS5721.project.builder.EmployeeBuilder;
import CS5721.project.calendar.repository.CalendarEventRepository;
import CS5721.project.calendar.repository.CalendarRepository;
import CS5721.project.clocking.repository.ClockingInfoRepository;
import CS5721.project.employee.entity.CompanyEntity;
import CS5721.project.employee.repository.CompanyEntityRepository;
import CS5721.project.request.observer.service.EventSystemCreateEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import CS5721.project.clocking.entity.ClockingInfo;
import CS5721.project.clocking.service.ClockingService;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;


// This test does not work because of a poor implementation of ClockingService
// Because it uses the repositories in the service, it is complicated to test
// We won't have time but to solve this, a refactoring of the service would be efficient
// Just save to the repositories what the service returns, instead of in the service
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class ClockingInOutTest {
	static private EventSystemCreateEvent eventSystemCreateEvent;

	@MockBean
	private ClockingInfoRepository clockingInfoRepository;

	@MockBean
	private CalendarRepository calendarRepository;

	@MockBean
	private CompanyEntityRepository companyEntityRepository;

	@MockBean
	private CalendarEventRepository calendarEventRepository;


	static CompanyEntity new_employee;

	@BeforeAll
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		Director director = new Director();
		EmployeeBuilder employeeBuilder = new EmployeeBuilder();
		eventSystemCreateEvent = new EventSystemCreateEvent();
		director.constructNameOnly(employeeBuilder,"Test Employee");
		new_employee = employeeBuilder.getResult();
	}

	@Test
	public void clockingInOutTest() {
		Mockito.when(clockingInfoRepository.save(Mockito.any())).thenReturn(true);
		Mockito.when(calendarRepository.save(Mockito.any())).thenReturn(true);
		Mockito.when(calendarEventRepository.save(Mockito.any())).thenReturn(true);
		Mockito.when(companyEntityRepository.save(Mockito.any())).thenReturn(true);

		LocalDateTime today = LocalDateTime.now();
		LocalDateTime laterToday = today.plusHours(1);

		ClockingService clockingService = new ClockingService(clockingInfoRepository,calendarRepository,companyEntityRepository,calendarEventRepository,eventSystemCreateEvent);

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
