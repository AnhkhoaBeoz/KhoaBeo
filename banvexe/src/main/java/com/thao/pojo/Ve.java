/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.pojo;

import java.time.LocalDateTime;
import java.util.UUID;


/**
 *
 * @author Chung Vu
 */
public class Ve {
    private String id;
    private String soghe;
    private Double giave;
    private LocalDateTime ngayin;
    private String khachhang;
    private String sdt;
    private String user_id;
    private String chuyenxe_id;
    
    {
        id = UUID.randomUUID().toString();
    }

    public Ve() {
    }

    public Ve(String soghe, Double giave, LocalDateTime ngayin, String khachhang, String sdt, String user_id, String chuyenxe_id) {
        this.soghe = soghe;
        this.giave = giave;
        this.ngayin = ngayin;
        this.khachhang = khachhang;
        this.sdt = sdt;
        this.user_id = user_id;
        this.chuyenxe_id = chuyenxe_id;
    }
    
    public Ve(String id, String soghe, Double giave, LocalDateTime ngayin , String khachhang, String sdt, String user_id, String chuyenxe_id) {
        this.id = id;
        this.soghe = soghe;
        this.giave = giave;
        this.ngayin = ngayin;
        this.khachhang = khachhang;
        this.sdt = sdt;
        this.user_id = user_id;
        this.chuyenxe_id = chuyenxe_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSoghe() {
        return soghe;
    }

    public void setSoghe(String soghe) {
        this.soghe = soghe;
    }

    public Double getGiave() {
        return giave;
    }

    public void setGiave(Double giave) {
        this.giave = giave;
    }

    public LocalDateTime getNgayin() {
        return ngayin;
    }

    public void setNgayin(LocalDateTime ngayin) {
        this.ngayin = ngayin;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getChuyenxe_id() {
        return chuyenxe_id;
    }

    public void setChuyenxe_id(String chuyenxe_id) {
        this.chuyenxe_id = chuyenxe_id;
    }

    /**
     * @return the khachhang
     */
    public String getKhachhang() {
        return khachhang;
    }

    /**
     * @param khachhang the khachhang to set
     */
    public void setKhachhang(String khachhang) {
        this.khachhang = khachhang;
    }

    /**
     * @return the sdt
     */
    public String getSdt() {
        return sdt;
    }

    /**
     * @param sdt the sdt to set
     */
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
    
}
