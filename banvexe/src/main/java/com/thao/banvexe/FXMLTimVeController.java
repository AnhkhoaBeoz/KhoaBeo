/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.banvexe;

import com.thao.Services.KhoaBeoVeXeService;
import com.thao.Utils.MessageBox;
import com.thao.pojo.Ve;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

/**
 *
 * @author anhkh
 */
public class FXMLTimVeController implements Initializable {

    @FXML
    private TextField kwSearch;
    @FXML
    private TableView<Ve> tableVeXe;

    private void LoadTableColunm() {

        TableColumn colMa = new TableColumn("Mã");
        colMa.setCellValueFactory(new PropertyValueFactory("id"));

        TableColumn colCho = new TableColumn("Số Ghế");
        colCho.setCellValueFactory(new PropertyValueFactory("soghe"));

        TableColumn colGiaVe = new TableColumn("Giá Vé");
        colGiaVe.setCellValueFactory(new PropertyValueFactory("giave"));

        TableColumn colNgay = new TableColumn("Ngày in");
        colNgay.setCellValueFactory(new PropertyValueFactory("ngayin"));

        TableColumn colKH = new TableColumn("Khach Hang");
        colKH.setCellValueFactory(new PropertyValueFactory("khachhang"));

        TableColumn colSDT = new TableColumn("SDT");
        colSDT.setCellValueFactory(new PropertyValueFactory("sdt"));

        TableColumn colUser = new TableColumn("User");
        colUser.setCellFactory(new PropertyValueFactory("user_id"));

        TableColumn colChuyenXe = new TableColumn("Chuyến Xe");
        colChuyenXe.setCellFactory(new PropertyValueFactory("chuyenxe_id"));
        TableColumn colBtn = new TableColumn();

        colBtn.setCellFactory(evt -> {

            Button btnHuyVe = new Button("Hủy Vé");
            btnHuyVe.setOnAction(e -> {

                // Xuử lí Huy Ve
                Alert xacNhanHuyVe = MessageBox.getBox("Hủy Vé", "Bạn Có Chắc muốn xóa vé này ", Alert.AlertType.CONFIRMATION);
                xacNhanHuyVe.showAndWait().ifPresent(respon -> {
                    if (respon == ButtonType.OK) {
                        Button b = (Button) e.getSource();
                        TableCell cellv = (TableCell) b.getParent();
                        Ve v = (Ve) cellv.getTableRow().getItem();
                        KhoaBeoVeXeService s = new KhoaBeoVeXeService();
                        try {
                            if (s.deleteVe(v.getId())) {
                                MessageBox.getBox("Hủy Vé", "Thành Công", Alert.AlertType.INFORMATION).show();

                                this.LoadTableData(null);
                            } else {
                                MessageBox.getBox("Hủy Vé", "Faild", Alert.AlertType.INFORMATION).show();
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(FXMLTimVeController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            });
            TableCell cell = new TableCell();
            cell.setGraphic(btnHuyVe);
            return cell;
        });
        
        
        
        TableColumn colBtn2 = new TableColumn();
        colBtn2.setCellFactory(evt -> {
            Button btnDoiVe = new Button("ĐỔI VÉ !!!!");
            btnDoiVe.setOnAction(e -> {
                Alert xacNhanDoiVe = MessageBox.getBox("ĐỔI VÉ !!!!", "BẠN CÓ CHẮC MUỐN ĐỔI VÉ NÀY ", Alert.AlertType.CONFIRMATION);
                xacNhanDoiVe.showAndWait().ifPresent(respon -> {
                  if(respon ==ButtonType.OK){
                      
                  }
                });

            });
            TableCell cell = new TableCell();
            cell.setGraphic(btnDoiVe);
            return cell;
        });
        ///add vao bang table
        this.tableVeXe.getColumns().addAll(colMa, colCho, colGiaVe, colNgay, colKH, colSDT, colBtn,colBtn2);

    }

    private void LoadTableData(String kw) throws SQLException {
        KhoaBeoVeXeService vx = new KhoaBeoVeXeService();
        List<Ve> lsv = vx.getListVe(kw);

        this.tableVeXe.setItems(FXCollections.observableList(lsv));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            this.LoadTableColunm();
            this.LoadTableData(null);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLTimVeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.kwSearch.textProperty().addListener(e -> {
            try {
                this.LoadTableData(this.kwSearch.getText());
            } catch (SQLException ex1) {
                Logger.getLogger(FXMLTimVeController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        });
    }

}
