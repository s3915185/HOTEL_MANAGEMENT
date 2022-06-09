package com.example.hotelmanagement.reportControllers.reportOverall;

import com.example.hotelmanagement.Main;

import com.example.hotelmanagement.Objects.UserInformation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ReportOverallController implements Initializable {


    @FXML
    private TableColumn<UserInformation, Integer> custId;

    @FXML
    private TableColumn<UserInformation, String> custf;

    @FXML
    private TableColumn<UserInformation, String> custl;

    @FXML
    private TableView<UserInformation> custormerInfo;

    @FXML
    private TableColumn<UserInformation, String> district;

    @FXML
    private TableColumn<UserInformation, String> gender;

    @FXML
    private TableColumn<UserInformation, String> housenumber;

    @FXML
    private TableColumn<UserInformation, String> phonenumber;

    @FXML
    private TableColumn<UserInformation, String> ssn;

    @FXML
    private TableColumn<UserInformation, String> state;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        custId.setCellValueFactory(new PropertyValueFactory<>("cust_ID"));
        custf.setCellValueFactory(new PropertyValueFactory<>("custfname"));
        custl.setCellValueFactory(new PropertyValueFactory<>("custlname"));
        ssn.setCellValueFactory(new PropertyValueFactory<>("SSN"));
        housenumber.setCellValueFactory(new PropertyValueFactory<>("housenumber"));
        district.setCellValueFactory(new PropertyValueFactory<>("district"));
        state.setCellValueFactory(new PropertyValueFactory<>("state"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        phonenumber.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
        custormerInfo.setItems(Main.getUserData());
    }
}
