/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Categorys;
import com.model.Law;
import com.model.Trafficsigns;
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
      public ArrayList<Law> timkiem(String tukhoa) {
        String sql = "select * from Laws where LawTitle like "+"'%"+tukhoa+"%'"+"or LawDetail like "+"'%"+tukhoa+"%'";
        Connection con = DBUtils.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<Law> al = new ArrayList<>();
        try {
            stm = con.prepareStatement(sql);

            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("LawID");
                String LawTitle = rs.getString("LawTitle");
                String LawDetail = rs.getString("LawDetail");
                Date LawTimeRelease = rs.getDate("LawTimeRelease");
                int cateid=rs.getInt("CategoryID");
                Categorys c = new Categorys(cateid, null, null);
                al.add(new Law(id, LawTitle, LawDetail, LawTimeRelease, c));
            }

            return al;
        } catch (SQLException ex) {
            return null;
        } finally {

            DBUtils.closeAll(con, stm, rs);

        }
    }
}
