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
public class User {
    private String id;
    private String password;
    private String role;
    private String name;
    private String gender;
    private String nationality;
    
    public User(String id,String password,String role,String name,String gender,String nationality){
        this.id = id;
        this.password = password;
        this.role = role;
        this.name = name;
        this.gender = gender;
        this.nationality = nationality;
    }
    
    public User(String id,String role,String name){
        this.id = id;
        this.role = role;
        this.name = name;
    }
    
    public void changePassword(String userId, String newPassword){
        String userfile = "src\\textfile\\users.txt";
        List<String> lines = new ArrayList<>();
        String role = null;
        
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
            if (parts.length > 0 && parts[1].equals(userId)) {
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
    }
    
    public User(){
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole(){
        return role;
    }
    
    public void setRole(String role){
        this.role = role;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getGender(){
        return gender;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
    
    public String getNationality(){
        return nationality;
    }
    
    public void setNationality(String nationality){
        this.nationality = nationality;
    }
}
