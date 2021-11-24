package CS5721.project.Employee;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import CS5721.project.builder.Director;
import CS5721.project.builder.EmployeeBuilder;
import CS5721.project.employee.entity.DEPARTMENT;
import CS5721.project.employee.entity.Employee;
import CS5721.project.employee.entity.Team;

public class FindTeamEmployeeTest {

	static Team superTeam;
	static Team redTeam;
	static Team blueTeam;

	static Employee employeeTop;
	static Employee employeeRed1;
	static Employee employeeBlue1;
	static Employee employeeBlue2;
	static Employee newEmployee;

	@BeforeAll
	static void setUp() {
		Director director = new Director();
		EmployeeBuilder employeeBuilder = new EmployeeBuilder();

		superTeam = new Team("top", DEPARTMENT.EXECUTIVE_DEPARTMENT);

		director.constructNameOnly(employeeBuilder, "employeeTop");
		employeeTop = employeeBuilder.getResult();
		superTeam.getCompanyEntities().add(employeeTop);

		redTeam = new Team("red", DEPARTMENT.EXECUTIVE_DEPARTMENT);

		director.constructNameOnly(employeeBuilder, "employeeRed1");
		employeeRed1 = employeeBuilder.getResult();
		redTeam.getCompanyEntities().add(employeeRed1);

		blueTeam = new Team("blue", DEPARTMENT.EXECUTIVE_DEPARTMENT);

		director.constructNameOnly(employeeBuilder, "employeeBlue1");
		employeeBlue1 = employeeBuilder.getResult();
		blueTeam.getCompanyEntities().add(employeeBlue1);

		director.constructNameOnly(employeeBuilder, "employeeBlue2");
		employeeBlue2 = employeeBuilder.getResult();
		blueTeam.getCompanyEntities().add(employeeBlue2);

		superTeam.getCompanyEntities().add(redTeam);
		superTeam.getCompanyEntities().add(blueTeam);

		director.constructNameOnly(employeeBuilder, "newEmployee");
		newEmployee = employeeBuilder.getResult();
	}

	@Test
	public void getAllTeamEmployeeTest() {

		List<Employee> superTeamEmployees = superTeam.getChildrenEntities(new ArrayList<>());
		int numberOfEmployeeInSuperTeam = superTeamEmployees.size();
		Assertions.assertEquals(4, numberOfEmployeeInSuperTeam);

		blueTeam.add(newEmployee);
		superTeamEmployees = superTeam.getChildrenEntities(new ArrayList<>());
		numberOfEmployeeInSuperTeam = superTeamEmployees.size();
		Assertions.assertEquals(5, numberOfEmployeeInSuperTeam);
	}

}
