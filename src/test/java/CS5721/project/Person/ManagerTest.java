package CS5721.project.Person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import CS5721.project.EmployeeData;
import CS5721.project.clocking.entity.Shift;
import CS5721.project.employee.entity.DEPARTMENT;
import CS5721.project.employee.entity.Employee;
import CS5721.project.observer.OPERATIONS;

public class ManagerTest {
	Employee new_manager = new Employee(1223544L, "Test Manager", DEPARTMENT.RESEARCH_DEPARTMENT, new Shift(),
			EmployeeData.getEventSystem(), OPERATIONS.values());

	@Test
	public void testManagerID() {
		long managerID = new_manager.getId();
		// Simple assertion to get ID
		Assertions.assertEquals(1223544, managerID);
	}

	@Test
	public void testManagerName() {
		String managerName = new_manager.getName();
		// Simple assertion to get ID
		Assertions.assertEquals("Test Manager", managerName);
	}
}
