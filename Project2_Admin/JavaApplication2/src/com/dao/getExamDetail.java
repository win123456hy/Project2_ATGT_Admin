/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Answers;
import com.model.Categorys;
import com.model.ExamDetails;
import com.model.Exams;
import com.model.Law;
import com.model.Question;
import com.model.Users;
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
public class getExamDetail {

    public ArrayList<ExamDetails> getExamDetail(int examid) {
        String sql = "select * from ExamDetails where examid=?";
        Connection con = DBUtils.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<ExamDetails> examDetailses=new ArrayList<>();
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, examid);
            rs = stm.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("ExamDetailID");
                int quesid = rs.getInt("QuestionID");
                int answerid = rs.getInt("AnswerID");
                Question q=new Question(quesid, null, null);
                Answers a=new Answers(answerid, null, 0, null);
                Exams e=new Exams(examid, null, null, -1);
                examDetailses.add(new ExamDetails(id, e, q, a));
            }
            return examDetailses;
        } catch (SQLException ex) {
            return null;
        } finally {

            DBUtils.closeAll(con, stm, rs);

        }
    }
}
