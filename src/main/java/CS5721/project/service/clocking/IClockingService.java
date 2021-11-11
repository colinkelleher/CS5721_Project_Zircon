package CS5721.project.service.clocking;

import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.entity.clock.ClockingInfo;
import CS5721.project.entity.clock.Shift;

public interface IClockingService {

    CalendarEvent[] getClockingEvents (ClockingInfo clockingInfo, Shift shift);

}
