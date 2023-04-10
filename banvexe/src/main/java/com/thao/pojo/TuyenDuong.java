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
public class TuyenDuong {
    private String id;
    private String diemdi;
    private String diemden;
    
    {
        id = UUID.randomUUID().toString();
    }

    public TuyenDuong() {
    }

    public TuyenDuong(String diemdi, String diemden) {
        this.diemdi = diemdi;
        this.diemden = diemden;
    }

    
    public TuyenDuong(String id, String diemdi, String diemden) {
        this.id = id;
        this.diemdi = diemdi;
        this.diemden = diemden;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiemdi() {
        return diemdi;
    }

    public void setDiemdi(String diemdi) {
        this.diemdi = diemdi;
    }

    public String getDiemden() {
        return diemden;
    }

    public void setDiemden(String diemden) {
        this.diemden = diemden;
    }
    
}
