package com.example.hotelmanagement.actionControllers.CheckIn;

import com.example.hotelmanagement.Main;
import com.example.hotelmanagement.reportControllers.reportOverall.ModelReportOverall;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class UserRegistered extends Stage implements Initializable{

    @FXML
    private TableColumn<ModelReportOverall, String> userFirstName;

    @FXML
    private TableColumn<ModelReportOverall, String> userLastName;

    @FXML
    private TableColumn<ModelReportOverall, String> userPhoneNumber;

    @FXML
    private TableView<ModelReportOverall> userRegisteredInfo;

    @FXML
    public void oldUserInfoSelected(MouseEvent event) {
        TableView table = (TableView) event.getSource();
        ObservableList<ModelReportOverall> temp = table.getSelectionModel().getSelectedItems();
        if (event.getClickCount() == 2) {
            Main.setIDcurrentGuest(Integer.parseInt(temp.get(0).getCust_ID()));
            Stage stage = (Stage) ((TableView<?>) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        userFirstName.setCellValueFactory(new PropertyValueFactory<>("custfname"));
        userLastName.setCellValueFactory(new PropertyValueFactory<>("custlname"));
        userPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
        userRegisteredInfo.setItems(Main.getUserData());
    }
}
