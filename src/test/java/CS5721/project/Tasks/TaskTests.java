package CS5721.project.Tasks;

import CS5721.project.tasks.Task;
import CS5721.project.tasks.TaskDAO;
import CS5721.project.tasks.TaskDAOimpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TaskTests {
    TaskDAO taskDAO = new TaskDAOimpl();

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

}
