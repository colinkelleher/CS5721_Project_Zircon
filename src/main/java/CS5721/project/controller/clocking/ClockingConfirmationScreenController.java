package CS5721.project.controller.clocking;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "")
public class ClockingConfirmationScreenController {

    @GetMapping(path = "/clockingConfirmation")
    public String confirm(){
        return "clockingConfirmation.html";
    }
}
