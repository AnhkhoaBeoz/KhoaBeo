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
public class ChuyenXeThuocTuyenDuong {
    private String id;
    private String chuyenxe_id;
    private String tuyenduong_id;
    
    {
        id = UUID.randomUUID().toString();
    }

    public ChuyenXeThuocTuyenDuong() {
    }

    public ChuyenXeThuocTuyenDuong(String chuyenxe_id, String tuyenduong_id) {
        this.chuyenxe_id = chuyenxe_id;
        this.tuyenduong_id = tuyenduong_id;
    }
    
    public ChuyenXeThuocTuyenDuong(String id, String chuyenxe_id, String tuyenduong_id) {
        this.id = id;
        this.chuyenxe_id = chuyenxe_id;
        this.tuyenduong_id = tuyenduong_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChuyenxe_id() {
        return chuyenxe_id;
    }

    public void setChuyenxe_id(String chuyenxe_id) {
        this.chuyenxe_id = chuyenxe_id;
    }

    public String getTuyenduong_id() {
        return tuyenduong_id;
    }

    public void setTuyenduong_id(String tuyenduong_id) {
        this.tuyenduong_id = tuyenduong_id;
    }
    
    
}
