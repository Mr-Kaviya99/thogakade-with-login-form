package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ItemDTO;
import view.tm.CustomerTM;
import view.tm.ItemTM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class ItemFormController {
    public TextField txtCode;
    public TextField txtPrice;
    public TextField txtQty;
    public TextField txtDescription;
    public JFXTextField txtSearch;
    public JFXButton btnSave;
    public TableView<ItemTM> tblItems;
    public TableColumn colItemCode;
    public TableColumn colDescription;
    public TableColumn colQty;
    public TableColumn colPrce;
    public TableColumn colOperate;


    public void initialize() throws SQLException, ClassNotFoundException {

        colItemCode.setCellValueFactory(new PropertyValueFactory("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory("description"));
        colPrce.setCellValueFactory(new PropertyValueFactory("price"));
        colQty.setCellValueFactory(new PropertyValueFactory("qtyOnHand"));
        colOperate.setCellValueFactory(new PropertyValueFactory("btn"));

        loadAllItems(); // Alt + Enter
    }

    private void loadAllItems() throws SQLException, ClassNotFoundException {

        ResultSet set =
                DBConnection.getInstance().
                        getConnection().
                        prepareStatement
                                ("SELECT * FROM Item").
                        executeQuery();
        ArrayList<ItemDTO> itemDTOS = new ArrayList<>();
        while (set.next()) {
            itemDTOS.add(
                    new ItemDTO(
                            set.getString(1),
                            set.getString(2),
                            set.getInt(4),
                            set.getDouble(3)

                    )
            );
        }

        ObservableList<ItemTM> observableList =
                FXCollections.observableArrayList();

        observableList.clear();

        for (ItemDTO dto : itemDTOS) {  //iter --> TAB
            Button btn = new Button("Delete");
            observableList.add(
                    new ItemTM(dto.getCode(), dto.getDescription(),
                            dto.getPrice(), dto.getQtyOnHand(), btn)
            );

            btn.setOnAction((e) -> {

                ButtonType ok=new ButtonType("Ok",ButtonBar.ButtonData.OK_DONE);
                ButtonType no=new ButtonType("No",ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert= new Alert(Alert.AlertType.CONFIRMATION,
                        "Are You Sure Whether You Want to Delete this item ?",ok,no);
               Optional<ButtonType> result= alert.showAndWait();

                System.out.println(result);

                if(result.orElse(no)==ok){

                    try {
                        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("DELETE FROM Item WHERE code=?");
                        stm.setString(1, dto.getCode());
                        boolean deleted=stm.executeUpdate()>0;
                        if (deleted){
                            /*tblItems.refresh();*/
                            loadAllItems();
                            System.out.println("Deleted");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }

                }else{
                    //close
                }
            });
        }
        tblItems.setItems(observableList);
    }


    public void btnNewOnAction(ActionEvent actionEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        if (btnSave.getText().equalsIgnoreCase("Save")) {
            // save

            ItemDTO itemDTO = new ItemDTO(
                    txtCode.getText(),
                    txtDescription.getText(),
                    Integer.parseInt(txtQty.getText()),
                    Double.parseDouble(txtPrice.getText())
            );

            PreparedStatement statement = DBConnection.getInstance().
                    getConnection().prepareStatement
                    ("INSERT INTO Item VALUES (?,?,?,?)");
            statement.setString(1, itemDTO.getCode());
            statement.setString(2, itemDTO.getDescription());
            statement.setDouble(3, itemDTO.getPrice());
            statement.setInt(4, itemDTO.getQtyOnHand());

            if (statement.executeUpdate() > 0) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!",
                        ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something went wrong !",
                        ButtonType.CLOSE).show();
            }


        } else {
            // update
        }


    }
}
