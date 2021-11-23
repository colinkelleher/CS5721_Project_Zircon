package CS5721.project.employee.dto;

import CS5721.project.employee.entity.CompanyEntity;
import CS5721.project.employee.entity.DEPARTMENT;
import CS5721.project.employee.entity.Employee;

public class CompanyEntityDto {

	private Long id;

	private String name;

	private DEPARTMENT department;

	public CompanyEntityDto(CompanyEntity companyEntity) {
		this.id = companyEntity.getId();
		this.name = companyEntity.getName();
		this.department = companyEntity.getDepartment();

	}

	public CompanyEntityDto() {

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
