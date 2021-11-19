package CS5721.project.tasks;

import java.util.List;

public interface TaskDAO {
    List<Task> findAllTasks();
    int insertTask(Task newTask);
    void deleteTask(Task task);
    Task getTask(int taskId);
    Task setCompleted(int taskId);

}
