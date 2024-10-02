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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author zrche
 */
public class ProjectManager extends User{
    private String department;
    
    public ProjectManager(String id,String password,String role,String name,String gender,String nationality,String department){
        super(id,password,role,name,gender,nationality);
        this.department = department;
    }
    
    public ProjectManager(){
        
    }
    
    public void allotIntakeAssessment(String intake,String assessmentType,String supervisor, String secondMarker, String date){
        String assessmentfile = "src\\textfile\\Assessment.txt"; 
        String newAssessment = intake + ",none," + assessmentType + "," + supervisor + "," + secondMarker + "," + date;
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(assessmentfile, true))) {
            writer.write(newAssessment);
            writer.newLine(); // Move to the next line
            
        } catch (IOException e) {
            System.err.println("Error writing to the file! ");
        }
    }
    
    public void allotIndividualAssessment(String studentId,String assessmentType,String supervisor, String secondMarker, String date){
        String assessmentfile = "src\\textfile\\Assessment.txt"; 
        String newAssessment = "NONE(INDIVIDUAL)," + studentId + "," + assessmentType + "," + supervisor + "," + secondMarker + "," + date;
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(assessmentfile, true))) {
            writer.write(newAssessment);
            writer.newLine(); // Move to the next line
            
        } catch (IOException e) {
            System.err.println("Error writing to the file! ");
        }
    }
    
    public void editIntakeAssessment(String editedIntake, String editedAssessmentType, String editedSupervisor,String editedSecondMarker,String editedDuedate){
        String assessmentfile = "src\\textfile\\Assessment.txt";
        String newDetails = editedIntake + ",none," + editedAssessmentType + "," + editedSupervisor + "," + editedSecondMarker + "," + editedDuedate;
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(assessmentfile))) {
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
            if (parts.length > 0 && parts[0].equals(editedIntake) && parts[2].equals(editedAssessmentType)) {
                lines.set(i, newDetails);
                break;
            }
        }

        // Rewrite the modified contents back to the text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(assessmentfile))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }
    }
    
    public void editIndividualAssessment(String editedStudentId, String editedAssessmentType, String editedSupervisor,String editedSecondMarker,String editedDuedate){
        String assessmentfile = "src\\textfile\\Assessment.txt";
        String newDetails = "NONE(INDIVIDUAL)," + editedStudentId + "," + editedAssessmentType + "," + editedSupervisor + "," + editedSecondMarker + "," + editedDuedate;
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(assessmentfile))) {
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
            if (parts.length > 0 && parts[1].equals(editedStudentId) && parts[2].equals(editedAssessmentType)) {
                lines.set(i, newDetails);
                break;
            }
        }

        // Rewrite the modified contents back to the text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(assessmentfile))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }
    }
    
    public void deleteIntakeAssessment(String deleteIntakeCode, String deleteAssessmentType){
        String assessmentfile = "src\\textfile\\Assessment.txt";
        List<String> lines = new ArrayList<>();
        
        // delete data from the student.txt
        
        try (BufferedReader reader = new BufferedReader(new FileReader(assessmentfile))) {
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
            if (parts.length > 0 && parts[0].equals(deleteIntakeCode) && parts[2].equals(deleteAssessmentType)) {
                lines.remove(i);
                break;
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(assessmentfile))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }
    }
    
    public void deleteIndividualAssessment(String deleteStudentId, String deleteAssessmentType){
        String assessmentfile = "src\\textfile\\Assessment.txt";
        List<String> lines = new ArrayList<>();
        
        // delete data from the student.txt
        
        try (BufferedReader reader = new BufferedReader(new FileReader(assessmentfile))) {
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
            if (parts.length > 0 && parts[1].equals(deleteStudentId) && parts[2].equals(deleteAssessmentType)) {
                lines.remove(i);
                break;
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(assessmentfile))) {
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
