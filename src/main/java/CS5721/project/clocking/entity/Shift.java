package CS5721.project.clocking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shift")
public class Shift {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "start_hour")
	private int startHour;

	@Column(name = "end_hour")
	private int endHour;

	public Shift() {
		startHour = 8;
		endHour = 17;
	}

	public Shift(int start, int end) {
		this.startHour = start;
		this.endHour = end;
	}

	public Long getId() {return id;}

	public void setId(Long id) {this.id = id;}

	public int getStartHour() {
		return startHour;
	}

	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}

	public int getEndHour() {
		return endHour;
	}

	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}
}
