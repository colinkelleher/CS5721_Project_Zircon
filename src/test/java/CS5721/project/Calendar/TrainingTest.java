package CS5721.project.Calendar;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import CS5721.project.calendar.entity.CalendarEvent;
import CS5721.project.calendar.entity.TrainingEvent;

public class TrainingTest {
	public static final LocalDateTime EVENT_START_DATE = LocalDateTime.of(2021, 11, 5, 18, 0);
	public static final LocalDateTime EVENT_END_DATE = LocalDateTime.of(2021, 11, 5, 22, 30);
	CalendarEvent trainingEvent = new TrainingEvent(EVENT_START_DATE, EVENT_END_DATE);

	@Test
	public void trainingTest() {
		Assertions.assertTrue(trainingEvent.isTraining());
	}

	@Test
	public void trainingPay() {
		Assertions.assertEquals(10, trainingEvent.getPay());
	}

	@Test
	public void isTrainingOvertime() {
		Assertions.assertFalse(trainingEvent.isOvertime());
	}
}