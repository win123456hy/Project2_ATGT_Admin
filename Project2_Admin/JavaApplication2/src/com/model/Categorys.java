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
public class Categorys {
    private int CategoryID;
    private String CategoryName;
     private String CategoryDescription;

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    

    public Categorys() {
    }

    public Categorys(int CategoryID, String CategoryName, String CategoryDescription) {
        this.CategoryID = CategoryID;
        this.CategoryName = CategoryName;
        this.CategoryDescription = CategoryDescription;
    }

    public String getCategoryDescription() {
        return CategoryDescription;
    }

    public void setCategoryDescription(String CategoryDescription) {
        this.CategoryDescription = CategoryDescription;
    }

    @Override
    public String toString() {
        return this.CategoryName;
    }

    
}
