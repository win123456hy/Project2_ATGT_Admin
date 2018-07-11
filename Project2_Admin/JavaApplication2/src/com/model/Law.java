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
public class Law {

    private int LawID;
    private String LawTitle;
    private String LawDetail;
    private Date LawTimeRelease;
    private Categorys CategoryID;

    public int getLawID() {
        return LawID;
    }

    public void setLawID(int LawID) {
        this.LawID = LawID;
    }

    public String getLawTitle() {
        return LawTitle;
    }

    public void setLawTitle(String LawTitle) {
        this.LawTitle = LawTitle;
    }

    public String getLawDetail() {
        return LawDetail;
    }

    public void setLawDetail(String LawDetail) {
        this.LawDetail = LawDetail;
    }

    public Date getLawTimeRelease() {
        return LawTimeRelease;
    }

    public void setLawTimeRelease(Date LawTimeRelease) {
        this.LawTimeRelease = LawTimeRelease;
    }

    public Categorys getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(Categorys CategoryID) {
        this.CategoryID = CategoryID;
    }

    public Law() {
    }

    public Law(int LawID, String LawTitle, String LawDetail, Date LawTimeRelease, Categorys CategoryID) {
        this.LawID = LawID;
        this.LawTitle = LawTitle;
        this.LawDetail = LawDetail;
        this.LawTimeRelease = LawTimeRelease;
        this.CategoryID = CategoryID;
    }

}
