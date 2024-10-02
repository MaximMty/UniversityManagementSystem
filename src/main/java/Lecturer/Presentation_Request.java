/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lecturer;

/**
 *
 * @author zrche
 */
public class Presentation_Request {
    
    protected String studentId;
    protected String date;
    protected String time;
    
    
    public Presentation_Request(String studentId,String date,String time){
        this.studentId = studentId;
        this.date = date;
        this.time = time;
    }
    
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
