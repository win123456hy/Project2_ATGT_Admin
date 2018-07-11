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
public class Question {
    private int QuestionID;
        private String QuestionDetail ;
            private Categorys CategoryID ;

    public Question(int QuestionID, String QuestionDetail, Categorys CategoryID) {
        this.QuestionID = QuestionID;
        this.QuestionDetail = QuestionDetail;
        this.CategoryID = CategoryID;
    }

   

  
    public Question() {
    }

            
    public int getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(int QuestionID) {
        this.QuestionID = QuestionID;
    }

    public String getQuestionDetail() {
        return QuestionDetail;
    }

    public void setQuestionDetail(String QuestionDetail) {
        this.QuestionDetail = QuestionDetail;
    }

    public Categorys getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(Categorys CategoryID) {
        this.CategoryID = CategoryID;
    }



  
            
}
