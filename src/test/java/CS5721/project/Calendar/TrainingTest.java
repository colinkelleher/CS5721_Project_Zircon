//package CS5721.project.Calendar;
//
//import java.time.LocalDateTime;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import CS5721.project.EmployeeData;
//import CS5721.project.calendar.entity.Calendar;
//import CS5721.project.calendar.entity.CalendarEvent;
//import CS5721.project.calendar.entity.TrainingEvent;
//import CS5721.project.clocking.entity.Shift;
//import CS5721.project.employee.entity.DEPARTMENT;
//import CS5721.project.employee.entity.Employee;
//import CS5721.project.observer.OPERATIONS;
//
//public class TrainingTest {
//	public static final LocalDateTime EVENT_START_DATE = LocalDateTime.of(2021, 11, 5, 18, 0);
//	public static final LocalDateTime EVENT_END_DATE = LocalDateTime.of(2021, 11, 5, 22, 30);
//	Employee colin_kelleher = new Employee(1223L, "Colin Kelleher", DEPARTMENT.BUSINESS_DEPARTMENT, new Shift(),
//			EmployeeData.getEventSystem(), OPERATIONS.values());
//	Calendar calendar = new Calendar();
//	CalendarEvent trainingEvent = new TrainingEvent(EVENT_START_DATE, EVENT_END_DATE, 3L);
//
//	@Test
//	public void trainingTest() {
//		colin_kelleher.setCalendar(calendar);
//		calendar.addEvent(trainingEvent);
//		Assertions.assertTrue(trainingEvent.isTraining());
//	}
//
//	@Test
//	public void trainingPay() {
//		Assertions.assertEquals(10, trainingEvent.getPay());
//	}
//
//	@Test
//	public void isTrainingOvertime() {
//		Assertions.assertFalse(trainingEvent.isOvertime());
//	}
//}
