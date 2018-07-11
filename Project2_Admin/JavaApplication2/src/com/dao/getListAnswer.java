/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Answers;
import com.model.Categorys;
import com.model.Law;
import com.model.Question;
import com.utils.DBUtils;
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
public class getListAnswer {

    public ArrayList<Answers> getListAnswer(int quesid) {
        String sql = "select * from answers where questionid=?";
        Connection con = DBUtils.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<Answers> al = new ArrayList<>();
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, quesid);
            rs = stm.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("AnswerID");
                String answerdetail = rs.getString("AnswerDetail");
                int iscorrect = rs.getInt("IsCorrect");
                Question q=new Question(quesid, null, null);
                al.add(new Answers(id, answerdetail,iscorrect ,q));
            }

            return al;
        } catch (SQLException ex) {
            return null;
        } finally {

            DBUtils.closeAll(con, stm, rs);

        }
    }
      public Answers getAnswer(int answerid) {
        String sql = "select * from answers where answerid=?";
        Connection con = DBUtils.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
       Answers al = null;
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, answerid);
            rs = stm.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("AnswerID");
                String answerdetail = rs.getString("AnswerDetail");
                int iscorrect = rs.getInt("IsCorrect");
                 int quesid = rs.getInt("QuestionID");
                Question q=new Question(quesid, null, null);
                al= new Answers(id, answerdetail,iscorrect ,q);
            }
            return al;
        } catch (SQLException ex) {
            return null;
        } finally {

            DBUtils.closeAll(con, stm, rs);

        }
    }
}
