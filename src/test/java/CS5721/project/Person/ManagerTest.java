package CS5721.project.Person;

import CS5721.project.EmployeeData;
import CS5721.project.calendar.entity.Calendar;
import CS5721.project.clocking.entity.Shift;
import CS5721.project.employee.entity.DEPARTMENT;
import CS5721.project.employee.entity.Employee;
import CS5721.project.observer.OPERATIONS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    Employee new_manager = new Employee(1223544L, "Test Manager", DEPARTMENT.RESEARCH_DEPARTMENT, EmployeeData.getEventSystem(), OPERATIONS.values(), new Shift());

    @Test
    public void testManagerID() {
        long managerID = new_manager.getId();
        // Simple assertion to get ID
        Assertions.assertEquals(1223544,managerID);
    }

    @Test
    public void testManagerName() {
        String managerName = new_manager.getName();
        // Simple assertion to get ID
        Assertions.assertEquals("Test Manager",managerName);
    }
}
