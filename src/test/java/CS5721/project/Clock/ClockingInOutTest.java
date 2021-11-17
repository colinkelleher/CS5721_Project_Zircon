package CS5721.project.Clock;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import CS5721.project.entity.DEPARTMENT;
import CS5721.project.entity.clock.ClockingInfo;
import CS5721.project.entity.person.Employee;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.publisher.EventSystem;
import CS5721.project.service.clocking.ClockingService;

public class ClockingInOutTest {

	public ClockingService clockingService = new ClockingService();
	public EventSystem eventSystem = EventSystem.getEventSystemInstance(OPERATIONS.values());

	@Test
	public void clockingInOutTest() {

		Employee employee1 = new Employee(1L, "Ewen", DEPARTMENT.BUSINESS_DEPARTMENT, eventSystem, null,
				OPERATIONS.values());
		LocalDateTime today = LocalDateTime.now();
		LocalDateTime laterToday = today.plusHours(5);

		Long employeeId = employee1.getId();

		String clockingStatus1 = clockingService.execute(employee1, today);
		String clockingStatus2 = clockingService.execute(employee1, laterToday);

		Assertions.assertEquals("in", clockingStatus1);
		Assertions.assertEquals("out", clockingStatus2);

		ClockingInfo employeeClockingInfo = employee1.getClockingInfo();
		LocalDateTime clockingInTime = employeeClockingInfo.getClockingInTime();
		LocalDateTime clockingOutTime = employeeClockingInfo.getClockingOutTime();

		Assertions.assertEquals(today, clockingInTime);
		Assertions.assertEquals(laterToday, clockingOutTime);
	}
	


}
