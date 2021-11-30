package CS5721.project.Employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import CS5721.project.builder.Director;
import CS5721.project.builder.ManagerBuilder;
import CS5721.project.employee.entity.Manager;

public class ManagerTest {
	private static Manager new_manager;

	@BeforeAll
	static void setUp() {
		Director director = new Director();
		ManagerBuilder managerBuilder = new ManagerBuilder();

		director.constructNameOnly(managerBuilder, "Test Employee");
		new_manager = managerBuilder.getResult();
	}

	@Test
	public void testManagerName() {
		String managerName = new_manager.getName();
		// Simple assertion to get ID
		Assertions.assertEquals("Test Employee", managerName);
	}
}
