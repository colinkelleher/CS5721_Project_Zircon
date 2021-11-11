package CS5721.project.Calendar;

import CS5721.project.entity.calendar.Calendar;
import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.entity.calendar.TrainingEvent;
import CS5721.project.entity.person.Employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class TrainingTest {
    public static final LocalDateTime EVENT_START_DATE = LocalDateTime.of(2021, 11, 5, 18, 0);
    public static final LocalDateTime EVENT_END_DATE = LocalDateTime.of(2021, 11, 5, 22, 30);
    Employee colin_kelleher = new Employee(1223L, "Colin Kelleher", new Calendar());
    Calendar calendar = new Calendar();
    CalendarEvent trainingEvent = new TrainingEvent(EVENT_START_DATE,EVENT_END_DATE,3L );


    @Test
    public void trainingTest() {
        colin_kelleher.setCalendar(calendar);
        calendar.addEvent(trainingEvent);
        Assertions.assertTrue(trainingEvent.isTraining());
    }

    @Test
    public void trainingPay() {
        Assertions.assertEquals(0,trainingEvent.getPay());
    }

    @Test
    public void isTrainingOvertime(){
        Assertions.assertFalse(trainingEvent.isOvertime());
    }
}
