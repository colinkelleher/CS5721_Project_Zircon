package CS5721.project.controller.tasks;

import CS5721.project.entity.person.Employee;
import CS5721.project.service.employee.EmployeeFinderService;
import CS5721.project.service.tasks.TaskService;
import CS5721.project.tasks.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;

@Controller
@RequestMapping(path = "")
public class TaskPageController {
    public final TaskService taskService;
    public final EmployeeFinderService employeeFinderService;

    public TaskPageController(TaskService taskService, EmployeeFinderService employeeFinderService) {
        this.taskService = taskService;
        this.employeeFinderService = employeeFinderService;

    }

    @GetMapping(path = "/tasks")
    public String welcomePage(Model model, @RequestParam Long employeeId) {
        Employee employee = employeeFinderService.execute(employeeId);
        String employeeName = employee.getName();
        ArrayList<Task> tasks = taskService.getAllTasks();
        model.addAttribute("employeeName", employeeName);
        model.addAttribute("employeeId", employeeId);
        model.addAttribute("tasks",tasks);
        return "tasks.html";
    }

}
