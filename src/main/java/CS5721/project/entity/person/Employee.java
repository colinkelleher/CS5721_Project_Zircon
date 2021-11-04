package CS5721.project.entity.person;

import CS5721.project.entity.calendar.Calendar;
import CS5721.project.entity.wage.Wage;

public class Employee {

	private Long id;

	private String name;

	private Wage wage;

	private Calendar calendar;

	public Employee(Long id, String name) {
		this.id = id;
		this.name = name;
		this.wage = new Wage();
		this.calendar = new Calendar();
	}

	public Employee(Long id, String name, Wage wage, Calendar calendar) {
		super();
		this.id = id;
		this.name = name;
		this.wage = wage;
		this.calendar = calendar;
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

	public void setWage(Wage wage) {
		this.wage = wage;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}


	public double getMonthlyWage() {
		return wage.getMonthlyWage(this.calendar);
	}

	public double getWeeklyWage(){
		return wage.getWeeklyWage(this.calendar);
	}
}
