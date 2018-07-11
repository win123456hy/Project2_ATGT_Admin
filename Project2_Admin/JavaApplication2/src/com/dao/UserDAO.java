/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Date;


/**
 *
 * @author Admin
 */
public class UserDAO {
     public boolean checktrung(String username){
     String sql = "select * from users where username=?";
        Connection con = DBUtils.open();
        PreparedStatement stm=null;
        ResultSet rs=null;
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            rs = stm.executeQuery();
            if(rs.next()){
            return true;
                }
             return false;
        } catch (SQLException ex) {
            return false;
        }finally{
             
            DBUtils.closeAll(con, stm, rs);
          
        }
    }
    public boolean regis(String userName, String pass,int gender,String email) {
        if(checktrung(userName)==true)
            return false;
        else{
        String sql = "INSERT INTO users(UserName,Gender,Email,Password,CreatedTime) VALUES (?,?,?,?,?)";
        Connection con = DBUtils.open();
        PreparedStatement stm=null;
        try {
            con.setAutoCommit(false);
            String encodedString = Base64.getEncoder().encodeToString(pass.getBytes());
            Date date = new Date();
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
            stm = con.prepareStatement(sql);
            stm.setString(1, userName);
            stm.setInt(2, gender);
            stm.setString(3, email);
            stm.setString(4, encodedString);
            stm.setDate(5, sqlStartDate);
            
           stm.executeUpdate();
           con.commit();
          if(stm.executeUpdate()>0)
              return true;
          
            
            
            
        } catch (Exception ex) {
            try {
                con.rollback();
                return false;
            } catch (SQLException ex1) {
            }
        }finally{
            DBUtils.closeTwo(con, stm);
        }
                    }
          return false; 
    }
    
    
    public void deleteusers(int userid) {
        String sql = "delete from users where UserID=?";
        Connection con = DBUtils.open();

        PreparedStatement stm = null;

        try {
            con.setAutoCommit(false);
            stm = con.prepareStatement(sql);
            stm.setInt(1, userid);

            stm.executeUpdate();

            con.commit();
        } catch (SQLException ex) {
            try {
                con.rollback();
                ex.printStackTrace();
            } catch (SQLException ex1) {
            }
        } finally {

            DBUtils.closeTwo(con, stm);

        }
    }
    public void updatetraffic(String userName, String pass,int gender,String email,int userid) {
        String sql = "update users set UserName=?,Password=?,Gender=?,Email=?,CreatedTime=? where UserID=?";
        Connection con = DBUtils.open();

        PreparedStatement stm = null;

        try {
            con.setAutoCommit(false);
             String encodedString = Base64.getEncoder().encodeToString(pass.getBytes());
            Date date = new Date();
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
            stm = con.prepareStatement(sql);
             stm.setString(1, userName);
            stm.setString(2, encodedString);
            stm.setInt(3, gender);
            stm.setString(4, email);
            stm.setDate(5, sqlStartDate);
            stm.setInt(6, userid);
            stm.executeUpdate();

            con.commit();
        } catch (SQLException ex) {
            try {
                con.rollback();
                ex.printStackTrace();
            } catch (SQLException ex1) {
            }
        } finally {

            DBUtils.closeTwo(con, stm);

        }
    }
}
