package CS5721.project.clocking.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import CS5721.project.calendar.entity.CalendarEvent;
import CS5721.project.clocking.entity.ClockingInfo;
import CS5721.project.clocking.entity.Shift;
import CS5721.project.employee.entity.Employee;

@Service
public class ClockingService implements IClockingService {

	public CalendarEvent[] getClockingEvents(ClockingInfo clockingInfo, Shift shift) {
		CalendarEvent[] eventsArray = new CalendarEvent[] {};
		// TODO implement calculation of events from a shift and clocking info, i.e how
		// many Regular or Overtime Events we return
		return new CalendarEvent[0];
	}

	public String execute(Employee employee, LocalDateTime clockingTime) {
		ClockingInfo clockingInfo = employee.getClockingInfo();

		LocalDate clockingDate = clockingTime.toLocalDate();
		LocalDate todaysDate = LocalDate.now();
		if (clockingInfo.getClockingInTime() == null || !clockingDate.equals(todaysDate)) {
			clockingInfo.setClockingInTime(clockingTime);
			return "in";
		} else if (clockingInfo.getClockingOutTime() == null || !clockingDate.equals(todaysDate)) {
			clockingInfo.setClockingOutTime(clockingTime);
			// create events according to the clock-out time ?
			return "out";
		}
		return null;

	}
}
