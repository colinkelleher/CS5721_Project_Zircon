package CS5721.project.wage.service;

import java.time.Month;
import java.util.Set;

import org.springframework.stereotype.Service;

import CS5721.project.calendar.entity.Calendar;
import CS5721.project.calendar.entity.CalendarEvent;

@Service
public class WagePreviousMonthService {

	public double getMonthlyWage(Calendar calendar, Month month) {

		Set<CalendarEvent> events = calendar.getEvents();

		// Check all events and filters them to keep only those of the Month of the
		// input
		return events.stream().filter(event -> event.getStartDate().getMonth() == month)
				.mapToDouble(CalendarEvent::getPay).sum();

	}
}
