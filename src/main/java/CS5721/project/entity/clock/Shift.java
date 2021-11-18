package CS5721.project.entity.clock;

import java.time.LocalDate;

public class Shift {
    private int startHour;
    private int endHour;

    public Shift() {
        startHour = 8;
        endHour = 17;
    }

    public Shift(int start, int end) {
        this.startHour = start;
        this.endHour = end;
    }

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
