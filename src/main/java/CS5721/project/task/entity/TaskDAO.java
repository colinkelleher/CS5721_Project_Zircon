package CS5721.project.tasks;


import java.util.ArrayList;


public interface TaskDAO<T> {
    ArrayList<T> findAllTasks();
    int insertTask(T t);
    void deleteTask(T t);
    Task getTask(int tId);
    Task setCompleted(int tId);

}