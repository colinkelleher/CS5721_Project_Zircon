package CS5721.project.controller.clocking;

import CS5721.project.entity.person.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "")
public class ClockingPageScreenController {

    @GetMapping(path = "/clocking")
    public String clocking(Model model) {
        return "clocking.html";
    }
}
