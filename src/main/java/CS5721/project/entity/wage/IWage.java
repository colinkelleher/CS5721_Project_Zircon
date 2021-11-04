package CS5721.project.entity.wage;

import CS5721.project.entity.calendar.Calendar;

/**
 * @author Ewen
 *
 */
public interface IWage {

	public abstract double getMonthlyWage(Calendar calendar);
	
	public abstract double getWeeklyWage(Calendar calendar);

}
