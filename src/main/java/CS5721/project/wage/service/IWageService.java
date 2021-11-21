package CS5721.project.wage.service;

import CS5721.project.calendar.entity.Calendar;

public interface IWageService {

	double getMonthlyWage(Calendar calendar);
	
	double getWeeklyWage(Calendar calendar);

}
