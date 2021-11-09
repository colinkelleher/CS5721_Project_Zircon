package CS5721.project.controller.wage;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "")
public class EmployeeWageScreenController {

    @GetMapping(path = "/wage")
    public String displayWage() {

        return "employeeWagePage.html";
    }
}
