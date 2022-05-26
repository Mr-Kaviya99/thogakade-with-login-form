package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashBoardFormController {

    public AnchorPane root;

    public void initialize() throws IOException {
        initUi("DefaultForm.fxml");
    }

    public void btnCustomerOnAction(ActionEvent actionEvent) throws IOException {
        initUi("CustomerForm.fxml");
    }

    private void initUi(String location) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren()
                .add(FXMLLoader.
                        load(this.getClass().getResource("/view/" + location)));

    }

    public void btnOpenItemOnAction(ActionEvent actionEvent) throws IOException {
        initUi("ItemForm.fxml");
    }


}
