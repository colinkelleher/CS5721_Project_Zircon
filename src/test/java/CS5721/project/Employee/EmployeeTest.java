package CS5721.project.Employee;

import CS5721.project.builder.Director;
import CS5721.project.builder.EmployeeBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import CS5721.project.calendar.entity.Calendar;
import CS5721.project.employee.entity.Employee;
import CS5721.project.wage.service.WageService;

public class EmployeeTest {
	WageService wageService = new WageService();

	static Employee new_employee;

	@BeforeAll
	static void setUp() {
		Director director = new Director();
		EmployeeBuilder employeeBuilder = new EmployeeBuilder();

		director.constructNameOnly(employeeBuilder,"Test Employee");
		new_employee = employeeBuilder.getResult();
	}

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
