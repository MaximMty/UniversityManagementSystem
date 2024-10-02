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
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author zrche
 */
public class Admin extends User{
    
    public Admin(String id,String password,String role,String name,String gender,String nationality){
        super(id,password,role,name,gender,nationality);
    }
    
    public Admin(){
        
    }
    
    public void registerStudent(String id,String password,String name,String gender,String nationality,String intakeCode){
        String studentfile = "src\\textfile\\student.txt"; 
        String userfile = "src\\textfile\\users.txt";
        String newStudent = id + "," + password + "," + name + "," + gender + "," + nationality + "," + intakeCode; 
        String newUser = id + "," + password + ",student";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(studentfile, true))) {
            // Append the new user information to the end of the file
            writer.write(newStudent);
            writer.newLine(); // Move to the next line
            
        } catch (IOException e) {
            System.err.println("Error writing to the file! ");
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userfile, true))) {
            // Append the new user information to the end of the file
            writer.write(newUser);
            writer.newLine(); // Move to the next line
            
        } catch (IOException e) {
            System.err.println("Error writing to the file! ");
        }
        
        
    }
    
    public void registerLecturer(String id,String password,String name,String gender,String nationality,String department){
        String lecturerfile = "src\\textfile\\lecturer.txt"; 
        String userfile = "src\\textfile\\users.txt";
        String newLecturer = id + "," + password + "," + name + "," + gender + "," + nationality + "," + department + ",false"; 
        String newUser = id + "," + password + ",lecturer";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(lecturerfile, true))) {
            // Append the new user information to the end of the file
            writer.write(newLecturer);
            writer.newLine(); // Move to the next line
            
        } catch (IOException e) {
            System.err.println("Error writing to the file! ");
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userfile, true))) {
            // Append the new user information to the end of the file
            writer.write(newUser);
            writer.newLine(); // Move to the next line
            
        } catch (IOException e) {
            System.err.println("Error writing to the file! ");
        }
        
        
    }
    
    public void editStudent(String editId,String editPassword,String editName,String editNationality,String editGender,String editIntakeCode){
        String studentfile = "src\\textfile\\student.txt";
        String newDetails = editId + "," + editPassword + "," + editName + "," + editNationality + "," + editGender + "," + editIntakeCode;
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(studentfile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
        }

        // Modify the details in the list
        boolean found = false;
        for (int i = 0; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            if (parts.length > 0 && parts[0].equals(editId)) {
                lines.set(i, newDetails);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("ID " + editId + " not found in the text file.");
            return;
        }

        // Rewrite the modified contents back to the text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(studentfile))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }
    }
    
    public void editLecturer(String editId,String editPassword,String editName,String editNationality,String editGender,String editDepartment, String AssignStatus){
        String lecturerfile = "src\\textfile\\lecturer.txt";
        String newDetails = editId + "," + editPassword + "," + editName + "," + editNationality + "," + editGender + "," + editDepartment + "," + AssignStatus;
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(lecturerfile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }

        // Modify the details in the list
        boolean found = false;
        for (int i = 0; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            if (parts.length > 0 && parts[0].equals(editId)) {
                lines.set(i, newDetails);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("ID " + editId + " not found in the text file.");
            return;
        }

        // Rewrite the modified contents back to the text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(lecturerfile))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }
    }
    
    public void deleteStudent(String deleteId){
        String studentfile = "src\\textfile\\student.txt";
        String userfile = "src\\textfile\\users.txt";
        List<String> lines = new ArrayList<>();
        List<String> lineForUserTxt = new ArrayList<>();
        
        // delete data from the student.txt
        
        try (BufferedReader reader = new BufferedReader(new FileReader(studentfile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }

        // Modify the details in the list
        boolean found = false;
        for (int i = 0; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            if (parts.length > 0 && parts[0].equals(deleteId)) {
                lines.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("ID " + deleteId + " not found in the text file.");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(studentfile))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }
        
        // delete data from the user.txt
        
        try (BufferedReader reader = new BufferedReader(new FileReader(userfile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineForUserTxt.add(line);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }

        // Modify the details in the list
        boolean founds = false;
        for (int i = 0; i < lineForUserTxt.size(); i++) {
            String[] parts = lineForUserTxt.get(i).split(",");
            if (parts.length > 0 && parts[0].equals(deleteId)) {
                lineForUserTxt.remove(i);
                founds = true;
                break;
            }
        }
        if (!founds) {
            System.out.println("ID " + deleteId + " not found in the text file.");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userfile))) {
            for (String updatedLine : lineForUserTxt) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }
    }
    
    public void deleteLecturer(String deleteId){
        String lecturerfile = "src\\textfile\\lecturer.txt";
        String userfile = "src\\textfile\\users.txt";
        List<String> lines = new ArrayList<>();
        List<String> lineForUserTxt = new ArrayList<>();
        
        // delete data from the student.txt
        
        try (BufferedReader reader = new BufferedReader(new FileReader(lecturerfile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }

        // Modify the details in the list
        boolean found = false;
        for (int i = 0; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            if (parts.length > 0 && parts[0].equals(deleteId)) {
                lines.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("ID " + deleteId + " not found in the text file.");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(lecturerfile))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }
        
        // delete data from the user.txt
        
        try (BufferedReader reader = new BufferedReader(new FileReader(userfile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineForUserTxt.add(line);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }

        // Modify the details in the list
        boolean founds = false;
        for (int i = 0; i < lineForUserTxt.size(); i++) {
            String[] parts = lineForUserTxt.get(i).split(",");
            if (parts.length > 0 && parts[0].equals(deleteId)) {
                lineForUserTxt.remove(i);
                founds = true;
                break;
            }
        }
        if (!founds) {
            System.out.println("ID " + deleteId + " not found in the text file.");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userfile))) {
            for (String updatedLine : lineForUserTxt) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }
    }

    public void allotProjectManager(String Id,String Password,String Name,String Nationality,String Gender,String Department, String editAssignStatus){
        String lecturerfile = "src\\textfile\\lecturer.txt";
        String userfile = "src\\textfile\\users.txt";
        
        // rewrite the information in lecturerfile text file
        String newDetails = Id + "," + Password + "," + Name + "," + Nationality + "," + Gender + "," + Department + "," + editAssignStatus;
        List<String> lecturerFilelines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(lecturerfile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lecturerFilelines.add(line);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }
        // Modify the details in the list
        boolean found = false;
        for (int i = 0; i < lecturerFilelines.size(); i++) {
            String[] parts = lecturerFilelines.get(i).split(",");
            if (parts.length > 0 && parts[0].equals(Id)) {
                lecturerFilelines.set(i, newDetails);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("ID " + Id + " not found in the text file.");
            return;
        }
        // Rewrite the modified contents back to the text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(lecturerfile))) {
            for (String updatedLine : lecturerFilelines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }
        
        //rewrite the information in the userfile textfile
        String NewRole="";
        if("true".equals(editAssignStatus)){
            NewRole = "project manager";
        }else{
            NewRole = "lecturer";
        }
        String newDetail = Id + "," + Password + ","  + NewRole;
        List<String> userFilelines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(userfile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                userFilelines.add(line);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }
        // Modify the details in the list
        boolean founds = false;
        for (int i = 0; i < userFilelines.size(); i++) {
            String[] parts = userFilelines.get(i).split(",");
            if (parts.length > 0 && parts[0].equals(Id)) {
                userFilelines.set(i, newDetail);
                founds = true;
                break;
            }
        }
        if (!founds) {
            System.out.println("ID " + Id + " not found in the text file.");
            return;
        }
        // Rewrite the modified contents back to the text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userfile))) {
            for (String updatedLine : userFilelines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }
    }
}
