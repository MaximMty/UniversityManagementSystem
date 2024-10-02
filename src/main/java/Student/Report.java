/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Student;

/**
 *
 * @author zrche
 */
public class Report {
    
    protected String assessmentType;
    protected String supervisor;
    protected String filepath;
    protected String intakeCode;
    protected String studentId;
    protected String secondMarker;
    
    // for report submission
    public Report(String intakeCode, String assessmentType,String supervisor,String secondMarker){
        this.intakeCode = intakeCode;
        this.assessmentType= assessmentType;
        this.supervisor = supervisor;
        this.secondMarker = secondMarker;
    }
    
    //for report editing
    public Report(String intakeCode,String assessmentType,String supervisor,String secondMarker,String filepath){
        this.intakeCode = intakeCode;
        this.assessmentType= assessmentType;
        this.supervisor = supervisor;
        this.filepath = filepath;
        this.secondMarker = secondMarker;
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
    
    public String getFilePath(){
        return this.filepath;
    } 
    
    public String getIntakeCode(){
        return this.intakeCode;
    }
    
    
    public String getSecondMarker(){
        return this.secondMarker;
    }
}
