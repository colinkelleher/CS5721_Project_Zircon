package CS5721.project.Calendar;


import CS5721.project.entity.calendar.Calendar;
import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.entity.calendar.OvertimeEvent;
import CS5721.project.entity.person.Employee;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.publisher.EventSystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class OvertimeTest {
    public static final long ID = 122354L;
    public static final LocalDateTime EVENT_START_DATE = LocalDateTime.of(2021, 11, 5, 9, 0);
    public static final LocalDateTime EVENT_END_DATE = LocalDateTime.of(2021, 11, 5, 18, 30);

    //First we create the eventSystem and we assign to it the different operations possible
    EventSystem eventSystem = new EventSystem(OPERATIONS.values());

    //Then we create our employee and pass as parameter the eventSystem, as well as an array of Operations we want
    // the employee to subscribe to : here it is only the CREATE_EVENT
    Employee new_employee = new Employee(ID, "Test Employee", eventSystem, new OPERATIONS[]{OPERATIONS.CREATE_EVENT});
    CalendarEvent overtimeEvent = new OvertimeEvent(EVENT_START_DATE, EVENT_END_DATE);


    @Test
    public void overtimeTest(){
        // We create the event this way : the operation to create the event, and then the ID of the employee concerned
        eventSystem.notifyEvent(OPERATIONS.CREATE_EVENT, overtimeEvent,ID);
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
