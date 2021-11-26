package CS5721.project.reminder.controller;

import CS5721.project.employee.entity.CompanyEntity;
import CS5721.project.employee.service.EmployeeFinderService;
import CS5721.project.reminder.repository.ReminderRepository;
import CS5721.project.reminder.service.ReminderCreateService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

@Controller
@RequestMapping(path = "")
public class ReminderCreateActionController {

    public final ReminderCreateService reminderCreateService;
    public final EmployeeFinderService employeeFinderService;
    public final ReminderRepository reminderRepository;

    @Inject
    public ReminderCreateActionController(ReminderCreateService reminderCreateService,
                                          EmployeeFinderService employeeFinderService,
                                          ReminderRepository reminderRepository){
        super();
        this.reminderCreateService = reminderCreateService;
        this.employeeFinderService = employeeFinderService;
        this.reminderRepository = reminderRepository;
    }

    @PostMapping(path = "/createReminder")
    public String createReminder(@RequestParam Long employeeId, @RequestParam String title,
                                 @RequestParam(required = false) String description,
                                 @RequestParam(required = false) String location){

        CompanyEntity employee = employeeFinderService.execute(employeeId);
        reminderCreateService.execute(employee, title, description, location);


        return "redirect:" + "/reminderList?employeeId="+ employeeId;
    }
}
