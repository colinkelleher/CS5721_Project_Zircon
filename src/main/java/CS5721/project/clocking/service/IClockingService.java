package CS5721.project.service.clocking;

import java.time.LocalDateTime;

import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.entity.clock.ClockingInfo;
import CS5721.project.entity.clock.Shift;
import CS5721.project.entity.person.Employee;

public interface IClockingService {

	CalendarEvent[] getClockingEvents(ClockingInfo clockingInfo, Shift shift);

	String execute(Employee employee, LocalDateTime clockingTime);

}
