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
public class AnswerDAO {
     public void addanswer(String detail,int iscorrect,int quesid){
     String sql = "insert into answers(AnswerDetail,IsCorrect,QuestionID) values(?,?,?)";
        Connection con = DBUtils.open();
        
        PreparedStatement stm=null;
        
        try {
            con.setAutoCommit(false);
            stm=con.prepareStatement(sql);
            stm.setString(1, detail);
            stm.setInt(2, iscorrect);
            stm.setInt(3, quesid);
        
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
     
     public void deleteAnswers(int answerid){
     String sql = "delete from answers where answerid=?";
        Connection con = DBUtils.open();
        
        PreparedStatement stm=null;
        
        try {
            con.setAutoCommit(false);
            stm=con.prepareStatement(sql);
            stm.setInt(1, answerid);
            
        
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
     
      public void updateanswer(int answerid,String detail,int iscorrect,int quesid){
     String sql = "update answers set answerdetail=?,iscorrect=?,questionid=? where answerid=?";
        Connection con = DBUtils.open();
        
        PreparedStatement stm=null;
        
        try {
            con.setAutoCommit(false);
            stm=con.prepareStatement(sql);
            stm.setString(1, detail);
            stm.setInt(2, iscorrect);
            stm.setInt(3, quesid);
            stm.setInt(4, answerid);
        
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
