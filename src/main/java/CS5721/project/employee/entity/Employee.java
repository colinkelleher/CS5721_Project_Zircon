package CS5721.project.employee.entity;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import CS5721.project.calendar.entity.Calendar;
import CS5721.project.calendar.entity.CalendarEvent;
import CS5721.project.clocking.entity.ClockingInfo;
import CS5721.project.clocking.entity.Shift;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.listeners.EventListener;
import CS5721.project.observer.publisher.EventSystem;
import CS5721.project.reminder.entity.ReminderList;

@Entity
@DiscriminatorValue("employee")
public class Employee extends CompanyEntity implements EventListener {

	@OneToOne(cascade = CascadeType.REMOVE)
	private Calendar calendar;

	@OneToOne(cascade = CascadeType.REMOVE)
	private ReminderList reminderList;

	@OneToOne
	private Shift shift;

	@OneToOne(cascade = CascadeType.REMOVE)
	private ClockingInfo clockingInfo;

	public Employee(String name, DEPARTMENT department, Shift shift, Calendar calendar, ClockingInfo clockingInfo,
			ReminderList reminderList, EventSystem eventSystem, OPERATIONS[] operations) {
		super(name, department);
		this.shift = shift;
		this.calendar = calendar;
		this.clockingInfo = clockingInfo;
		this.reminderList = reminderList;
		for (OPERATIONS operation : operations) {
			eventSystem.subscribe(operation, this);
		}

	}

	public Employee(Long id, String name, DEPARTMENT department, Calendar calendar, Shift shift) {
		super(name, department);
		this.calendar = calendar;
		this.shift = shift;
		this.clockingInfo = new ClockingInfo();
	}

	public Employee() {
		this.calendar = new Calendar();
		this.reminderList = new ReminderList();
		this.clockingInfo = new ClockingInfo();
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public ReminderList getReminderList() {
		return reminderList;
	}

	public void setReminderList(ReminderList reminderList) {
		this.reminderList = reminderList;
	}

	public Shift getShift() {
		return shift;
	}

	public void setShift(Shift shift) {
		this.shift = shift;
	}

	public ClockingInfo getClockingInfo() {
		return clockingInfo;
	}

	public void setClockingInfo(ClockingInfo clockingInfo) {
		this.clockingInfo = clockingInfo;
	}

	@Override
	public void update(OPERATIONS operations) {

	}

	@Override
	public void update(OPERATIONS operation, long eventID, long employeeID) {
		if (operation.equals(OPERATIONS.VALIDATE_REQUEST)) {
			this.calendar.findEvent(eventID).setApproved(true);
		}
	}

	@Override
	public void update(OPERATIONS operation, CalendarEvent event, Long employeeID) {
		if (Objects.equals(this.getId(), employeeID)) {
			this.calendar.addEvent(event);
		}
	}

	@Override
	public long getWeeklyWorkedHours() {
		long weeklyWorkedHours = 0;
		LocalDateTime today = LocalDateTime.now();
		LocalDateTime beginningOfThisWeek = today.with(DayOfWeek.MONDAY);

		for (CalendarEvent event : this.calendar.getEvents()) {

			LocalDateTime eventStartDate = event.getStartDate();
			LocalDateTime eventEndDate = event.getEndDate();

			if (eventStartDate.isAfter(beginningOfThisWeek)) {
				Duration duration = Duration.between(eventStartDate, eventEndDate);
				weeklyWorkedHours += duration.toHours();
			}
		}
		return weeklyWorkedHours;
	}

	public String getDetails() {
		return ("Employee : " + this.getId() + " - " + this.getName() + " - " + this.getDepartment().toString());
	}

	@Override
	public void add(CompanyEntity companyEntity) {
		// no implementation needed for a leaf in composite pattern, defining child
		// management in root abstract class gives more transparency but less safety
		// according to the GoF
	}

	@Override
	public void remove(CompanyEntity companyEntity) {
		// no implementation needed for a leaf in composite pattern, defining child
		// management in root abstract class gives more transparency but less safety
		// according to the GoF
	}

	@Override
	public ArrayList<Employee> getChildrenEntities(ArrayList<Employee> childrenList) {
		childrenList.add(this);
		return childrenList;
	}

}
