package CS5721.project.service.wage;

import CS5721.project.entity.calendar.Calendar;

public interface IWageService {

	double getMonthlyWage(Calendar calendar);
	
	double getWeeklyWage(Calendar calendar);

}
