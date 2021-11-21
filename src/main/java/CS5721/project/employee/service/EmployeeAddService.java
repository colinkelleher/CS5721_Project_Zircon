package CS5721.project.service.employee;

import org.springframework.stereotype.Service;

import CS5721.project.EmployeeData;
import CS5721.project.entity.person.Employee;

@Service
public class EmployeeAddService {

	public void execute(Employee newEmployee) {
		EmployeeData.addEmployee(newEmployee);
	}

}
