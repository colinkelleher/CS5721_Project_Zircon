package CS5721.project.service.wage;

import CS5721.project.entity.calendar.Calendar;

public interface IWageService {

	public abstract double getMonthlyWage(Calendar calendar);
	
	public abstract double getWeeklyWage(Calendar calendar);

}
