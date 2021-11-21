package CS5721.project.clocking.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import CS5721.project.employee.entity.DEPARTMENT;

@Entity
@Table(name = "clocking_info")
public class ClockingInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "department")
	private DEPARTMENT department;

	@Column(name = "clocking_in_time")
	private LocalDateTime clockingInTime;

	@Column(name = "clocking_out_time")
	private LocalDateTime clockingOutTime;

	public ClockingInfo(Long id, DEPARTMENT department, LocalDateTime clockingInTime, LocalDateTime clockingOutTime) {
		this.id = id;
		this.department = department;
		this.clockingInTime = clockingInTime;
		this.clockingOutTime = clockingOutTime;
	}

	public ClockingInfo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setClockingInTime(LocalDateTime clockingInTime) {
		this.clockingInTime = clockingInTime;
	}

	public LocalDateTime getClockingInTime() {
		return clockingInTime;
	}

	public void setClockingOutTime(LocalDateTime clockingOutTime) {
		this.clockingOutTime = clockingOutTime;
	}

	public LocalDateTime getClockingOutTime() {
		return clockingOutTime;
	}

	public void setDepartment(DEPARTMENT department) {
		this.department = department;
	}

	public DEPARTMENT getDepartment() {
		return department;
	}
}
