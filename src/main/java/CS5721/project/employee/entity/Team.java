package CS5721.project.employee.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;

import CS5721.project.calendar.entity.Calendar;
import CS5721.project.reminder.entity.ReminderList;

@Entity
@DiscriminatorValue("team")
public class Team extends CompanyEntity {

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "lnk_team_employee", joinColumns = @JoinColumn(name = "company_entity_id", referencedColumnName = "company_entity_id"), inverseJoinColumns = @JoinColumn(name = "sub_company_entity_id", referencedColumnName = "company_entity_id"))
	@OrderBy("name")
	private List<CompanyEntity> companyEntities;

	@Column(name = "name")
	private String name;

	@Column(name = "department")
	private DEPARTMENT department;

	public Team() {
		this.companyEntities = new ArrayList<>();
	}

	public List<CompanyEntity> getCompanyEntities() {
		return companyEntities;
	}

	public void setCompanyEntities(List<CompanyEntity> companyEntities) {
		this.companyEntities = companyEntities;
	}

	@Override
	public String getDetails() {
		return ("Team : " + name + " - " + department.toString());
	}

	@Override
	public Calendar getCalendar() {
		return null;
	}

	@Override
	public ReminderList getReminderList() {
		return null;
	}

	@Override
	public void add(CompanyEntity companyEntity) {
		this.companyEntities.add(companyEntity);
	}

	@Override
	public void remove(CompanyEntity companyEntity) {
		this.companyEntities.remove(companyEntity);
	}

}