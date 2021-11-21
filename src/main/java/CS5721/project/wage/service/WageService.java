package CS5721.project.wage.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Set;

import org.springframework.stereotype.Service;

import CS5721.project.calendar.entity.Calendar;
import CS5721.project.calendar.entity.CalendarEvent;

@Service
public class WageService implements IWageService {

	public double getMonthlyWage(Calendar calendar) {

		Set<CalendarEvent> events = calendar.getEvents();

		Month currentMonth = LocalDateTime.now().getMonth();

		// Check all events and filters them to keep only those of current Month
		return events.stream().filter(event -> event.getStartDate().getMonth() == currentMonth)
				.mapToDouble(CalendarEvent::getPay).sum();

	}

	public double getWeeklyWage(Calendar calendar) {

		Set<CalendarEvent> events = calendar.getEvents();

		// Check all events and filters them to keep only those of the last seven days
		return events.stream().filter(event -> Duration.between(event.getStartDate(), LocalDateTime.now()).toDays() < 7)
				.mapToDouble(CalendarEvent::getPay).sum();

	}

}
