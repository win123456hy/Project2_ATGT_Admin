/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Categorys;
import com.model.Images;
import com.model.Law;
import com.model.Question;
import com.utils.DBUtils;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class getListQues {

    public ArrayList<Question> getLques(int categoryid) {
        String sql = "select * from questions where categoryid=?";
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
                String quesdetail = rs.getString("QuestionDetail");

                Categorys c = new Categorys(categoryid, null, null);
                al.add(new Question(id, quesdetail, c));
            }

            return al;
        } catch (SQLException ex) {
            return null;
        } finally {

            DBUtils.closeAll(con, stm, rs);

        }
    }

    public Question get1ques(int quesid) {
        String sql = "select * from questions where questionid=?";
        Connection con = DBUtils.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        Question al = null;
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, quesid);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("QuestionID");
                String quesdetail = rs.getString("QuestionDetail");
                int categoryid = rs.getInt("CategoryID");
                Categorys c = new Categorys(categoryid, null, null);
                al = new Question(id, quesdetail, c);

            }

            return al;
        } catch (SQLException ex) {
            return null;
        } finally {

            DBUtils.closeAll(con, stm, rs);

        }
    }

    public Images getImageforQues(int quesid) {
        String sql = "select * from images where questionid=?";
        Connection con = DBUtils.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        Images al = null;
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, quesid);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ImageID");
                String imagelink = rs.getString("ImageLink");

                Question q = new Question(quesid, null, null);
                if (imagelink == null) {
                    al = new Images(id, "a", q);
                } else {
                    al = new Images(id, imagelink, q);
                }

            }

            return al;
        } catch (SQLException ex) {
            return null;
        } finally {

            DBUtils.closeAll(con, stm, rs);

        }
    }

    public ArrayList<Question> getAllques() {
        String sql = "select * from questions";
        Connection con = DBUtils.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<Question> al = new ArrayList<>();
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("QuestionID");
                String quesdetail = rs.getString("QuestionDetail");
                int cateid = rs.getInt("CategoryID");
                Categorys c = new Categorys(cateid, null, null);
                al.add(new Question(id, quesdetail, c));
            }

            return al;
        } catch (SQLException ex) {
            return null;
        } finally {

            DBUtils.closeAll(con, stm, rs);

        }
    }

}
