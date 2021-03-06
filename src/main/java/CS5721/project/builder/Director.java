package CS5721.project.builder;

import CS5721.project.calendar.entity.Calendar;
import CS5721.project.clocking.entity.ClockingInfo;
import CS5721.project.clocking.entity.Shift;
import CS5721.project.employee.dto.CompanyEntityDto;
import CS5721.project.employee.entity.DEPARTMENT;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.publisher.EventSystem;
import CS5721.project.reminder.entity.ReminderList;

public class Director {

	public void constructNameOnly(Builder builder, String name) {
		builder.setName(name);
		builder.setDepartment(DEPARTMENT.RESEARCH_DEPARTMENT);
		builder.setShift(new Shift());
		builder.setCalendar(new Calendar());
		builder.setClockingInfo(new ClockingInfo());
		builder.setReminderList(new ReminderList());
		builder.setEventSystem(EventSystem.getEventSystemInstance(OPERATIONS.values()));
		builder.setOperations(OPERATIONS.values());
	}

	public void constructFromDto(Builder builder, CompanyEntityDto employeeDto) {
		builder.setName(employeeDto.getName());
		builder.setDepartment(employeeDto.getDepartment());
		builder.setShift(new Shift());
		builder.setCalendar(new Calendar());
		builder.setClockingInfo(new ClockingInfo());
		builder.setReminderList(new ReminderList());
		builder.setEventSystem(EventSystem.getEventSystemInstance(OPERATIONS.values()));
		builder.setOperations(OPERATIONS.values());
	}

	public void constructNameAndID(Builder builder, String name, Long id) {
		builder.setName(name);
		builder.setID(id);
		builder.setDepartment(DEPARTMENT.RESEARCH_DEPARTMENT);
		builder.setShift(new Shift());
		builder.setCalendar(new Calendar());
		builder.setClockingInfo(new ClockingInfo());
		builder.setReminderList(new ReminderList());
		builder.setEventSystem(EventSystem.getEventSystemInstance(OPERATIONS.values()));
		builder.setOperations(OPERATIONS.values());
	}

	public long getRandomLong(long leftLimit, long rightLimit) {
		return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
	}
}
