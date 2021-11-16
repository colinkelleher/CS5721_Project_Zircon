package CS5721.project.service.logingInOut;

import org.springframework.stereotype.Service;

import CS5721.project.EmployeeData;

@Service
public class CheckExistingEmployeeService {

	public boolean execute(Long employeeId) {

		if (EmployeeData.getEmployeeDetails(employeeId) == null) {
			return false;
		}
		return true;
	}

}
