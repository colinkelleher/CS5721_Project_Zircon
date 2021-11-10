package CS5721.project.Calendar;

import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.entity.calendar.RegularEvent;
import CS5721.project.entity.person.Employee;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.publisher.EventSystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class RegularEventTest {
    public static final long ID = 1223L;
    public static final LocalDateTime EVENT_START_DATE = LocalDateTime.of(2021, 11, 5, 18, 0);
    public static final LocalDateTime EVENT_END_DATE = LocalDateTime.of(2021, 11, 5, 22, 0);

    EventSystem eventSystem = new EventSystem(OPERATIONS.values());

    //Then we create our employee and pass as parameter the eventSystem, as well as an array of Operations we want
    // the employee to subscribe to : here it is only the CREATE_EVENT
    Employee colin_kelleher = new Employee(
            ID,
            "Colin Kelleher",
            eventSystem,
            new OPERATIONS[]{OPERATIONS.CREATE_EVENT});

    CalendarEvent regularEvent = new RegularEvent(EVENT_START_DATE,EVENT_END_DATE);

    //Checks if the regular Event is assigned to colin_kelleher and checks the pay
    @Test
    public void RegularEventPay() {
        eventSystem.notifyEvent(OPERATIONS.CREATE_EVENT,regularEvent,ID);
        Assertions.assertEquals(colin_kelleher.getCalendar().getEvents().get(0), regularEvent);
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
