package CS5721.project.Employee;

import CS5721.project.builder.Director;
import CS5721.project.builder.EmployeeBuilder;
import CS5721.project.builder.ManagerBuilder;
import CS5721.project.calendar.entity.OvertimeEvent;
import CS5721.project.employee.entity.Manager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import CS5721.project.EmployeeData;
import CS5721.project.clocking.entity.Shift;
import CS5721.project.employee.entity.DEPARTMENT;
import CS5721.project.employee.entity.Employee;
import CS5721.project.observer.OPERATIONS;

public class ManagerTest {
	private static Manager new_manager;
	@BeforeAll
	static void setUp() {
		Director director = new Director();
		ManagerBuilder managerBuilder = new ManagerBuilder();

		director.constructNameOnly(managerBuilder,"Test Employee");
		new_manager = managerBuilder.getResult();
	}

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
