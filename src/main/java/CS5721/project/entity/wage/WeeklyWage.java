package CS5721.project.entity.wage;

import CS5721.project.entity.calendar.Calendar;
import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.entity.person.Employee;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class WeeklyWage extends Wage {

	@Override
	public double getWage(Employee employee) {

		Calendar calendar = employee.getCalendar();

		ArrayList<CalendarEvent> events = calendar.getEvents();

		double wage = 0;

		//Check all events and filters them to keep only those of current Month
		return events.stream()
				.filter(event -> Duration.between(event.getStartDate(), LocalDateTime.now()).toDays() < 7)
				.mapToDouble(CalendarEvent::getPay)
				.sum();

	}

}
