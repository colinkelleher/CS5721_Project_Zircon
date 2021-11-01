package CS5721.project.entity;

import java.util.Date;

public class CalendarEvent {
    private Date startDate;
    private Date endData;

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
        return endData;
    }

    public void setEndData(Date endData) {
        this.endData = endData;
    }

}
