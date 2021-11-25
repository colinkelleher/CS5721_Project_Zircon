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
import CS5721.project.clocking.entity.ClockingInfo;
import CS5721.project.clocking.entity.Shift;
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

	public Team(String name, DEPARTMENT department) {
		this.name = name;
		this.department = department;
		this.companyEntities = new ArrayList<>();
	}

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
	public void add(CompanyEntity companyEntity) {
		this.companyEntities.add(companyEntity);
	}

	@Override
	public void remove(CompanyEntity companyEntity) {
		this.companyEntities.remove(companyEntity);
	}

	@Override
	public long getWeeklyWorkedHours() {
		long weeklyWorkedHours = 0;
		for (CompanyEntity companyEntity : this.companyEntities) {
			weeklyWorkedHours += companyEntity.getWeeklyWorkedHours();
		}
		return weeklyWorkedHours;
	}

	@Override
	public Calendar getCalendar() {
		// could return a list of all CalendarEvent of the sub companyEntities
		return null;
	}

	@Override
	public ReminderList getReminderList() {
		// could return a list of all Reminder of the sub ompanyEntities
		return null;
	}

	@Override
	public ClockingInfo getClockingInfo() {
		return null;
	}

	@Override
	public Shift getShift() {
		return null;
	}

	@Override
	public ArrayList<Employee> getChildrenEntities(ArrayList<Employee> childrenList) {
		if (!this.companyEntities.isEmpty()) {
			for (CompanyEntity entity : companyEntities) {
				childrenList = entity.getChildrenEntities(childrenList);
			}
		}
		return childrenList;
	}

}