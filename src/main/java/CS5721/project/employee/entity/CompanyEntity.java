package CS5721.project.employee.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import CS5721.project.calendar.entity.Calendar;
import CS5721.project.clocking.entity.ClockingInfo;
import CS5721.project.reminder.entity.ReminderList;

@Entity
@Table(name = "company_entity")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("company")
public abstract class CompanyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "company_entity_id", nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "department")
	@Enumerated(EnumType.STRING)
	private DEPARTMENT department;

	@Column(name = "isEmployee")
	private Boolean isEmployee;

	public CompanyEntity(String name, DEPARTMENT department) {
		this.name = name;
		this.department = department;

	}

	public CompanyEntity() {
	}

	public abstract String getDetails();

	public abstract Calendar getCalendar();

	public abstract ReminderList getReminderList();

	public abstract ClockingInfo getClockingInfo();

	public abstract void add(CompanyEntity companyEntity);

	public abstract void remove(CompanyEntity companyEntity);

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

	public Boolean getIsEmployee() {
		return isEmployee;
	}

	public void setIsEmployee(Boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

}