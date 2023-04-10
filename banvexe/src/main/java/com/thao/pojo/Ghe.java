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
public class Ghe {
    private String id;
    private String name;
    private boolean trangthai;
    private String ve_id;
    private String xekhach_id;
    
    {
        id = UUID.randomUUID().toString();
    }

    public Ghe() {
    }

    public Ghe(String name, boolean trangthai, String ve_id, String xekhach_id) {
        this.name = name;
        this.trangthai = trangthai;
        this.ve_id = ve_id;
        this.xekhach_id = xekhach_id;
    }
    
    public Ghe(String id, String name, boolean trangthai, String ve_id, String xekhach_id) {
        this.id = id;
        this.name = name;
        this.trangthai = trangthai;
        this.ve_id = ve_id;
        this.xekhach_id = xekhach_id;
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

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public String getVe_id() {
        return ve_id;
    }

    public void setVe_id(String ve_id) {
        this.ve_id = ve_id;
    }

    public String getXekhach_id() {
        return xekhach_id;
    }

    public void setXekhach_id(String xekhach_id) {
        this.xekhach_id = xekhach_id;
    }
    
    
}
