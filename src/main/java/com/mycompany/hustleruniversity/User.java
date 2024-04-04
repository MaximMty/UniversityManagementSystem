package com.mycompany.hustleruniversity;


public class User {
    
    private String login;
    private String role;

    public User(String login, String role) {
        this.login = login;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public String getRole() {
        return role;
    }
}