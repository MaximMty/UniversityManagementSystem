/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user_class;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author zrche
 */
public class Student extends User{
    private String intakeCode;
    
    public Student(String id,String password,String role,String name,String gender,String nationality,String intakeCode){
        super(id,password,role,name,gender,nationality);
        this.intakeCode = intakeCode;
    }
    
    public Student(){
    }
    
    public String getIntakeCode(){
        return this.intakeCode;
    }
    
    public void setIntakeCode(String intakeCode){
        this.intakeCode = intakeCode;
    }
    
    
    public void requestPresentation(String lecturerID,String lecturerName,String studentID,String presentationDate, String presentationTime){
        String presentationfile = "src\\textfile\\presentation.txt"; 
        String presentationReq = studentID + "," + presentationDate +","+ presentationTime + "," + lecturerID + "," + lecturerName + ",Waiting For Response,none";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(presentationfile, true))) {
            // Append the new user information to the end of the file
            writer.write(presentationReq);
            writer.newLine(); // Move to the next line
            
        } catch (IOException e) {
            System.err.println("Error writing to the file! ");
        }
    }
    
    public void reportSubmission(String intakeCode,String studentId,String assessmentType,String reportFilePath,String supervisor, String secondMarker){
        String reportfile = "src\\textfile\\report.txt";
        Date currentDate = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("EEE MMM dd yyyy");
        String formattedDate = dateformat.format(currentDate);
        
        String newSubmission = intakeCode + "," + studentId + "," + assessmentType + "," + reportFilePath + "," + formattedDate +","+ supervisor + ",none," + secondMarker + ",none" ;
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportfile, true))) {
            writer.write(newSubmission);
            writer.newLine(); // Move to the next line
            
        } catch (IOException e) {
            System.err.println("Error writing to the file! ");
        }
    }
    
    public void reportEditing(String intakeCode,String studentId,String assessmentType,String editedreportFilePath){
        String reportfile = "src\\textfile\\report.txt";
        List<String> lines = new ArrayList<>();
        
        // for report file
        try (BufferedReader reader = new BufferedReader(new FileReader(reportfile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }

        // Modify the details in the list
        for (int i = 0; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            if (parts.length > 0 && parts[0].equals(intakeCode) && parts[1].equals(studentId) && parts[2].equals(assessmentType)) {
                //change the details in the textfile
                parts[3] = editedreportFilePath;
                lines.set(i, String.join(",", parts));
                break;
            }
        }

        // Rewrite the modified contents back to the text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportfile))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }
    }
    
    @Override
    public void changePassword(String userId, String newPassword){
        String userfile = "src\\textfile\\users.txt";
        String studentFile = "src\\textfile\\student.txt";
        List<String> lines = new ArrayList<>();
        
        // for user file
        try (BufferedReader reader = new BufferedReader(new FileReader(userfile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }

        // Modify the details in the list
        for (int i = 0; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            if (parts.length > 0 && parts[0].equals(userId)) {
                //change the details in the textfile
                parts[1] = newPassword;
                lines.set(i, String.join(",", parts));
                break;
            }
        }

        // Rewrite the modified contents back to the text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userfile))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }
        
        // for student file
        List<String> studentslines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(studentFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                studentslines.add(line);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }

        // Modify the details in the list
        for (int i = 0; i < studentslines.size(); i++) {
            String[] parts = studentslines.get(i).split(",");
            if (parts.length > 0 && parts[0].equals(userId)) {
                //change the details in the textfile
                parts[1] = newPassword;
                lines.set(i, String.join(",", parts));
                break;
            }
        }

        // Rewrite the modified contents back to the text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(studentFile))) {
            for (String updatedLine : studentslines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }
    }
}
