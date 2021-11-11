package CS5721.project.service.clocking;

import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.entity.clock.ClockingInfo;
import CS5721.project.entity.clock.Shift;

import java.util.ArrayList;

public class ClockingService implements IClockingService{
    @Override
    public CalendarEvent[] getClockingEvents(ClockingInfo clockingInfo, Shift shift) {
        CalendarEvent[] eventsArray = new CalendarEvent[]{};
        //TODO implement calculation of events from a shift and clocking info, i.e how many Regular or Overtime Events we return
        return new CalendarEvent[0];
    }
}
