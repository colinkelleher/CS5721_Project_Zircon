package CS5721.project.entity.clock;

import java.time.LocalDateTime;

public class ClockingInfo {
    private Long id;

    private String department;

    private LocalDateTime clockingInTime;

    private LocalDateTime clockingOutTime;

    public ClockingInfo(Long id, String department, LocalDateTime clockingInTime, LocalDateTime clockingOutTime) {
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
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getDepartment() {
        return department;
    }
}
