package CS5721.project.records.entity;

import java.util.Date;

public class Records {

    private int recordId;
    private String recordName;
    private String trainingBody;
    private Date trainingDate;
    private Date expiryDate;
    private Boolean completed;
    private long employeeId;
    private String employeeName;

    public Records(int recordId, String recordName, String trainingBody, Date trainingDate, Date expiryDate, Boolean completed, long employeeId, String employeeName) {
        this.recordId = recordId;
        this.recordName = recordName;
        this.trainingBody = trainingBody;
        this.trainingDate = trainingDate;
        this.expiryDate = expiryDate;
        this.completed = completed;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getRecordName(){
        return recordName;}

    public void setRecordName (String recordName){
        this.recordName = recordName;
    }
    public String getTrainingBody () {
        return trainingBody;
    }

    public void setTrainingBody(String trainingBody) {
        this.trainingBody = trainingBody;
    }

    public void setTrainingDate(Date trainingDate) {
        this.trainingDate = trainingDate;
    }
    public Date getTrainingDate () {
        return trainingDate;
    }
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
    public Date getExpiryDate() {
        return expiryDate;
    }
    public Boolean getCompleted(){
        return completed;
    }
    public void setCompleted(Boolean completed){
        this.completed = completed;
    }
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName;
    }
    public long getEmployeeId(){
        return employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }





}


