package CS5721.project.controller.reminder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "")
public class ReminderCreateActionController {

    @PostMapping(path = "/createReminder")
    public String createReminder(){

        return "redirect:" + "/reminderList";
    }
}
