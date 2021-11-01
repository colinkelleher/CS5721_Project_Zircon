package CS5721.project.entity.calendar;

import CS5721.project.entity.RATES;

import java.time.Duration;
import java.time.LocalDateTime;

public class RegularEvent extends CalendarEvent {
    public RegularEvent(LocalDateTime startDate, LocalDateTime endDate) {
        super(startDate, endDate);
    }

    @Override
    public double getPay() {
        LocalDateTime startDate = getStartDate();
        LocalDateTime endDate = getEndDate();
        Duration duration = Duration.between(startDate,endDate);
        return duration.toHours() * RATES.REGULAR_RATE.getValue();
    }

    @Override
    public boolean isOvertime() {
        return false;
    }
}
