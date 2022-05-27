package com.example.hotelmanagement;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private VBox leftnavigation;
    public HomeController() {}
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        leftnavigation.setPrefSize(300.0, 720.0);
        leftnavigation.setAlignment(Pos.CENTER);
    }
}
