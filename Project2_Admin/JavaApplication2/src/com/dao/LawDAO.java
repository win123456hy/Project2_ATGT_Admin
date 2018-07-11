/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class LawDAO {
     public void addlaw(String title,String detail,Date timerelease,int cateid){
     String sql = "insert into laws(LawTitle,LawDetail,LawTimeRelease,CategoryID) values(?,?,?,?)";
        Connection con = DBUtils.open();
        
        PreparedStatement stm=null;
        
        try {
            con.setAutoCommit(false);
            stm=con.prepareStatement(sql);
            stm.setString(1, title);
            stm.setString(2, detail);
            java.sql.Date timee = new java.sql.Date(timerelease.getTime());
            stm.setDate(3, timee);
            stm.setInt(4, cateid);
        
        stm.executeUpdate();
        
        con.commit();
        } catch (SQLException ex) {
         try {
             con.rollback();
             ex.printStackTrace();
         } catch (SQLException ex1) {
         }
        }finally{
             
            DBUtils.closeTwo(con, stm);
          
        }
    }
     
     public void deletelaw(int lawid){
     String sql = "delete from laws where lawid=?";
        Connection con = DBUtils.open();
        
        PreparedStatement stm=null;
        
        try {
            con.setAutoCommit(false);
            stm=con.prepareStatement(sql);
            stm.setInt(1, lawid);
            
        
        stm.executeUpdate();
        
        con.commit();
        } catch (SQLException ex) {
         try {
             con.rollback();
             ex.printStackTrace();
         } catch (SQLException ex1) {
         }
        }finally{
             
            DBUtils.closeTwo(con, stm);
          
        }
    }
     
      public void updatelaw(int lawid,String title,String detail,Date timerelease,int categoryidd){
     String sql = "update laws set lawtitle=?,lawdetail=?,lawtimerelease=?,categoryid=? where lawid=?";
        Connection con = DBUtils.open();
        
        PreparedStatement stm=null;
        
        try {
            con.setAutoCommit(false);
            stm=con.prepareStatement(sql);
            stm.setString(1, title);
            stm.setString(2, detail);
            java.sql.Date timee = new java.sql.Date(timerelease.getTime());
            stm.setDate(3, timee);
            stm.setInt(4, categoryidd);
             stm.setInt(5, lawid);
        
        stm.executeUpdate();
        
        con.commit();
        } catch (SQLException ex) {
         try {
             con.rollback();
             ex.printStackTrace();
         } catch (SQLException ex1) {
         }
        }finally{
             
            DBUtils.closeTwo(con, stm);
          
        }
    }
}
