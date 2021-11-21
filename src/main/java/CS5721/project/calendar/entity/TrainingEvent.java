package CS5721.project.calendar.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class TrainingEvent extends CalendarEvent {
	public TrainingEvent(LocalDateTime startDate, LocalDateTime endDate, long id) {
		super(startDate, endDate, id);
		this.setApproved(true);
	}

	public TrainingEvent() {
		super();
	}

	@Override
	public double getPay() {
		return 10;
	}

	@Override
	public boolean isOvertime() {
		return false;
	}

	@Override
	public boolean isTraining() {
		return true;
	}
}
