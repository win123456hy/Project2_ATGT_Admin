/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Users {
    private int UserID;
    private String Username;
    private int Gender;
    private String Email;
    private String Password;
    private Date CreatedTime;
    public Users() {
    }

    public Users(int UserID, String Username, int Gender, String Email, String Password, Date CreatedTime) {
        this.UserID = UserID;
        this.Username = Username;
        this.Gender = Gender;
        this.Email = Email;
        this.Password = Password;
        this.CreatedTime = CreatedTime;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int Gender) {
        this.Gender = Gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Date getCreatedTime() {
        return CreatedTime;
    }

    public void setCreatedTime(Date CreatedTime) {
        this.CreatedTime = CreatedTime;
    }

  
    
    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }
    
}
