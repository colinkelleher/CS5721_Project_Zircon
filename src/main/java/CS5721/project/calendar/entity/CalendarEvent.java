package CS5721.project.entity.calendar;

import java.time.LocalDateTime;

public abstract class CalendarEvent {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private long id;
    private boolean approved;

    public CalendarEvent(LocalDateTime startDate, LocalDateTime endDate, long id) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.id = id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
