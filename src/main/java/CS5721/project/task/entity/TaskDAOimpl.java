package CS5721.project.tasks;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class TaskDAOimpl implements TaskDAO<Task> {

    private List<Task> taskList = new ArrayList<>();

    public TaskDAOimpl() {
        Task task1 = new Task(1, "Research", "Research Assignment", "Ewen", 1L,LocalDateTime.of(2021,11,5,9,0),LocalDateTime.of(2021,11,10,18,0),false);
        taskList.add(task1);
        Task task2 = new Task(2, "Research", "Research Assignment", "Ewen", 1L, LocalDateTime.of(2021,11,5,9,0),LocalDateTime.of(2021,11,5,18,0),false);
        taskList.add(task2);
        Task task3 = new Task(3, "Research", "Research Assignment", "Colin", 2L,LocalDateTime.of(2021,11,20,9,0),LocalDateTime.of(2021,11,25,18,0),true);
        taskList.add(task3);
    }


    public ArrayList<Task> findAllTasks() {
        return (ArrayList<Task>) taskList;
    }

    @Override
    public int insertTask(Task newTask) {
        return 0;
    }

    @Override
    public Task getTask(int taskId) {
        return taskList.get(taskId);
    }

    @Override
    public Task setCompleted(int taskId) {
        return taskList.get(taskId).setTaskCompleted();
    }

    @Override
    public void deleteTask(Task task) {
        taskList.remove(task.getTaskId());
    }

}
