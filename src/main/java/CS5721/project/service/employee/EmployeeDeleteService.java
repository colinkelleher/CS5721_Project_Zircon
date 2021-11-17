package CS5721.project.service.employee;

import org.springframework.stereotype.Service;

import CS5721.project.EmployeeData;

@Service
public class EmployeeDeleteService {

	public void execute(Long employeeId) {
		EmployeeData.removeEmployee(employeeId);
	}
}
