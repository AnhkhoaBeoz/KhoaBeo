/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.Services;

import com.thao.pojo.XeKhach;
import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chung Vu
 */
public class XeKhachServices {
    public List<XeKhach> getXeKhachs() throws SQLException{
        List<XeKhach> listXK = new ArrayList<>();
        try(Connection conn = DatabaseConnection.getDBConnection()){
            Statement stat = conn.createStatement();
            
            ResultSet rs = stat.executeQuery("select * from xekhach");
            while(rs.next()){
                listXK.add(new XeKhach(rs.getString("id"), rs.getInt("sochongoi"), rs.getString("bienso")));
            }
        }
        
        
        return listXK;
    }
}
