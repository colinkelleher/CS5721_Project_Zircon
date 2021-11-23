package CS5721.project.task.controller;

import CS5721.project.employee.entity.CompanyEntity;
import CS5721.project.employee.entity.Employee;
import CS5721.project.employee.service.EmployeeFinderService;
import CS5721.project.task.entity.Task;
import CS5721.project.task.service.TaskService;

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
        CompanyEntity employee = employeeFinderService.execute(employeeId);
        String employeeName = employee.getName();
        ArrayList<Task> tasks = taskService.getAllTasks();
        model.addAttribute("employeeName", employeeName);
        model.addAttribute("employeeId", employeeId);
        model.addAttribute("tasks",tasks);
        return "tasks.html";
    }

}
