package CS5721.project.entity.calendar;

import java.util.Date;

public abstract class CalendarEvent {
    private Date startDate;
    private Date endDate;

    public CalendarEvent(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public abstract double getPay();

    public abstract boolean isOvertime();

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndData() {
        return endDate;
    }

    public void setEndData(Date endData) {
        this.endDate = endData;
    }

}
