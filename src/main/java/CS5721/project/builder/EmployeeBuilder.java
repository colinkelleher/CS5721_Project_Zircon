package CS5721.project.builder;

import CS5721.project.calendar.entity.Calendar;
import CS5721.project.clocking.entity.ClockingInfo;
import CS5721.project.clocking.entity.Shift;
import CS5721.project.employee.entity.DEPARTMENT;
import CS5721.project.employee.entity.Employee;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.publisher.EventSystem;
import CS5721.project.reminder.entity.ReminderList;

public class EmployeeBuilder implements Builder{
    private String name;
    private long id;
    private DEPARTMENT department;
    private Shift shift;
    private Calendar calendar;
    private ClockingInfo clockingInfo;
    private ReminderList reminderList;
    private EventSystem eventSystem;
    private OPERATIONS[] operations;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setID(long id) {
        this.id = id;
    }

    @Override
    public void setDepartment(DEPARTMENT department) {
        this.department = department;
    }

    @Override
    public void setShift(Shift shift) {
        this.shift = shift;
    }

    @Override
    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void setClockingInfo(ClockingInfo clockingInfo) {
        this.clockingInfo = clockingInfo;
    }

    @Override
    public void setReminderList(ReminderList reminderList) {
        this.reminderList = reminderList;
    }

    @Override
    public void setEventSystem(EventSystem eventSystem) {
        this.eventSystem = eventSystem;
    }

    @Override
    public void setOperations(OPERATIONS[] operations){
        this.operations = operations;
    }

    public Employee getResult() {
        return new Employee(id,name,department,shift,calendar,clockingInfo,reminderList,eventSystem,operations);
    }
}
