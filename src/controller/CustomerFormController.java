package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.CrudUtil;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import jdk.nashorn.internal.objects.annotations.Property;
import model.CustomerDTO;
import view.tm.CustomerTM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerFormController {
//    public JFXTextField txtId;
//    public JFXTextField txtName;
//    public JFXTextField txtSalary;
//    public JFXTextField txtAddress;
//    public TextField txtSearch;
//    public JFXButton btnSave;
//    public TableView tblCustomer;
//    public TableColumn colId;
//    public TableColumn colName;
//    public TableColumn colAddress;
//    public TableColumn colSalary;
//    public TableColumn colOperate;
//
//    public void initialize() throws SQLException, ClassNotFoundException {
//
//        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
//        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
//        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
//        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
//        colOperate.setCellValueFactory(new PropertyValueFactory<>("btn"));
//
//
//        /* ResultSet set=DBConnection.getInstance().
//                getConnection().
//                prepareStatement
//                        ("").executeQuery();
//        System.out.println(set);*/
//
//        ResultSet set= CrudUtil.execute("SELECT * FROM Customer");
//        ArrayList<CustomerDTO> customerDTOS= new ArrayList<>();
//
//        while (set.next()){
//            customerDTOS.add( new CustomerDTO(
//                    set.getString(1),
//                    set.getString(2),
//                    set.getString(3),
//                    set.getDouble(4)
//            ));
//        }
//
//        ObservableList observableList= FXCollections.observableArrayList();
//
//        for (CustomerDTO dto : customerDTOS) {
//
//            JFXButton btn= new JFXButton("Delete");
//
//            observableList.add(new CustomerTM(dto.getId(),dto.getName(),dto.getAddress(),dto.getSalary(),btn));
//
//            btn.setOnAction((e)->{
//                try {
//                    boolean deleted=CrudUtil.execute("DELETE FROM Customer WHERE id=?",dto.getId());
//
//                    if (deleted){
//                        new Alert(Alert.AlertType.CONFIRMATION,"Deleted", ButtonType.OK).show();
//                    }else{
//                        new Alert(Alert.AlertType.CONFIRMATION,"Try Again!", ButtonType.OK).show();
//                    }
//
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                } catch (ClassNotFoundException e1) {
//                    e1.printStackTrace();
//                }
//            });
//
//        }
////        tblCustomer.setItems(observableList);
////
//
//}

    public void btnSaveOnAction(ActionEvent actionEvent) {
    }
}
