package CS5721.project.entity.calendar;

import java.time.LocalDateTime;

public abstract class CalendarEvent {
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public CalendarEvent(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public abstract double getPay();

    public abstract boolean isOvertime();

    public abstract boolean isTraining();

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endData) {
        this.endDate = endData;
    }

}
