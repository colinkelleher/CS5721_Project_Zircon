package CS5721.project.employee.dto;

import CS5721.project.employee.entity.DEPARTMENT;
import CS5721.project.employee.entity.Employee;

public class EmployeeDto {

	private Long id;

	private String name;

	private DEPARTMENT department;

	public EmployeeDto(Employee employee) {
		this.id = employee.getId();
		this.name = employee.getName();
		this.department = employee.getDepartment();

	}

	public EmployeeDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DEPARTMENT getDepartment() {
		return department;
	}

	public void setDepartment(DEPARTMENT department) {
		this.department = department;
	}

}
