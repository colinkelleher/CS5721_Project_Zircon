package CS5721.project.employee.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import CS5721.project.calendar.entity.Calendar;
import CS5721.project.calendar.entity.CalendarEvent;
import CS5721.project.clocking.entity.ClockingInfo;
import CS5721.project.clocking.entity.Shift;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.listeners.EventListener;
import CS5721.project.observer.publisher.EventSystem;
import CS5721.project.reminder.entity.ReminderList;

@Entity
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Employee implements EventListener, CompanyEntity {

	@Id
	@Column(name = "id", unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "department")
	@Enumerated(EnumType.STRING)
	private DEPARTMENT department;

	@OneToOne(cascade = CascadeType.REMOVE)
	private Calendar calendar;

	@OneToOne(cascade = CascadeType.REMOVE)
	private ReminderList reminderList;

	@OneToOne
	private Shift shift;

	@OneToOne(cascade = CascadeType.REMOVE)
	private ClockingInfo clockingInfo;

	public Employee(Long id, String name, DEPARTMENT department, Shift shift, EventSystem eventSystem,
			OPERATIONS[] operations) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.shift = shift;
		this.calendar = new Calendar();
		this.clockingInfo = new ClockingInfo();
		this.reminderList = new ReminderList();
		for (OPERATIONS operation : operations) {
			eventSystem.subscribe(operation, this);
		}

	}

	public Employee(Long id, String name, DEPARTMENT department, Calendar calendar, Shift shift) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.calendar = calendar;
		this.shift = shift;
		this.clockingInfo = new ClockingInfo();
	}

	public Employee() {
		this.calendar = new Calendar();
		this.reminderList = new ReminderList();
		this.clockingInfo = new ClockingInfo();
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
		if (Objects.equals(this.id, employeeID)) {
			this.calendar.addEvent(event);
		}
	}

	@Override
	public String getDetails() {
		return ("Employee : " + id + " - " + name + " - " + department.toString());
	}

}
