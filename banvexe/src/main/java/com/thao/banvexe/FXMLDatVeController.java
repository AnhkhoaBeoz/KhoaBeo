/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.banvexe;
import com.thao.Services.ChuyenXeServices;
import com.thao.pojo.ChuyenXe;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import com.thao.Utils.MessageBox;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.fxml.FXMLLoader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.thao.Services.GheServices;
import com.thao.Services.VeServices;
import com.thao.pojo.Ghe;
import com.thao.pojo.Ve;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

/**
 *
 * @author Chung Vu
 */
public class FXMLDatVeController implements Initializable{
    public static List<Ve> listVeDaDat = new ArrayList<>();
    public static ChuyenXe cx = new ChuyenXe();
    @FXML private TextField txtFind;
    @FXML private TableView<ChuyenXe> tbChuyenXe;
    @FXML private TableView<Ve> tbVe;
    @FXML private TextField txtFindKH;
    @FXML private Tab tab1;
    @FXML private Tab tab2;
    @FXML private TabPane tp;
    /**
     *
     * @param url
     * @param rb
     * @throws SQLException
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        this.tp.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Tab> ov, Tab t, Tab t1) -> {
            if(tp.getSelectionModel().getSelectedIndex() == 0){
                try {
                    this.loadTableColumns();
                    this.loadTableData(null);
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDatVeController.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.txtFind.textProperty().addListener(d->{
                    try {
                        this.loadTableData(this.txtFind.getText());
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLDatVeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });

            }
            else if(tp.getSelectionModel().getSelectedIndex() == 1){
                this.loadTableColumnVeDaDat();
                    
                this.loadTableDataVeDaDat(null);
                
                this.txtFindKH.textProperty().addListener(d->{
                    this.loadTableDataVeDaDat(this.txtFindKH.getText());
                });
            }
        });
        if(tp.getSelectionModel().getSelectedIndex() == 0){
                try {
                    this.loadTableColumns();
                    this.loadTableData(null);
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDatVeController.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.txtFind.textProperty().addListener(d->{
                    try {
                        this.loadTableData(this.txtFind.getText());
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLDatVeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
        }
    }
    
    
    
    private void loadTableColumns(){
        this.tbChuyenXe.getColumns().clear();
        TableColumn colName = new TableColumn("Tên chuyến đi");
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        
        TableColumn colNgayKhoiHanh = new TableColumn("Ngày Khởi Hành");
        colNgayKhoiHanh.setCellValueFactory(new PropertyValueFactory("ngaykhoihanh"));
        
        TableColumn colGiaVe = new TableColumn("Giá Vé");
        colGiaVe.setCellValueFactory(new PropertyValueFactory("giave"));
        
        TableColumn colXeKhach = new TableColumn("Xe Khách");
        colXeKhach.setCellValueFactory(new PropertyValueFactory("xekhach_id"));
        
        TableColumn colBenXeDi = new TableColumn("Bến Xe Đi");
        colBenXeDi.setCellValueFactory(new PropertyValueFactory("benxedi_id"));
        
        TableColumn colBenXeDen = new TableColumn("Bến Xe Đến");
        colBenXeDen.setCellValueFactory(new PropertyValueFactory("benxeden_id"));
        
        TableColumn colDatVe = new TableColumn();
        colDatVe.setCellFactory(evt ->{
            Button btn = new Button("Đặt Vé");
            
            btn.setOnAction(e -> {
                        Button b = (Button)e.getSource();
                        TableCell cell = (TableCell)b.getParent();
                        cx = (ChuyenXe) cell.getTableRow().getItem();
//                        ObjectMapper objectMapper = new ObjectMapper();
//                        objectMapper.registerModule(new JavaTimeModule());
//                        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//                        try {
//                            objectMapper.writeValue(new File("src/main/resources/json/dadat.json"), cx);
//                        } catch (IOException ex) {
//                            Logger.getLogger(FXMLDatVeController.class.getName()).log(Level.SEVERE, null, ex);
//                        }
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLThongTinUserDatVe.fxml"));
                        Parent root1;
                        try {
                            root1 = (Parent) fxmlLoader.load();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1));
                            stage.show(); 
                        } catch (IOException ex) {
                            Logger.getLogger(FXMLDatVeController.class.getName()).log(Level.SEVERE, null, ex);
                        }
            });
            TableCell cell = new TableCell();
            cell.setGraphic(btn);
            return cell;
        });
       
        this.tbChuyenXe.getColumns().addAll(colName, colNgayKhoiHanh, colGiaVe, colXeKhach, colBenXeDi, colBenXeDen, colDatVe);
    }
    
    private void loadTableData(String kw) throws SQLException {
        ChuyenXeServices cxs = new ChuyenXeServices();
        List<ChuyenXe> listCX = cxs.getChuyenXe(kw);
        this.tbChuyenXe.getItems().clear();
        this.tbChuyenXe.setItems(FXCollections.observableList(listCX));
    }
    
    private void loadTableColumnVeDaDat(){
        this.tbVe.getColumns().clear();
        TableColumn colSoGhe = new TableColumn("Số Ghế");
        colSoGhe.setCellValueFactory(new PropertyValueFactory("soghe"));
        
        TableColumn colGiaVe = new TableColumn("Giá Vé");
        colGiaVe.setCellValueFactory(new PropertyValueFactory("giave"));
        
        TableColumn colNgayIn = new TableColumn("Ngày in");
        colNgayIn.setCellValueFactory(new PropertyValueFactory("ngayin"));
        
        TableColumn colKH = new TableColumn("Khách hàng");
        colKH.setCellValueFactory(new PropertyValueFactory("khachhang"));
        
        TableColumn colSDT = new TableColumn("Số Điện Thoại");
        colSDT.setCellValueFactory(new PropertyValueFactory("sdt"));
        
        TableColumn colUser = new TableColumn("Nhân viên");
        colUser.setCellValueFactory(new PropertyValueFactory("user_id"));
        
        TableColumn colCX = new TableColumn("Chuyến xe");
        colCX.setCellValueFactory(new PropertyValueFactory("chuyenxe_id"));
        
        TableColumn colConfirm = new TableColumn();
        colConfirm.setCellFactory(evt -> {
            Button btn = new Button("Confirm");
            btn.setOnAction(e -> {
                Button b = (Button)e.getSource();
                TableCell cell = (TableCell)b.getParent();
                Ve ve = (Ve) cell.getTableRow().getItem();
                VeServices ves = new VeServices();
                ves.themVe(ve);
                GheServices ghes = new GheServices();
                ghes.themGhe(new Ghe(ve.getSoghe(), true, ve.getId(), cx.getXekhach_id()));
                listVeDaDat.remove(ve);
                loadTableDataVeDaDat(null);
            });
            TableCell cell = new TableCell();
            cell.setGraphic(btn);
            return cell;
        });
        
        TableColumn colHuyVe = new TableColumn();
        colHuyVe.setCellFactory(evt -> {
            Button btn = new Button("Hủy vé");
            btn.setOnAction(e -> {
                Button b = (Button)e.getSource();
                TableCell cell = (TableCell)b.getParent();
                Ve ve = (Ve) cell.getTableRow().getItem();
                listVeDaDat.remove(ve);
                loadTableDataVeDaDat(null);
            });
            TableCell cell = new TableCell();
            cell.setGraphic(btn);
            return cell;
        });
        
        this.tbVe.getColumns().addAll(colSoGhe,colGiaVe, colNgayIn, colKH, colSDT, colUser, colCX, colConfirm, colHuyVe);
    }
    
    private void loadTableDataVeDaDat(String kw) {
//        VeServices ves = new VeServices();
//        List<Ve> listVe = ves.listVe(kw);
        this.tbVe.getItems().clear();
        List<Ve> test = new ArrayList<>();
        if(kw == null || kw.isEmpty())
            test = new ArrayList<>(listVeDaDat);
        else{
            test = listVeDaDat.stream().filter(item -> item.getKhachhang().toLowerCase().contains(kw.toLowerCase())).collect(Collectors.toList());
        }
       
        this.tbVe.setItems(FXCollections.observableList(test));
    }
}
