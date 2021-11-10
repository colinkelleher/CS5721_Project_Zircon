package CS5721.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import CS5721.project.entity.person.Employee;

@Controller
@RequestMapping(path = "")
public class ZirconWelcomePageActionController {

    @PostMapping(path = "/clocking")
    public String clocking(@ModelAttribute Employee employee) {

        return "redirect:" + "/clockingConfirmation?employeeId=" + employee.getId();

    }
}
