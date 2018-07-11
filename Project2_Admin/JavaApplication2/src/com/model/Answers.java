/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author Admin
 */
public class Answers {
    private int AnswerID;
    private String AnswerDetail;
    private int IsCorrect;
    private Question QuestionID; 

    public Answers() {
    }

    public Answers(int AnswerID, String AnswerDetail, int IsCorrect, Question QuestionID) {
        this.AnswerID = AnswerID;
        this.AnswerDetail = AnswerDetail;
        this.IsCorrect = IsCorrect;
        this.QuestionID = QuestionID;
    }

    public int getAnswerID() {
        return AnswerID;
    }

    public void setAnswerID(int AnswerID) {
        this.AnswerID = AnswerID;
    }

    public String getAnswerDetail() {
        return AnswerDetail;
    }

    public void setAnswerDetail(String AnswerDetail) {
        this.AnswerDetail = AnswerDetail;
    }

    public int getIsCorrect() {
        return IsCorrect;
    }

    public void setIsCorrect(int IsCorrect) {
        this.IsCorrect = IsCorrect;
    }

    public Question getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(Question QuestionID) {
        this.QuestionID = QuestionID;
    }
    
    
    
}
