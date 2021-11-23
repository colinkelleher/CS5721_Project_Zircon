package CS5721.project.clocking.service;

import java.time.LocalDateTime;

import CS5721.project.calendar.entity.CalendarEvent;
import CS5721.project.clocking.entity.ClockingInfo;
import CS5721.project.clocking.entity.Shift;
import CS5721.project.employee.entity.CompanyEntity;

public interface IClockingService {

	CalendarEvent[] getClockingEvents(ClockingInfo clockingInfo, Shift shift);

	String execute(CompanyEntity employee, LocalDateTime clockingTime);

}
