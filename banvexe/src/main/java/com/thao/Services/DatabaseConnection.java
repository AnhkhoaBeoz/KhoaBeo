/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Chung Vu
 */
public class DatabaseConnection {
     static {
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
                     }
         catch (ClassNotFoundException ex) {
             ex.printStackTrace();
         }
    }
    public static Connection getDBConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost/banvexe", "root", "Admin@123");
    }
    
    public static boolean createdDB(Connection conn){
        
         try {
             String sql = "CREATE TABLE user(id nvarchar(100) not null, ho nvarchar(50) not null, ten nvarchar(25) not null, sdt nvarchar(10) not null, username nvarchar(50) not null, password nvarchar(12) not null, admin bit not null, primary key(id))";
             
             Statement stat = conn.createStatement();
             stat.executeUpdate(sql);
             
             sql = "CREATE TABLE benxe(id nvarchar(100) not null, name nvarchar(50) not null, address nvarchar(50) not null, primary key(id))";
             
             stat = conn.createStatement();
             stat.executeUpdate(sql);
             
             sql = "CREATE TABLE tuyenduong(id nvarchar(100) not null, diemdi nvarchar(50) not null, diemden nvarchar(50) not null, primary key(id))";
             
             stat = conn.createStatement();
             stat.executeUpdate(sql);
             
             sql = "CREATE TABLE xekhach(id nvarchar(100) not null, sochongoi INT not null, bienso nvarchar(50) not null, primary key(id))";
             
             stat = conn.createStatement();
             stat.executeUpdate(sql);
             
             sql = "CREATE TABLE chuyenxe(id nvarchar(100) not null, name nvarchar(50) not null, ngaykhoihanh DATETIME not null, giave DECIMAL not null, xekhach_id nvarchar(100) not null, benxedi_id nvarchar(100) not null, benxeden_id nvarchar(100) not null, primary key(id), foreign key(xekhach_id) references xekhach(id), foreign key(benxedi_id) references benxe(id), foreign key(benxeden_id) references benxe(id))";
             
             stat = conn.createStatement();
             stat.executeUpdate(sql);
             
             sql = "CREATE TABLE chuyenxethuoctuyenduong(id nvarchar(100) not null, chuyenxe_id nvarchar(100) not null, tuyenduong_id nvarchar(100) not null, primary key(id), foreign key(chuyenxe_id) references chuyenxe(id), foreign key(tuyenduong_id) references tuyenduong(id))";
             
             stat = conn.createStatement();
             stat.executeUpdate(sql);
             
             sql = "CREATE TABLE ve(id nvarchar(100) not null, soghe nvarchar(25) not null, giave DECIMAL not null, ngayin DATETIME not null, khachhang nvarchar(100), sdt nvarchar(10) , user_id nvarchar(100) not null, chuyenxe_id nvarchar(100) not null, primary key(id), foreign key(user_id) references user(id), foreign key(chuyenxe_id) references chuyenxe(id))";
             
             stat = conn.createStatement();
             stat.executeUpdate(sql);
             
             sql = "CREATE TABLE ghe(id nvarchar(100) not null, name nvarchar(50) not null, trangthai BIT not null, ve_id nvarchar(100), xekhach_id nvarchar(100) not null, primary key(id), foreign key(xekhach_id) references xekhach(id), foreign key(ve_id) references ve(id))";
             
             stat = conn.createStatement();
             stat.executeUpdate(sql);
         } catch (SQLException ex) {
             Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }
         return true;
    }
    
//    public static void main(String[] args) throws SQLException {
//        createdDB(getDBConnection());
//    }
}
