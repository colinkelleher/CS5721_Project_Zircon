package CS5721.project.entity.reminder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "")
public class CreateReminderActionController {

    @PostMapping(path = "/createReminder")
    public String createReminder(){
        return "redirect:" + "/reminderList";
    }
}
