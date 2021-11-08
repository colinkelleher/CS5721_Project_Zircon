package CS5721.project.Calendar;


import CS5721.project.entity.calendar.Calendar;
import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.entity.calendar.OvertimeEvent;
import CS5721.project.entity.person.Employee;
import CS5721.project.entity.wage.Wage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class OvertimeTest {
    Employee new_employee = new Employee(122354L, "Test Employee", new Wage(), new Calendar());
    public static final LocalDateTime EVENT_START_DATE = LocalDateTime.of(2021, 11, 5, 9, 0);
    public static final LocalDateTime EVENT_END_DATE = LocalDateTime.of(2021, 11, 5, 18, 30);
    Calendar calendar1 = new_employee.getCalendar();
    CalendarEvent overtimeEvent = new OvertimeEvent(EVENT_START_DATE, EVENT_END_DATE);

    @Test
    public void overtimeTest(){
        new_employee.setCalendar(calendar1);
        calendar1.addEvent(overtimeEvent);
        Assertions.assertTrue(overtimeEvent.isOvertime());
    }
    @Test
    public void overtimePayTest(){
        Assertions.assertNotEquals(0,overtimeEvent.getPay());
    }

    @Test
    public void overtimePayTest2 () {
        Assertions.assertEquals(144,overtimeEvent.getPay());
    }

    @Test
    public void overtimeIsTrainingTest (){
        Assertions.assertFalse(overtimeEvent.isTraining());
    }

}
