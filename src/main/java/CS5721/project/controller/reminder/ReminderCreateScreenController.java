package CS5721.project.controller.reminder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "")
public class ReminderCreateScreenController {

    @GetMapping(path = "/createReminder")
    public String createReminder() {
        return "createReminder.html";
    }
}
