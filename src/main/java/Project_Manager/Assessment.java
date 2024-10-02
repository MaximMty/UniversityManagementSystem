/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_Manager;

/**
 *
 * @author zrche
 */
public class Assessment {
    
    private String intakeCode;
    private String assessmentType;
    private String supervisor;
    private String secondMarker;
    private String dueDate;
    private String studentId;
    
    
    // for intake edit assessment
    public Assessment(String intakeCode,String assessmentType,String supervisor,String secondMarker,String dueDate){
       this.intakeCode = intakeCode;
       this.assessmentType = assessmentType;
       this.supervisor = supervisor;
       this.secondMarker = secondMarker;
       this.dueDate = dueDate;
    }
    
    
    //for individual edit assessment
    public Assessment(String intakeCode,String studentID,String assessmentType,String supervisor,String secondMarker,String dueDate){
        this.intakeCode = intakeCode;
        this.studentId = studentID;
        this.assessmentType= assessmentType;
        this.supervisor = supervisor;
        this.secondMarker = secondMarker;
        this.dueDate = dueDate;
    }
    
    // for intake view report
    public Assessment(String intakeCode,String assessmentType){
        this.intakeCode = intakeCode;
        this.assessmentType = assessmentType;
    }
    
    // for individual view report
    public Assessment(String studentId){
        this.studentId = studentId;
    }
    
    public String getStudentId(){
        return studentId;
    }
    
    public void setStudentId(String studentID){
        this.studentId = studentID;
    }
    
    public String getIntakeCode() {
        return intakeCode;
    }

    public void setIntakeCode(String intakeCode) {
        this.intakeCode = intakeCode;
    }

    public String getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(String assessmentType) {
        this.assessmentType = assessmentType;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getSecondMarker() {
        return secondMarker;
    }

    public void setSecondMarker(String secondMarker) {
        this.secondMarker = secondMarker;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
