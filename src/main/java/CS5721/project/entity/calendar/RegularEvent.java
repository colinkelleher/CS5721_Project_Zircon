package CS5721.project.entity.calendar;

import java.time.Duration;
import java.time.LocalDateTime;

import CS5721.project.entity.RATES;

public class RegularEvent extends CalendarEvent {
	public RegularEvent(LocalDateTime startDate, LocalDateTime endDate) {
		super(startDate, endDate);
	}

	@Override
	public double getPay() {
		LocalDateTime startDate = getStartDate();
		LocalDateTime endDate = getEndDate();
		Duration duration = Duration.between(startDate, endDate);
		double pay = duration.toHours() * RATES.REGULAR_RATE.getValue();
		return pay;
	}

	@Override
	public boolean isOvertime() {
		return false;
	}

	@Override
	public boolean isTraining() {
		return false;
	}
}
