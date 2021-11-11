package CS5721.project.Person;

import CS5721.project.entity.calendar.Calendar;
import CS5721.project.entity.person.Employee;
import CS5721.project.service.wage.WageService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    Employee new_manager = new Employee(1223544L, "Test Manager", new Calendar());

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
