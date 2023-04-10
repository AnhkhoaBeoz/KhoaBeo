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
public class ChuyenXe {
    private String id;
    private String name;
    private LocalDateTime ngaykhoihanh;
    private Double giave;
    private String xekhach_id;
    private String benxedi_id;
    private String benxeden_id;
    
    {
        id = UUID.randomUUID().toString();
    }

    public ChuyenXe() {
    }
    
    

    public ChuyenXe(String name, LocalDateTime ngaykhoihanh, Double giave, String xekhach_id, String benxedi_id, String benxeden_id) {
        this.name = name;
        this.ngaykhoihanh = ngaykhoihanh;
        this.giave = giave;
        this.xekhach_id = xekhach_id;
        this.benxedi_id = benxedi_id;
        this.benxeden_id = benxeden_id;
    }
    
    public ChuyenXe(String id, String name, LocalDateTime ngaykhoihanh, Double giave, String xekhach_id, String benxedi_id, String benxeden_id) {
        this.id = id;
        this.name = name;
        this.ngaykhoihanh = ngaykhoihanh;
        this.giave = giave;
        this.xekhach_id = xekhach_id;
        this.benxedi_id = benxedi_id;
        this.benxeden_id = benxeden_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getNgaykhoihanh() {
        return ngaykhoihanh;
    }

    public void setNgaykhoihanh(LocalDateTime ngaykhoihanh) {
        this.ngaykhoihanh = ngaykhoihanh;
    }

    public Double getGiave() {
        return giave;
    }

    public void setGiave(Double giave) {
        this.giave = giave;
    }

    public String getXekhach_id() {
        return xekhach_id;
    }

    public void setXekhach_id(String xekhach_id) {
        this.xekhach_id = xekhach_id;
    }

    public String getBenxedi_id() {
        return benxedi_id;
    }

    public void setBenxedi_id(String benxedi_id) {
        this.benxedi_id = benxedi_id;
    }

    public String getBenxeden_id() {
        return benxeden_id;
    }

    public void setBenxeden_id(String benxeden_id) {
        this.benxeden_id = benxeden_id;
    }
}
