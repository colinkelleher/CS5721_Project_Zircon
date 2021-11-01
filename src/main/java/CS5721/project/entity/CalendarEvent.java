package CS5721.project.entity;

import java.util.Date;

public class CalendarEvent {
    private Date startDate;
    private Date endDate;

    enum EventType {
        SHIFT,
        OVERTIME,
        HOLIDAYS,
        ABSENCE,
        TRAINING,
    }

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
