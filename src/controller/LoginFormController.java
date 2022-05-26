package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;

public class LoginFormController {
    public TextField txtEmail;
    public TextField txtPassword;

    public void btnLogin(ActionEvent actionEvent) throws Exception {
        String email = txtEmail.getText().trim();
        String password = txtPassword.getText().trim();

        if (email.length() > 0 && password.length() > 0) {

            if (email.equalsIgnoreCase("kavinduhasintha9@gmail.com")
                    && password.equalsIgnoreCase("1234")) {


                URL resource = this.getClass().
                        getResource("/view/DashBoardForm.fxml");
                Parent load = FXMLLoader.load(resource);// ALt + Enter
                Scene scene = new Scene(load);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again !!!!",
                        ButtonType.OK, ButtonType.NO).show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Empty !!!!",
                    ButtonType.OK, ButtonType.NO).show();
        }


    }
}
