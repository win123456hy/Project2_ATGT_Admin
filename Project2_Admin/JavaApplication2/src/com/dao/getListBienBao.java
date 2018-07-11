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

/**
 *
 * @author Admin
 */
public class getListBienBao {

    public ArrayList<Trafficsigns> getltraffic(int categoryid) {
        String sql = "select * from trafficsigns where categoryid=?";
        Connection con = DBUtils.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<Trafficsigns> al = new ArrayList<>();
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, categoryid);
            rs = stm.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("TrafficSignID");
                String trafficlink = rs.getString("TrafficLink");
                String traffictitle = rs.getString("TrafficTitle");
                String trafficdetail = rs.getString("TrafficDetail");
                Categorys c=new Categorys(categoryid, null, null);
                al.add(new Trafficsigns(id, traffictitle, trafficdetail, trafficlink,c));
            }

            return al;
        } catch (SQLException ex) {
            return null;
        } finally {

            DBUtils.closeAll(con, stm, rs);

        }
    }
}
