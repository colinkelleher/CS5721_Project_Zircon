package CS5721.project.entity.person;

import java.util.Objects;

import CS5721.project.entity.DEPARTMENT;
import CS5721.project.entity.calendar.Calendar;
import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.entity.reminder.ReminderList;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.listeners.EventListener;
import CS5721.project.observer.publisher.EventSystem;

public class Employee implements EventListener {

	private Long id;

	private String name;

	private DEPARTMENT department;

	private Calendar calendar;

	private ReminderList reminderList;

	public Employee(Long id, String name, DEPARTMENT department, EventSystem eventSystem, OPERATIONS[] operations) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.calendar = new Calendar();
		for (OPERATIONS operation : operations) {
			eventSystem.subscribe(operation, this);
		}

	}

	public Employee(Long id, String name, DEPARTMENT department, Calendar calendar) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.calendar = calendar;
	}

	public Employee() {
		this.calendar = new Calendar();
		this.reminderList = new ReminderList();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public DEPARTMENT getDepartment() {
		return department;
	}

	public void setDepartment(DEPARTMENT department) {
		this.department = department;
	}

	public ReminderList getReminderList() {
		return reminderList;
	}

	public void setReminderList(ReminderList reminderList) {
		this.reminderList = reminderList;
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
		if (Objects.equals(this.id, employeeID)) {
			this.calendar.addEvent(event);
		}
	}

}
