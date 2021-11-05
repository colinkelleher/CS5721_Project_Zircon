package CS5721.project.Calendar;

import CS5721.project.entity.calendar.*;
import CS5721.project.entity.calendar.Calendar;
import CS5721.project.entity.person.Employee;
import CS5721.project.entity.wage.Wage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;


public class CalendarEventTest {
    Employee new_employee = new Employee(122354L, "Test Employee", new Wage(), new Calendar());
    public static final LocalDateTime EVENT_START_DATE = LocalDateTime.of(2021, 11, 5, 9, 0);
    public static final LocalDateTime EVENT_END_DATE = LocalDateTime.of(2021, 11, 5, 18, 30);
    Calendar calendar1 = new_employee.getCalendar();
    CalendarEvent overtimeEvent = new OvertimeEvent(EVENT_START_DATE, EVENT_END_DATE);


    @Test
    public void getStartDate (){
        calendar1.addEvent(overtimeEvent);
        LocalDateTime startDate = overtimeEvent.getStartDate();
        Assertions.assertNotEquals((LocalDateTime.of(2021,11,4,9,0)), startDate);
    }

    @Test
    public void isOvertime (){
        calendar1.addEvent(overtimeEvent);
        boolean result = overtimeEvent.isOvertime();
        Assertions.assertTrue(result);
    }
}
