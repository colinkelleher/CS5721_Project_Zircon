package CS5721.project.entity.calendar;

import java.time.LocalDateTime;

public class TrainingEvent extends CalendarEvent{
    public TrainingEvent(LocalDateTime startDate, LocalDateTime endDate) {
        super(startDate, endDate);
    }

    @Override
    public double getPay() {
        return 0;
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
