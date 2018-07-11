/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Categorys;
import com.model.Exams;
import com.model.Law;
import com.model.Trafficsigns;
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
public class getListExam {

    public ArrayList<Exams> getExam() {
        String sql = "select * from Exams";
        Connection con = DBUtils.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<Exams> al = new ArrayList<>();
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ExamID");
                Date time = rs.getDate("CreatedTime");
                int idusser = rs.getInt("UserID");
                int score = rs.getInt("Score");
                Users users = new Users(idusser, null, -1, null, null, null);
                al.add(new Exams(id, time, users, score));
            }

            return al;
        } catch (SQLException ex) {
            return null;
        } finally {

            DBUtils.closeAll(con, stm, rs);

        }
    }

    public ArrayList<Exams> timkiem(String tukhoa) {
        ArrayList<Users> u = new ArrayList<>();
        getListUser listUser = new getListUser();
        u = listUser.getUserid(tukhoa);
        ArrayList<Exams> al = new ArrayList<>();
        for (int i = 0; i < u.size(); i++) {
            String sql = "select * from exams where userid=?";
            Connection con = DBUtils.open();
            PreparedStatement stm = null;
            ResultSet rs = null;
            
            try {

                stm = con.prepareStatement(sql);
                stm.setInt(1, u.get(i).getUserID());
                rs = stm.executeQuery();
                while (rs.next()) {
                    int idexam = rs.getInt("ExamID");
                    Date create = rs.getDate("Createdtime");
                    int score = rs.getInt("Score");
                    Users uus = new Users(u.get(i).getUserID(), null, -1, null, null, null);
                    al.add(new Exams(idexam, create, uus, score));
                }

            } catch (SQLException ex) {
                return null;
            } finally {

                DBUtils.closeAll(con, stm, rs);

            }
        }
        return al;
    }
}
