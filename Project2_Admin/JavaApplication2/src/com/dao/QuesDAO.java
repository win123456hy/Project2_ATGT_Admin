/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Categorys;
import com.model.Images;
import com.model.Question;
import com.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class QuesDAO {
     public void addques(String detail,int cateid){
     String sql = "insert into questions(questiondetail,CategoryID) values(?,?)";
        Connection con = DBUtils.open();
        
        PreparedStatement stm=null;
        
        try {
            con.setAutoCommit(false);
            stm=con.prepareStatement(sql);
            stm.setString(1, detail);
            stm.setInt(2, cateid);
        
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
     public int getquesidlastrow() {
        String sql = "SELECT QuestionID FROM questions ORDER BY QuestionID DESC LIMIT 1 ";
        Connection con = DBUtils.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("QuestionID");
                return id;
            }

        } catch (SQLException ex) {
            return -1;
        } finally {

            DBUtils.closeAll(con, stm, rs);

        }
        return -1;
    }
     public void addimageforques(int quesid,String imagelink){
     String sql = "insert into images(imagelink,questionid) values(?,?)";
        Connection con = DBUtils.open();
        
        PreparedStatement stm=null;
        
        try {
            con.setAutoCommit(false);
            stm=con.prepareStatement(sql);
            stm.setString(1, imagelink);
            stm.setInt(2, quesid);
        
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
     
     public void deleteques(int questionid){
     String sql = "delete from questions where questionid=?";
        Connection con = DBUtils.open();
        
        PreparedStatement stm=null;
        
        try {
            con.setAutoCommit(false);
            stm=con.prepareStatement(sql);
            stm.setInt(1, questionid);
            
        
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
     public void deleteimagesforques(int questionid){
     String sql = "delete from images where questionid=?";
        Connection con = DBUtils.open();
        
        PreparedStatement stm=null;
        
        try {
            con.setAutoCommit(false);
            stm=con.prepareStatement(sql);
            stm.setInt(1, questionid);
            
        
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
      public void updateques(int quesid,String detail,int categoryidd){
     String sql = "update questions set questiondetail=?,categoryid=? where questionid=?";
        Connection con = DBUtils.open();
        
        PreparedStatement stm=null;
        
        try {
            con.setAutoCommit(false);
            stm=con.prepareStatement(sql);
            stm.setString(1, detail);
            stm.setInt(2, categoryidd);
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
        public void updateimageforques(int quesid,String imglink){
     String sql = "update images set imagelink=? where questionid=?";
        Connection con = DBUtils.open();
        
        PreparedStatement stm=null;
        
        try {
            con.setAutoCommit(false);
            stm=con.prepareStatement(sql);
            stm.setString(1, imglink);
            stm.setInt(2, quesid);
          
        
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
        
        public ArrayList<Question> timkiem(String tukhoa,int categoryid) {
        String sql = "select * from questions where  CategoryID=? and QuestionDetail like "+"'%"+tukhoa+"%'";
        Connection con = DBUtils.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<Question> al = new ArrayList<>();
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, categoryid);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("QuestionID");
                String AnswerDetail = rs.getString("QuestionDetail");
                Categorys c=new Categorys(categoryid, null, null);
                al.add(new Question(id, AnswerDetail, c));
            }

            return al;
        } catch (SQLException ex) {
            return null;
        } finally {

            DBUtils.closeAll(con, stm, rs);

        }
    }
}
