package CS5721.project.entity.calendar;

import CS5721.project.entity.RATES;

import java.time.Duration;
import java.time.LocalDateTime;

public class OvertimeEvent extends CalendarEvent{
    public OvertimeEvent(LocalDateTime startDate, LocalDateTime endDate) {
        super(startDate, endDate);
    }

    @Override
    public double getPay() {
        LocalDateTime startDate = getStartDate();
        LocalDateTime endDate = getEndDate();
        Duration duration = Duration.between(startDate,endDate);
        double pay = duration.toHours() * RATES.OVERTIME_RATE.getValue();
        return pay;
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
