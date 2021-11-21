package CS5721.project.calendar.entity;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Entity;

import CS5721.project.wage.RATES;

@Entity
public class RegularEvent extends CalendarEvent {
	public RegularEvent(LocalDateTime startDate, LocalDateTime endDate, long id) {
		super(startDate, endDate, id);
		this.setApproved(true);
	}

	public RegularEvent() {
		super();
	}

	@Override
	public double getPay() {
		LocalDateTime startDate = getStartDate();
		LocalDateTime endDate = getEndDate();
		Duration duration = Duration.between(startDate, endDate);
		return duration.toHours() * RATES.REGULAR_RATE.getValue();
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
