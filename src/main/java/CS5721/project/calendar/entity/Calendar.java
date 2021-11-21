package CS5721.project.entity.calendar;

import java.util.ArrayList;

public class Calendar {
    private final ArrayList<CalendarEvent> events;

    public Calendar() {
        this.events = new ArrayList<>();
    }

    public void addEvent(CalendarEvent event) {
        events.add(event);
    }

    public ArrayList<CalendarEvent> getEvents() {return events;}

    public CalendarEvent findEvent(long id) {
        return events.stream().filter(event -> event.getId() == id).findAny().orElse(null);
    }
}
