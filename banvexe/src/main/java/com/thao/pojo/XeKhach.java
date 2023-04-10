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
public class XeKhach {
    private String id;
    private int sochongoi;
    private String bienso;
    
    {
        id = UUID.randomUUID().toString();
    }

    public XeKhach() {
    }

    public XeKhach(int sochongoi, String bienso) {
        this.sochongoi = sochongoi;
        this.bienso = bienso;
    }
    
    public XeKhach(String id, int sochongoi, String bienso) {
        this.id = id;
        this.sochongoi = sochongoi;
        this.bienso = bienso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSochongoi() {
        return sochongoi;
    }

    public void setSochongoi(int sochongoi) {
        this.sochongoi = sochongoi;
    }

    public String getBienso() {
        return bienso;
    }

    public void setBienso(String bienso) {
        this.bienso = bienso;
    }
    
}
