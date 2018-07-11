/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author Duc Va
 */
public class Trafficsigns {
    private int TrafficsignsID;
    private String TrafficTitle ;
    
    private String TrafficDetails;
    
    private String TrafficLink;
    
    private Categorys CategoryID;

    public int getTrafficsignsID() {
        return TrafficsignsID;
    }

    public void setTrafficsignsID(int TrafficsignsID) {
        this.TrafficsignsID = TrafficsignsID;
    }

    

    

    public Trafficsigns() {
      
    }

    public String getTrafficTitle() {
        return TrafficTitle;
    }

    public void setTrafficTitle(String TrafficTitle) {
        this.TrafficTitle = TrafficTitle;
    }

    public String getTrafficDetails() {
        return TrafficDetails;
    }

    public void setTrafficDetails(String TrafficDetails) {
        this.TrafficDetails = TrafficDetails;
    }

    public String getTrafficLink() {
        return TrafficLink;
    }

    public void setTrafficLink(String TrafficLink) {
        this.TrafficLink = TrafficLink;
    }

    public Categorys getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(Categorys CategoryID) {
        this.CategoryID = CategoryID;
    }

    public Trafficsigns(int TrafficsignsID, String TrafficTitle, String TrafficDetails, String TrafficLink, Categorys CategoryID) {
        this.TrafficsignsID = TrafficsignsID;
        this.TrafficTitle = TrafficTitle;
        this.TrafficDetails = TrafficDetails;
        this.TrafficLink = TrafficLink;
        this.CategoryID = CategoryID;
    }

 


    
    
}
