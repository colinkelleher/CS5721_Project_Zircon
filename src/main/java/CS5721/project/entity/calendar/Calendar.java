package CS5721.project.entity.calendar;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
    public Calendar() {
        this.events = new ArrayList<>();
    }

    public List<CalendarEvent> getEvents() {
        return events;
    }

    public void addEvent(CalendarEvent event) {
        events.add(event);
    }

    private final List<CalendarEvent> events;
}
