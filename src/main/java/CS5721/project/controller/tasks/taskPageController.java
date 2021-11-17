package CS5721.project.controller.tasks;

import CS5721.project.entity.person.Employee;
import CS5721.project.service.employee.EmployeeFinderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "")
public class taskPageController {
    public final EmployeeFinderService employeeFinderService;

    public taskPageController(EmployeeFinderService employeeFinderService) {
        this.employeeFinderService = employeeFinderService;
    }

    @GetMapping(path = "/tasks")
    public String welcomePage(Model model, @RequestParam Long employeeId) {
        Employee employee = employeeFinderService.execute(employeeId);
        String employeeName = employee.getName();
        model.addAttribute("employeeName", employeeName);
        model.addAttribute("employeeId", employeeId);
        return "tasks.html";
    }

}
