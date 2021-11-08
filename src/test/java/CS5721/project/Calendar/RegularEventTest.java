package CS5721.project.Calendar;

import CS5721.project.entity.calendar.Calendar;
import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.entity.calendar.RegularEvent;
import CS5721.project.entity.person.Employee;
import CS5721.project.entity.wage.Wage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class RegularEventTest {
    Employee colin_kelleher = new Employee(1223L, "Colin Kelleher", new Wage(), new Calendar());
    Calendar calendar = new Calendar();
    public static final LocalDateTime EVENT_START_DATE = LocalDateTime.of(2021, 11, 5, 18, 0);
    public static final LocalDateTime EVENT_END_DATE = LocalDateTime.of(2021, 11, 5, 22, 0);
    CalendarEvent regularEvent = new RegularEvent(EVENT_START_DATE,EVENT_END_DATE);

    @Test
    public void RegularEventPay() {
        colin_kelleher.setCalendar(calendar);
        calendar.addEvent(regularEvent);
        Assertions.assertNotEquals(40.2,regularEvent.getPay());
        Assertions.assertEquals(40.8,regularEvent.getPay());
    }

    @Test
    public void isRegularEventOvertime(){
        Assertions.assertFalse(regularEvent.isOvertime());
    }

    @Test
    public void isRegularEventTraining(){
        Assertions.assertFalse(regularEvent.isTraining());
    }

}
