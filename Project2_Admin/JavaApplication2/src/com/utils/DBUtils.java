/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duy.nn
 */
public class DBUtils {

    public static Connection open() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/project2?useUnicode=true&characterEncoding=utf-8", "root", "");
        } catch (SQLException ex) {
            return null;
        }
    }

    public static void closeAll(Connection con, PreparedStatement stm, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (stm != null) {
            try {
                stm.close();
            } catch (SQLException ex) {
              ex.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
              ex.printStackTrace();
            }
        }
    }
    public static void closeTwo(Connection con, PreparedStatement stm) {
        if (stm != null) {
            try {
                stm.close();
            } catch (SQLException ex) {
              ex.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
              ex.printStackTrace();
            }
        }
    }
}
