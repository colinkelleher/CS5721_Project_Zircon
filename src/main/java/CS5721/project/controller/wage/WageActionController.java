package CS5721.project.controller.wage;

import CS5721.project.entity.calendar.Calendar;
import CS5721.project.service.employee.EmployeeFindCalendarService;
import CS5721.project.service.wage.WagePreviousMonthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping(path = "")
public class WageActionController {

    public final WagePreviousMonthService wagePreviousMonthService;
    public final EmployeeFindCalendarService employeeFindCalendarService;


    @Inject
    public WageActionController(WagePreviousMonthService wagePreviousMonthService, EmployeeFindCalendarService employeeFindCalendarService){
        super();
        this.wagePreviousMonthService = wagePreviousMonthService;
        this.employeeFindCalendarService = employeeFindCalendarService;
    }

    @PostMapping(path = "/previousMonthWage")
    public String previousWage(Model model, @RequestParam Long employeeId,
                               @RequestParam String month){

        Calendar calendar = employeeFindCalendarService.execute(employeeId);

        DateTimeFormatter _formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(month, _formatter);

        double previousMonthWage = wagePreviousMonthService.getMonthlyWage(calendar, date.getMonth());

        return "redirect:" + "/wage?employeeId=" + employeeId + "&previousMonthWage=" + previousMonthWage;
    }
}
