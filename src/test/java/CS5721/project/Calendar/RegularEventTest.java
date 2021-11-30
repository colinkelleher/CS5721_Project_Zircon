package CS5721.project.Calendar;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import CS5721.project.calendar.entity.RegularEvent;

public class RegularEventTest {
	public static final long ID = 1223L;
	public static final LocalDateTime EVENT_START_DATE = LocalDateTime.of(2021, 11, 5, 18, 0);
	public static final LocalDateTime EVENT_END_DATE = LocalDateTime.of(2021, 11, 5, 22, 0);
	private static RegularEvent regularEvent;

	@BeforeAll
	static void setUp() {
		regularEvent = new RegularEvent(EVENT_START_DATE, EVENT_END_DATE);
	}

	// Checks if the regular Event is assigned to colin_kelleher and checks the pay
	@Test
	public void RegularEventPay() {
		Assertions.assertNotEquals(40.2, regularEvent.getPay());
		Assertions.assertEquals(40.8, regularEvent.getPay());
	}

	@Test
	public void isRegularEventOvertime() {
		Assertions.assertFalse(regularEvent.isOvertime());
	}

	@Test
	public void isRegularEventTraining() {
		Assertions.assertFalse(regularEvent.isTraining());
	}
}
