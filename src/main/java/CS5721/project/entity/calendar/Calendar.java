package CS5721.project.entity.calendar;

import java.time.LocalDateTime;
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


    public void createEvent(String type, LocalDateTime startDate, LocalDateTime endDate) {
        if(type=="training"){ // bad coding, not extensible
            CalendarEvent event = new TrainingEvent(startDate, endDate);
            addEvent(event);
        }
    }
}
