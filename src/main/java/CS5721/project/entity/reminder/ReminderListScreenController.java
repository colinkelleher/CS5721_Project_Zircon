package CS5721.project.entity.reminder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "")
public class ReminderListScreenController {

    @GetMapping(path = "/reminderList")
    public String reminderList() {
        return "reminderList.html";
    }
}
