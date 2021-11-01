package CS5721.project.entity.clock;

import CS5721.project.entity.wage.Wage;

import java.time.LocalDateTime;

public class ClockingInfo {
    private Long id;

    private String department;

    private LocalDateTime clockingInTime;

    private LocalDateTime clockingOutTime;

    public Long getId() {
        return id;
    }

    public void setClockingInTime(LocalDateTime clockingInTime) {
        this.clockingInTime = clockingInTime;
    }

    public void setClockingOutTime(LocalDateTime clockingOutTime) {
        this.clockingOutTime = clockingOutTime;
    }

    public String getDepartment() {
        return department;
    }
}
