    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lecturer;

/**
 *
 * @author zrche
 */
// this java class is to save the assessment details for the checking process of which student already done the report submission for 
// the specific assessment chosen.

// Besides, this java class also help to save the report submission details for the marking process 
public class Submission {
    
    protected String intakeCode;
    protected String assessmentType;
    protected String studentId;
    protected String submissionFile;
    protected String submissionDate;
    
    public Submission(String intakeCode,String assessmentType){
        this.intakeCode = intakeCode;
        this.assessmentType = assessmentType;
    }
    
    public Submission(String intakeCode,String studentId,String assessmentType){
        this.intakeCode = intakeCode;
        this.studentId = studentId;
        this.assessmentType = assessmentType;
    }
    
    public Submission(String intakeCode,String assessmentType,String studentId,String submissionFile, String submissionDate){
        this.intakeCode = intakeCode;
        this.assessmentType = assessmentType;
        this.studentId = studentId;
        this.submissionFile = submissionFile;
        this.submissionDate = submissionDate;
    }
    
    // Getters
    public String getIntakeCode() {
        return intakeCode;
    }

    public String getAssessmentType() {
        return assessmentType;
    }
    
    public String getStudentId() {
        return studentId;
    }
    
    public String getSubmissionFile() {
        return submissionFile;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    // Setters
    public void setIntakeCode(String intakeCode) {
        this.intakeCode = intakeCode;
    }

    public void setAssessmentType(String assessmentType) {
        this.assessmentType = assessmentType;
    }
    
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
    public void setSubmissionFile(String submissionFile) {
        this.submissionFile = submissionFile;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }
}
