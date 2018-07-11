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
public class ExamDetails {
    private int ExamDetailID;
    private Exams ExamID; 
    private Question QuestionID;
    private Answers AnswerID;

    public ExamDetails() {
    }

    public ExamDetails(int ExamDetailID, Exams ExamID, Question QuestionID, Answers AnswerID) {
        this.ExamDetailID = ExamDetailID;
        this.ExamID = ExamID;
        this.QuestionID = QuestionID;
        this.AnswerID = AnswerID;
    }

    public int getExamDetailID() {
        return ExamDetailID;
    }

    public void setExamDetailID(int ExamDetailID) {
        this.ExamDetailID = ExamDetailID;
    }

    public Exams getExamID() {
        return ExamID;
    }

    public void setExamID(Exams ExamID) {
        this.ExamID = ExamID;
    }

    public Question getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(Question QuestionID) {
        this.QuestionID = QuestionID;
    }

    public Answers getAnswerID() {
        return AnswerID;
    }

    public void setAnswerID(Answers AnswerID) {
        this.AnswerID = AnswerID;
    }
    
   
    
}
