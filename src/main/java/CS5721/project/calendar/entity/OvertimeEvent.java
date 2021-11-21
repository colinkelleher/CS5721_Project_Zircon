package CS5721.project.calendar.entity;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Entity;

import CS5721.project.wage.RATES;

@Entity
public class OvertimeEvent extends CalendarEvent {
	public OvertimeEvent(LocalDateTime startDate, LocalDateTime endDate, long id) {
		super(startDate, endDate, id);
		this.setApproved(false);
	}

	public OvertimeEvent() {
		super();
	}

	@Override
	public double getPay() {
		LocalDateTime startDate = getStartDate();
		LocalDateTime endDate = getEndDate();
		Duration duration;
		duration = Duration.between(startDate, endDate);
		return duration.toHours() * RATES.OVERTIME_RATE.getValue();
	}

	@Override
	public boolean isOvertime() {
		return true;
	}

	@Override
	public boolean isTraining() {
		return false;
	}
}
