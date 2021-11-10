package CS5721.project.entity.person;

import java.time.LocalDateTime;
import java.util.Objects;

import CS5721.project.entity.calendar.Calendar;
import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.entity.calendar.TypeOfEvent;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.listeners.EventListener;
import CS5721.project.observer.publisher.EventSystem;
import CS5721.project.service.wage.WageService;

public class Employee implements EventListener {

	private Long id;

	private String name;

	private WageService wage;

	private Calendar calendar;

	public Employee(Long id, String name, EventSystem eventSystem, OPERATIONS[] operations) {
		this.id = id;
		this.name = name;
		this.wage = new WageService();
		this.calendar = new Calendar();
		for (OPERATIONS operation : operations) {
			eventSystem.subscribe(operation, this);
		}

	}

	public Employee(Long id, String name, WageService wage, Calendar calendar) {
		super();
		this.id = id;
		this.name = name;
		this.wage = wage;
		this.calendar = calendar;
	}

	public Employee() {
		this.wage = new WageService();
		this.calendar = new Calendar();
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

	public void setWage(WageService wage) {
		this.wage = wage;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public double getMonthlyWage() {
		return wage.getMonthlyWage(this.calendar);
	}

	public double getWeeklyWage() {
		return wage.getWeeklyWage(this.calendar);
	}

	public void createRequest(TypeOfEvent eventType, LocalDateTime startDate, LocalDateTime endDate) {
		this.calendar.createEvent(eventType.getValue(), startDate, endDate);
	}

	@Override
	public void update(OPERATIONS operations) {

	}

	@Override
	public void update(OPERATIONS operation, CalendarEvent event, Long employeeID) {
		if (Objects.equals(this.id, employeeID)) {
			this.calendar.addEvent(event);
		}
	}
}
