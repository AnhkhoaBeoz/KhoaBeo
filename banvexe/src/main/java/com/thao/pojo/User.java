/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.pojo;

import java.util.UUID;

/**
 *
 * @author Chung Vu
 */
public class User {
    private String id;
    private String ho;
    private String ten;
    private String sdt;
    private String username;
    private String password;
    private boolean admin;
    
    {
        id = UUID.randomUUID().toString();
    }
    
    public User(){
        
    }

    public User(String ho, String ten, String sdt, String username, String password, boolean admin) {
        this.ho = ho;
        this.ten = ten;
        this.sdt = sdt;
        this.username = username;
        this.password = password;
        this.admin = admin;
    }
    
    public User(String id, String ho, String ten, String sdt, String username, String password, boolean admin, double sotienconlai) {
        this.id = id;
        this.ho = ho;
        this.ten = ten;
        this.sdt = sdt;
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
