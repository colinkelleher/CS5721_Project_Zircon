package CS5721.project.tasks;

import java.util.List;

public interface TaskDAO {
    public List<Task> findAllTasks();
    public int insertTask(Task newTask);
    public void deleteTask (Task task);
    public Task getTask(int taskId);

}
