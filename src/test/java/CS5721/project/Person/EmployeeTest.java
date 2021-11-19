package CS5721.project.Person;

import CS5721.project.EmployeeData;
import CS5721.project.entity.DEPARTMENT;
import CS5721.project.entity.clock.Shift;
import CS5721.project.observer.OPERATIONS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import CS5721.project.entity.calendar.Calendar;
import CS5721.project.entity.person.Employee;
import CS5721.project.service.wage.WageService;

public class EmployeeTest {
	WageService wageService = new WageService();

	Employee new_employee = new Employee(122354L,"Test Employee", DEPARTMENT.RESEARCH_DEPARTMENT, EmployeeData.getEventSystem(), OPERATIONS.values(), new Shift());

	@Test
	public void testEmployeeID() {
		long employeeID = new_employee.getId();
		// Simple assertion to get ID
		Assertions.assertEquals(122354, employeeID);
	}

	@Test
	// Simple test to check the employee name
	public void testEmployeeName() {
		String employeeName = new_employee.getName();
		Assertions.assertEquals("Test Employee", employeeName);
	}

	@Test
	// Simple test to check employee weekly wage
	public void testEmployeeWeeklyWage() {
		Calendar calendar = new_employee.getCalendar();
		double employeeWeeklyWage = wageService.getWeeklyWage(calendar);
		Assertions.assertEquals(0, employeeWeeklyWage);
	}

	@Test
	// Simple test to check employee monthly wage
	public void testEmployeeMonthlyWage() {
		Calendar calendar = new_employee.getCalendar();
		double employeeMonthlyWage = wageService.getMonthlyWage(calendar);
		Assertions.assertEquals(0, employeeMonthlyWage);
	}
}
