package CS5721.project.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CS5721.project.task.entity.Task;
import CS5721.project.task.entity.TaskDAO;

import java.util.ArrayList;


@Service
public class TaskService {

    @Autowired
    private TaskDAO<Task> taskDAO;

    public ArrayList<Task> getAllTasks() {
        return  taskDAO.findAllTasks();
    }

    }

