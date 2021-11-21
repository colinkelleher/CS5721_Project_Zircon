package CS5721.project.Clock;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import CS5721.project.clocking.entity.ClockingInfo;
import CS5721.project.employee.entity.DEPARTMENT;

public class ClockingInfoTest {
	ClockingInfo clockingInfo = new ClockingInfo();

	@Test
	public void clockingInTest() {

		clockingInfo.setClockingInTime(LocalDateTime.of(2021, 11, 5, 9, 0));
		Assertions.assertEquals((LocalDateTime.of(2021, 11, 5, 9, 0)), clockingInfo.getClockingInTime());
	}

	@Test
	public void clockingOutTest() {
		clockingInfo.setClockingOutTime(LocalDateTime.of(2021, 11, 5, 18, 0));
		Assertions.assertNotEquals(LocalDateTime.of(2021, 11, 6, 18, 0), clockingInfo.getClockingOutTime());
	}

	@Test
	public void clockingDepartmentTest() {
		clockingInfo.setDepartment(DEPARTMENT.BUSINESS_DEPARTMENT);
		Assertions.assertEquals(DEPARTMENT.BUSINESS_DEPARTMENT, clockingInfo.getDepartment());
	}
}
