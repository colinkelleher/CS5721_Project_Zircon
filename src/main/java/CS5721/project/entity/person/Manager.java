package CS5721.project.entity.person;

import CS5721.project.entity.calendar.Calendar;
import CS5721.project.entity.wage.Wage;

public class Manager extends Employee {

	public Manager(Long id, String name, Wage wage, Calendar calendar) {
		super(id, name, wage, calendar);
	}

}
