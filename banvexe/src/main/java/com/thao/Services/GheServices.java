/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.Services;

import com.thao.pojo.Ghe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chung Vu
 */
public class GheServices {
    public int themGhe(Ghe ghe){
        try(Connection conn = DatabaseConnection.getDBConnection()){
            conn.setAutoCommit(false);
            String sql = "insert into ghe values(?, ?, ?, ?, ?)";
            PreparedStatement stat = conn.prepareCall(sql);
            
            stat.setString(1, ghe.getId());
            stat.setString(2, ghe.getName());
            stat.setBoolean(3, ghe.isTrangthai());
            stat.setString(4, ghe.getVe_id());
            stat.setString(5, ghe.getXekhach_id());
            int result = stat.executeUpdate();
            conn.commit();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(GheServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
