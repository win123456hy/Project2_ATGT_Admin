/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Categorys;
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
public class TrafficDAO {

    public void addtraffic(String trafficLink, String title, String detail, int cateid) {
        String sql = "insert into trafficsigns(TrafficLink,TrafficTitle,TrafficDetail,CategoryID) values(?,?,?,?)";
        Connection con = DBUtils.open();

        PreparedStatement stm = null;

        try {
            con.setAutoCommit(false);
            stm = con.prepareStatement(sql);
            stm.setString(1, trafficLink);
            stm.setString(2, title);
            stm.setString(3, detail);
            stm.setInt(4, cateid);

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

    public void deletetraffic(int trafficid) {
        String sql = "delete from trafficsigns where TrafficSignID=?";
        Connection con = DBUtils.open();

        PreparedStatement stm = null;

        try {
            con.setAutoCommit(false);
            stm = con.prepareStatement(sql);
            stm.setInt(1, trafficid);

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

    public void updatetraffic(int trafficid, String link, String title, String detail, int categoryidd) {
        String sql = "update trafficsigns set TrafficLink=?,TrafficTitle=?,TrafficDetail=?,categoryid=? where TrafficSignID=?";
        Connection con = DBUtils.open();

        PreparedStatement stm = null;

        try {
            con.setAutoCommit(false);
            stm = con.prepareStatement(sql);
            stm.setString(1, link);
            stm.setString(2, title);

            stm.setString(3, detail);
            stm.setInt(4, categoryidd);
            stm.setInt(5, trafficid);

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

    public ArrayList<Trafficsigns> timkiem(String tukhoa) {
        String sql = "select * from trafficsigns where traffictitle like "+"'%"+tukhoa+"%'";
        Connection con = DBUtils.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<Trafficsigns> al = new ArrayList<>();
        try {
            stm = con.prepareStatement(sql);

            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("TrafficSignID");
                String trafficlink = rs.getString("TrafficLink");
                String traffictitle = rs.getString("TrafficTitle");
                String trafficdetail = rs.getString("TrafficDetail");
                int cateid=rs.getInt("CategoryID");
                Categorys c = new Categorys(cateid, null, null);
                al.add(new Trafficsigns(id, traffictitle, trafficdetail, trafficlink, c));
            }

            return al;
        } catch (SQLException ex) {
            return null;
        } finally {

            DBUtils.closeAll(con, stm, rs);

        }
    }
}
