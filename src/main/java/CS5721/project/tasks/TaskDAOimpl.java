package CS5721.project.tasks;

import CS5721.project.entity.person.Employee;

import java.util.ArrayList;
import java.util.List;

public class TaskDAOimpl implements TaskDAO {

    List<Task> tasks;

    public TaskDAOimpl() {
        tasks = new ArrayList<Task>();
        Task task1 = new Task(1, "Research", "Research Assignment", "Colin", 1L);
        tasks.add(task1);
        Task task2 = new Task(2, "Research", "Research Assignment", "Colin", 1L);
        tasks.add(task2);
        Task task3 = new Task(3, "Research", "Research Assignment", "Colin", 2L);
        tasks.add(task3);
    }


    public List<Task> findAllTasks() {
        return tasks;
    }

    @Override
    public Task getTask(int taskId) {
        return tasks.get(taskId);
    }


    @Override
    public void deleteTask(Task task) {
        tasks.remove(task.getTaskId());
    }

    @Override
    public int insertTask(Task newTask) {
        return 0;
    }
}
