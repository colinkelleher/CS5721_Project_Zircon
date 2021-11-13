package CS5721.project.tasks;

import CS5721.project.entity.person.Employee;

import java.time.LocalDateTime;

public class Task {

    private int taskId;
    private String taskName;
    private String taskDescription;
    private String teamEmployee;
    private long employeeId;
    private LocalDateTime taskStartDate;
    private LocalDateTime taskEndDate;

    public Task(int taskId, String taskName, String taskDescription, String teamEmployee, Long employeeId, LocalDateTime taskStartDate, LocalDateTime taskEndDate){
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.teamEmployee = teamEmployee;
        this.employeeId = employeeId;
        this.taskStartDate = taskStartDate;
        this.taskEndDate = taskEndDate;

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
}
