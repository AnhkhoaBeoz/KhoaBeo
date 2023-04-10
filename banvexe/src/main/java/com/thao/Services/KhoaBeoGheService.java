///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.thao.Services;
//
//import com.thao.pojo.Ve;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author anhkh
// */
//public class KhoaBeoGheService {
//     public List<Ghe> getListGhe() throws SQLException {
//        try (Connection conn = DatabaseConnection.getDBConnection()) {
//            List<Ghe> tks = new ArrayList();
//
//            Statement stat = conn.createStatement();
//            ResultSet rs = stat.executeQuery("select * from Ghe");
//
//            while (rs.next()) {
//                
//            }
//            return tks;
//        }
//}
