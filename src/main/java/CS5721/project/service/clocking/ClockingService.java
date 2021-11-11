package CS5721.project.service.clocking;

import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.entity.clock.ClockingInfo;
import CS5721.project.entity.clock.Shift;

import java.util.ArrayList;

public class ClockingService implements IClockingService{
    @Override
    public CalendarEvent[] getClockingEvents(ClockingInfo clockingInfo, Shift shift) {
        CalendarEvent[] eventsArray = new CalendarEvent[]{};
        return new CalendarEvent[0];
    }
}
