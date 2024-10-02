/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user_class;

import Lecturer.Submission;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author zrche
 */
public class Lecturer extends User{
    private String department;
    private String assignedProjectManager;
    
    public Lecturer(String id,String password,String role,String name,String gender,String nationality,String department,String assignedProjectManager){
        super(id,password,role,name,gender,nationality);
        this.department = department;
        this.assignedProjectManager = assignedProjectManager;
    }
    
    public Lecturer(){
        
    }
    
    public String getDepartment(){
        return department;
    }
    
    public void setDepartment(String department){
        this.department = department;
    }
    
    public String getAssignedProjectManager(){
        return assignedProjectManager;
    }
    
    public void setAssignedProjectManager(String assignedProjectManager){
        this.assignedProjectManager = assignedProjectManager;
    }
    
    public void allotGrade(String IntakeCode,String AssessmentType,String StudentId,int marks){
        String reportfile = "src\\textfile\\report.txt";
        List<String> lines = new ArrayList<>();

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
            if (parts.length > 0 && parts[0].equals(IntakeCode) && parts[1].equals(StudentId) && parts[2].equals(AssessmentType)) {
                //change the details in the textfile
                parts[6] = String.valueOf(marks);
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
    
    // accept the marks that given by the lecturer
    public void acceptSecondMarker(Submission submission){
        String reportfile = "src\\textfile\\report.txt";
        List<String> lines = new ArrayList<>();

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
            if (parts.length > 0 && parts[0].equals(submission.getIntakeCode()) && parts[1].equals(submission.getStudentId()) && parts[2].equals(submission.getAssessmentType())) {
                //change the details in the textfile
                parts[8] = "accept";
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
    
    public void validatePresentationRequest(String studentId,String lecturerId,String date, String time,String validation,String remarks){
        String presentationfile = "src\\textfile\\presentation.txt";
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(presentationfile))) {
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
            if (parts.length > 0 && parts[0].equals(studentId) && parts[1].equals(date) && parts[2].equals(time)&& parts[3].equals(lecturerId)) {
                //change the details in the textfile
                parts[5] = validation;
                parts[6] = remarks;
                lines.set(i, String.join(",", parts));
                break;
            }
        }

        // Rewrite the modified contents back to the text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(presentationfile))) {
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
        String lecturersFile = "src\\textfile\\lecturer.txt";
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
        
        // for lecturers file
        List<String> lecturerslines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(lecturersFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lecturerslines.add(line);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }

        // Modify the details in the list
        for (int i = 0; i < lecturerslines.size(); i++) {
            String[] parts = lecturerslines.get(i).split(",");
            if (parts.length > 0 && parts[0].equals(userId)) {
                //change the details in the textfile
                parts[1] = newPassword;
                lines.set(i, String.join(",", parts));
                break;
            }
        }

        // Rewrite the modified contents back to the text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(lecturersFile))) {
            for (String updatedLine : lecturerslines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }
    }
    
    
}
