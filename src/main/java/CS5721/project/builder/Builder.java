package CS5721.project.builder;

import CS5721.project.calendar.entity.Calendar;
import CS5721.project.clocking.entity.ClockingInfo;
import CS5721.project.clocking.entity.Shift;
import CS5721.project.employee.entity.DEPARTMENT;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.publisher.EventSystem;
import CS5721.project.reminder.entity.ReminderList;

public interface Builder {
    void setName(String name);
    void setID(long id);
    void setDepartment(DEPARTMENT department);
    void setShift(Shift shift);
    void setCalendar(Calendar calendar);
    void setClockingInfo(ClockingInfo clockingInfo);
    void setReminderList(ReminderList reminderList);
    void setEventSystem(EventSystem eventSystem);
    void setOperations(OPERATIONS[] operations);
}
