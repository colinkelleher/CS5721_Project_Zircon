package CS5721.project.task.entity;


import java.util.ArrayList;


public interface TaskDAO<T> {
    ArrayList<T> findAllTasks();
    ArrayList<T> findEmployeeTasks(Long employeeId);
    int insertTask(T t);
    void deleteTask(T t);
    Task getTask(int tId);
    Task setCompleted(int tId);

}
