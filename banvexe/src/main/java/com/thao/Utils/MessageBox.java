/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.Utils;

import javafx.scene.control.Alert;

/**
 *
 * @author Chung Vu
 */
public class MessageBox {
    public static Alert getBox(String tile, String content, Alert.AlertType type){
        Alert a = new Alert(type);
        a.setTitle(tile);
        a.setContentText(content);
        return a;
    }
}
