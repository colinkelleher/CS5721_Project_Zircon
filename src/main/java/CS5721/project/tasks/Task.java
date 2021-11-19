package CS5721.project.tasks;

import java.time.LocalDateTime;

public class Task {

    private int taskId;
    private String taskName;
    private String taskDescription;
    private String teamEmployee;
    private long employeeId;
    private final LocalDateTime taskStartDate;
    private final LocalDateTime taskEndDate;
    private boolean completed;



    public Task(int taskId, String taskName, String taskDescription, String teamEmployee, Long employeeId, LocalDateTime taskStartDate, LocalDateTime taskEndDate, boolean completed){
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.teamEmployee = teamEmployee;
        this.employeeId = employeeId;
        this.taskStartDate = taskStartDate;
        this.taskEndDate = taskEndDate;
        this.completed = completed;

    }

    public int getTaskId() {
        return taskId;
    }
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public String getTaskDescription() {
        return taskDescription;
    }
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    public String getTeamEmployee() {
        return teamEmployee;
    }
    public void setTeamEmployee(String teamEmployee) {
        this.teamEmployee =  teamEmployee;
    }
    public void setEmployeeId(long employeeId) {this.employeeId = employeeId;}
    public long getEmployeeId(){return employeeId;}

    public Task setTaskCompleted() {
        this.completed = true;

        return null;
    }
    public boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getTaskStartDate() {
        return taskStartDate;
    }

    public LocalDateTime getTaskEndDate() {
        return taskEndDate;
    }
}
