package CS5721.project.entity.wage;

import CS5721.project.entity.calendar.Calendar;
import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.entity.person.Employee;

import java.util.List;

public class OvertimeWage extends Wage {

	double amount;

	@Override
	public double getWage(Employee employee) {

		Calendar calendar = employee.getCalendar();

		List<CalendarEvent> events = calendar.getEvents();

		for (CalendarEvent ce : events) {
			if (ce.isOvertime()) {
				amount += ce.getPay();
			}
		}
		return amount;
	}

}
