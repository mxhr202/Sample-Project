package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class LoginController {

    @FXML
    private void handleLogin(ActionEvent event) {
        try {
            Stage mainStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org.example/main.fxml"));
            Scene mainScene = new Scene(loader.load());
            mainStage.setScene(mainScene);
            mainStage.setTitle("Main Window");
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
