package com.example.hotelmanagement;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class HomeController implements Initializable {
    @FXML
    private BorderPane mainPane;

    public void moveToReport(ActionEvent event) {
        Button clicked = (Button) event.getSource();
        String reportClickedId = clicked.getId();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reportFXMLs/" + reportClickedId + ".fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle(reportClickedId);
            stage.show();
        }
        catch (Exception e) {
            System.out.println("Cant load new window");
        }
    }

    public void moveToPage(ActionEvent event) throws IOException {
        Button actionClicked = (Button) event.getSource();
        String actionId = actionClicked.getId().substring(3);
        Pane view = FXMLLoader.load(getClass().getResource("actionFXMLs/" + actionId +"/"+ actionId + ".fxml"));
        mainPane.setCenter(view);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}

