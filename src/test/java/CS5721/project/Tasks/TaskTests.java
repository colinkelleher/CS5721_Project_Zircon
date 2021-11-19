package CS5721.project.Tasks;

import CS5721.project.tasks.Task;
import CS5721.project.tasks.TaskDAO;
import CS5721.project.tasks.TaskDAOimpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class TaskTests {
    TaskDAO taskDAO = new TaskDAOimpl();

    Task task4 = new Task(44,"Refactoring","Refactor lines 1-33","Ewen",1L, LocalDateTime.of(2021,11,15,11,30,0),LocalDateTime.of(2021,11,15,14,30,0), false);


    @Test
    public void TaskIdTest(){
        Task task = taskDAO.findAllTasks().get(0);
        Assertions.assertEquals(1,task.getTaskId());
    }

    @Test
    public void TaskEmployeeTest(){
        Task task = taskDAO.getTask(1);
        Assertions.assertEquals("Colin",task.getTeamEmployee());
    }

    @Test
    public void TaskEmployeeIdTest(){
        Task taskIdEmp = taskDAO.getTask(1);
        Assertions.assertEquals(1,taskIdEmp.getEmployeeId());
    }

    @Test
    public void TaskUpdateEmployee(){
        Task taskupdate = taskDAO.getTask(1);
        taskupdate.setEmployeeId(2);
        Assertions.assertEquals(2,taskDAO.getTask(1).getEmployeeId());
    }

    @Test
    public void AddTaskTest() {
        List<Task> new_tasks;
        new_tasks = new ArrayList<Task>();
        new_tasks.add(task4);
        Assertions.assertEquals(task4,new_tasks.get(0));
    }

    @Test
    public void RemoveTaskTest() {
        List<Task> new_tasks;
        new_tasks = new ArrayList<Task>();
        new_tasks.add(task4);
        Assertions.assertEquals(task4,new_tasks.get(0));
        new_tasks.remove(0);
        Assertions.assertTrue(new_tasks.isEmpty());

    }


}
