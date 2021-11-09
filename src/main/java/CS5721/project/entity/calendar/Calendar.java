package CS5721.project.entity.calendar;

import CS5721.project.observer.publisher.EventSystem;

import java.beans.EventSetDescriptor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Calendar {
    private final ArrayList<CalendarEvent> events;

    public Calendar() {
        this.events = new ArrayList<>();
    }

    public void addEvent(CalendarEvent event) {
        events.add(event);
    }

    public ArrayList<CalendarEvent> getEvents() {return events;}

    public void createEvent(String type, LocalDateTime startDate, LocalDateTime endDate) {
        if(Objects.equals(type, "training")){ // bad coding, weak extensibility
            CalendarEvent event = new TrainingEvent(startDate, endDate);
            addEvent(event);
        }
    }
}
