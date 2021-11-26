package CS5721.project.task.entity;
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
        Task task4 = new Task(4, "Research", "Research Assignment", "Kate", 18L,LocalDateTime.of(2021,11,25,14,0),LocalDateTime.of(2021,11,25,18,0),false);
        taskList.add(task4);
    }


    public ArrayList<Task> findAllTasks() {
        return (ArrayList<Task>) taskList;
    }

    @Override
    public ArrayList<Task> findEmployeeTasks(Long employeeId) {

        ArrayList<Task> _taskList = new ArrayList<Task>();

        for (Task task : taskList){
            Long id = task.getEmployeeId();
            if (id.equals(employeeId)){
                _taskList.add(task);
            }
        }

        return _taskList;
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
