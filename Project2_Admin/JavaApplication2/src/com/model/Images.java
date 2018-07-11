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
public class Images {
    private int ImageID;
    private String ImageLinks;
    private Question QuestionID;

    public int getImageID() {
        return ImageID;
    }

    public void setImageID(int ImageID) {
        this.ImageID = ImageID;
    }

    public String getImageLinks() {
        return ImageLinks;
    }

    public void setImageLinks(String ImageLinks) {
        this.ImageLinks = ImageLinks;
    }

    public Question getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(Question QuestionID) {
        this.QuestionID = QuestionID;
    }

    public Images() {
    }

    public Images(int ImageID, String ImageLinks, Question QuestionID) {
        this.ImageID = ImageID;
        this.ImageLinks = ImageLinks;
        this.QuestionID = QuestionID;
    }
    
}
