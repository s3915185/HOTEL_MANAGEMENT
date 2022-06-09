package com.example.hotelmanagement;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loadScreenController implements Initializable {
    @FXML
    private AnchorPane anchorPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new SplashScreen().start();
    }

    class SplashScreen extends Thread {
        @Override
        public void run() {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
            Parent mainPage = null;
            try {

                mainPage = loader.load();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            Parent finalHomePage = mainPage;
            Platform.runLater(() -> {
                Stage stage = new Stage();
                stage.setScene(new Scene(finalHomePage));
                stage.getIcons().add(new Image("file:src/main/resources/images/logo/VIVANT_PURPLE_BACKGROUND.png"));
                stage.setTitle("VIVANT®");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stage.show();
                anchorPane.getScene().getWindow().hide();
            });
        }
    }
}
