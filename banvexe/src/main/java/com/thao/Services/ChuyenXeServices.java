 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.Services;

import com.thao.pojo.ChuyenXe;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chung Vu
 */
public class ChuyenXeServices {
    public List<ChuyenXe> getChuyenXe() throws SQLException{
        List<ChuyenXe> listCX = new ArrayList<>();
        try(Connection conn = DatabaseConnection.getDBConnection()){
            Statement stat = conn.createStatement();
            
            ResultSet rs = stat.executeQuery("select * from chuyenxe");
//            ByteBuffer buffer;
//
//            String utf8EncodedString;
            while(rs.next()){
//                buffer = StandardCharsets.UTF_8.encode(rs.getString("name")); 
//                utf8EncodedString = StandardCharsets.UTF_8.decode(buffer).toString();
                listCX.add(new ChuyenXe(rs.getString("id"), rs.getString("name"), rs.getTimestamp("ngaykhoihanh").toLocalDateTime(), rs.getDouble("giave"), rs.getString("xekhach_id"), rs.getString("benxedi_id"), rs.getString("benxeden_id")));
            }
        }
        return listCX;
    }
    
    public List<ChuyenXe> getChuyenXe(String kw) throws SQLException {
        List<ChuyenXe> listCX = new ArrayList<>();
        try(Connection conn = DatabaseConnection.getDBConnection()){
            String sql = "select * from chuyenxe";
            if(kw != null && !kw.isEmpty())
                sql += " WHERE name like concat('%', ?, '%')";
            
            PreparedStatement stm = conn.prepareCall(sql);
            if (kw != null && !kw.isEmpty())
                stm.setString(1, kw);
            
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                listCX.add(new ChuyenXe(rs.getString("id"), rs.getString("name"), rs.getTimestamp("ngaykhoihanh").toLocalDateTime(), rs.getDouble("giave"), rs.getString("xekhach_id"), rs.getString("benxedi_id"), rs.getString("benxeden_id")));
            }
        }
        
        return listCX;
    }
   
//    public static void main(String[] args) throws SQLException{
//        ChuyenXeServices cxs = new ChuyenXeServices();
//        List<ChuyenXe> listcx = cxs.getChuyenXe();
//        for(ChuyenXe cx: listcx){
//            System.out.println(cx.getName());
//        }
//    }
}
