package CS5721.project.service.tasks;

import CS5721.project.tasks.Task;
import CS5721.project.tasks.TaskDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class TaskService {

    @Autowired
    private TaskDAO<Task> taskDAO;
//    private Task task = new Task();

    public  ArrayList<Task> getAllTasks() {
        return  taskDAO.findAllTasks();
    }


    }

