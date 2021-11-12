package CS5721.project.tasks;

import CS5721.project.entity.person.Employee;

public class Task {


    private int taskId;
    private String taskName;
    private String taskDescription;
    private String teamEmployee;
    private long employeeId;

    public Task(int taskId, String taskName, String taskDescription, String teamEmployee, Long employeeId){
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.teamEmployee = teamEmployee;
        this.employeeId = employeeId;

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
}
