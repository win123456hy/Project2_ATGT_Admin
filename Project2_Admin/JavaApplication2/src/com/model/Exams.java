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
public class Exams {
    private int ExamID;
    private Date CreatedTime;
    private Users UsersID;
    private int Score;    

    public Exams() {
    }

    public Exams(int ExamID, Date CreatedTime, Users UsersID, int Score) {
        this.ExamID = ExamID;
        this.CreatedTime = CreatedTime;
        this.UsersID = UsersID;
        this.Score = Score;
    }

    public int getExamID() {
        return ExamID;
    }

    public void setExamID(int ExamID) {
        this.ExamID = ExamID;
    }

    public Date getCreatedTime() {
        return CreatedTime;
    }

    public void setCreatedTime(Date CreatedTime) {
        this.CreatedTime = CreatedTime;
    }

    public Users getUsersID() {
        return UsersID;
    }

    public void setUsersID(Users UsersID) {
        this.UsersID = UsersID;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

   
    
    
    
}
