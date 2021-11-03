package CS5721.project.entity.wage;

import CS5721.project.entity.calendar.Calendar;
import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.entity.person.Employee;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class MonthlyWage extends Wage {

	@Override
	public double getWage(Employee employee) {

		Calendar calendar = employee.getCalendar();

		ArrayList<CalendarEvent> events = calendar.getEvents();

		double wage = 0;

		Month currentMonth = LocalDateTime.now().getMonth();

		//Check all events and filters them to keep only those of current Month
		return events.stream()
				.filter(event -> event.getStartDate().getMonth() == currentMonth)
				.mapToDouble(CalendarEvent::getPay)
				.sum();

	}

}
