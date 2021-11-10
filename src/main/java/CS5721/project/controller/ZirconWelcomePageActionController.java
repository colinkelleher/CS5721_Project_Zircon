package CS5721.project.controller;

import CS5721.project.entity.person.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "")
public class ZirconWelcomePageActionController {

    @PostMapping(path = "/")
    public String clock() {

        return "redirect:" + "/clockingConfirmation";

    }
}
