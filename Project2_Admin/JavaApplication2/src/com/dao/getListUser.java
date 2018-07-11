/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Categorys;
import com.model.Exams;
import com.model.Law;
import com.model.Users;
import com.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class getListUser {

    public ArrayList<Users> getUsers() {
        String sql = "select * from Users";
        Connection con = DBUtils.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<Users> al = new ArrayList<>();
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("UserID");
                String username = rs.getString("Username");
                Date time = rs.getDate("CreatedTime");

                String password = rs.getString("Password");
                int genders = rs.getInt("Gender");
                String emaill = rs.getString("Email");
                al.add(new Users(id, username, genders, emaill, password, time));
            }

            return al;
        } catch (SQLException ex) {
            return null;
        } finally {

            DBUtils.closeAll(con, stm, rs);

        }
    }

    public Users get1Users(int iduser) {
        String sql = "select * from Users where userid=?";
        Connection con = DBUtils.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        Users al = null;
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, iduser);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("UserID");
                String username = rs.getString("Username");
                Date time = rs.getDate("CreatedTime");

                String password = rs.getString("Password");
                int genders = rs.getInt("Gender");
                String emaill = rs.getString("Email");
                al = new Users(id, username, genders, emaill, password, time);
            }
            return al;
        } catch (SQLException ex) {
            return null;
        } finally {

            DBUtils.closeAll(con, stm, rs);

        }
    }

    public ArrayList<Users> getUserid(String username) {
        String sql = "select * from Users where username like " + "'%" + username + "%'";
        Connection con = DBUtils.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<Users> al = new ArrayList<>();
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("UserID");
                al.add(new Users(id, null, -1, null, null, null));

            }
            return al;
        } catch (SQLException ex) {
            return null;
        } finally {

            DBUtils.closeAll(con, stm, rs);

        }
    }
}
