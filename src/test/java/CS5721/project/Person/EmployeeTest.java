package CS5721.project.Person;

import CS5721.project.entity.calendar.Calendar;
import CS5721.project.entity.person.Employee;
import CS5721.project.entity.wage.Wage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class EmployeeTest {
    Employee new_employee = new Employee(122354L, "Test Employee", new Wage(), new Calendar());
    @Test
    public void testEmployeeID() {
        long employeeID = new_employee.getId();
        // Simple assertion to get ID
        Assertions.assertEquals(122354,employeeID);
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
        double employeeWeeklyWage = new_employee.getWeeklyWage();
        Assertions.assertEquals(0, employeeWeeklyWage);
    }

    @Test
    // Simple test to check employee weekly wage
    public void testEmployeeMonthlyWage() {
        double employeeMonthlyWage = new_employee.getMonthlyWage();
        Assertions.assertEquals(0, employeeMonthlyWage);
    }
        }
