package org.example;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.application.Application;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org.example/MainApp.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Hauptfenster");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        Button openSecondWindowButton = (Button) root.lookup("#openSecondWindowButton");
        openSecondWindowButton.setOnAction(event -> openSecondWindow());
    }

    private void openSecondWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org.example/SecondWindow.fxml"));
            Parent secondWindowRoot = loader.load();
            Stage secondStage = new Stage();
            secondStage.setTitle("Second Window");
            secondStage.setScene(new Scene(secondWindowRoot));
            secondStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
