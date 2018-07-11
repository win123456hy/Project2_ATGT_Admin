/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Answers;
import com.model.Categorys;
import com.model.Question;
import com.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class getCategoryfromCateName {

    public Categorys getCategoryName(int categoryid) {
        String sql = "select * from categories where CategoryID=?";
        Connection con = DBUtils.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        Categorys c=null;
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, categoryid);
            rs = stm.executeQuery();
            while (rs.next()) {
                String catename = rs.getString("CategoryName");
                String catedes=rs.getString("CategoryDescription");
                c=new Categorys(categoryid, catename, catedes);
            }
            return c;
        } catch (SQLException ex) {
            return null;
        } finally {

            DBUtils.closeAll(con, stm, rs);

        }
    }

  

}
