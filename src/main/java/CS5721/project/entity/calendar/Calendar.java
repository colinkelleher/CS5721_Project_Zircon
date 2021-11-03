package CS5721.project.entity.calendar;

import java.util.ArrayList;

public class Calendar {
    public Calendar() {
        this.events = new ArrayList<>();
    }

    public ArrayList<CalendarEvent> getEvents() {
        return events;
    }

    public void addEvent(CalendarEvent event) {
        events.add(event);
    }

    private final ArrayList<CalendarEvent> events;
}
