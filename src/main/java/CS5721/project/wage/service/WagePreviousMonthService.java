package CS5721.project.service.wage;

import CS5721.project.entity.calendar.Calendar;
import CS5721.project.entity.calendar.CalendarEvent;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

@Service
public class WagePreviousMonthService {

    public double getMonthlyWage(Calendar calendar, Month month) {

        ArrayList<CalendarEvent> events = calendar.getEvents();

        // Check all events and filters them to keep only those of the Month of the input
        return events.stream().filter(event -> event.getStartDate().getMonth() == month)
                .mapToDouble(CalendarEvent::getPay).sum();

    }
}
