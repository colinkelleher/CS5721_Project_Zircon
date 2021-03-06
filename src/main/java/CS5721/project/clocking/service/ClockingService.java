package CS5721.project.clocking.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.inject.Inject;

import CS5721.project.calendar.entity.OvertimeEvent;
import CS5721.project.calendar.entity.RegularEvent;
import CS5721.project.calendar.repository.CalendarEventRepository;
import CS5721.project.calendar.repository.CalendarRepository;
import CS5721.project.employee.repository.CompanyEntityRepository;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.publisher.EventSystem;
import CS5721.project.request.observer.service.EventSystemCreateEvent;
import org.springframework.stereotype.Service;

import CS5721.project.calendar.entity.CalendarEvent;
import CS5721.project.clocking.entity.ClockingInfo;
import CS5721.project.clocking.entity.Shift;
import CS5721.project.clocking.repository.ClockingInfoRepository;
import CS5721.project.employee.entity.CompanyEntity;

@Service
public class ClockingService implements IClockingService {

	public final ClockingInfoRepository clockingInfoRepository;
	public final CalendarRepository calendarRepository;
	public final CompanyEntityRepository companyEntityRepository;
	public final CalendarEventRepository calendarEventRepository;
	public final EventSystemCreateEvent eventSystemCreateEventService;

	@Inject
	public ClockingService(ClockingInfoRepository clockingInfoRepository, CalendarRepository calendarRepository, CompanyEntityRepository companyEntityRepository, CalendarEventRepository calendarEventRepository, EventSystemCreateEvent eventSystemCreateEventService) {
		super();
		this.clockingInfoRepository = clockingInfoRepository;
		this.calendarRepository = calendarRepository;
		this.companyEntityRepository = companyEntityRepository;
		this.calendarEventRepository = calendarEventRepository;
		this.eventSystemCreateEventService = eventSystemCreateEventService;
	}

	public ArrayList<CalendarEvent> getClockingEvents(ClockingInfo clockingInfo, Shift shift) {
		ArrayList<CalendarEvent> eventsArray = new ArrayList<>();
		LocalDateTime clockInTime = clockingInfo.getClockingInTime();
		LocalDateTime clockOutTime = clockingInfo.getClockingOutTime();
		LocalDateTime startOfShift = clockInTime.withHour(shift.getStartHour()).withMinute(0).withSecond(0);
		LocalDateTime endOfShift = clockOutTime.withHour(shift.getEndHour()).withMinute(0).withSecond(0);
		LocalDateTime startOfRegularEvent = clockInTime;
		LocalDateTime endOfRegularEvent = clockOutTime;

		if (startOfShift.isAfter(clockInTime)) {
			startOfRegularEvent = clockInTime.withHour(shift.getStartHour());
			OvertimeEvent overtimeEvent = new OvertimeEvent(clockInTime,startOfRegularEvent);
			eventsArray.add(overtimeEvent);
		}
		if (endOfShift.isBefore(clockOutTime)) {
			endOfRegularEvent = clockOutTime.withHour(shift.getEndHour());
			OvertimeEvent overtimeEvent = new OvertimeEvent(endOfRegularEvent, clockOutTime);
			eventsArray.add(overtimeEvent);
		}

		RegularEvent regularEvent = new RegularEvent(startOfRegularEvent,endOfRegularEvent);
		eventsArray.add(regularEvent);
		return eventsArray;
	}

	public String execute(CompanyEntity employee, LocalDateTime clockingTime) {
		ClockingInfo clockingInfo = employee.getClockingInfo();

		LocalDate clockingDate = clockingTime.toLocalDate();
		LocalDate todaysDate = LocalDate.now();
		if (clockingInfo.getClockingInTime() == null || !clockingDate.equals(todaysDate)) {
			clockingInfo.setClockingInTime(clockingTime);

			clockingInfoRepository.save(clockingInfo);
			return "in";

		} else if (clockingInfo.getClockingOutTime() == null || !clockingDate.equals(todaysDate)) {
			clockingInfo.setClockingOutTime(clockingTime);
			ArrayList<CalendarEvent> listOfEvents = getClockingEvents(clockingInfo, employee.getShift());
			for(CalendarEvent event : listOfEvents) {
				eventSystemCreateEventService.execute(event, employee.getId());
				calendarEventRepository.save(event);
			}
			companyEntityRepository.save(employee);
			clockingInfoRepository.save(clockingInfo);
			return "out";
		}
		return null;

	}
}
