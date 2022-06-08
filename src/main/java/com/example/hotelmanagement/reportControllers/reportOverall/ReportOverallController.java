package com.example.hotelmanagement.reportControllers.reportOverall;

import com.example.hotelmanagement.Main;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ReportOverallController implements Initializable {


    @FXML
    private TableColumn<ModelReportOverall, String> custId;

    @FXML
    private TableColumn<ModelReportOverall, String> custf;

    @FXML
    private TableColumn<ModelReportOverall, String> custl;

    @FXML
    private TableView<ModelReportOverall> custormerInfo;

    @FXML
    private TableColumn<ModelReportOverall, String> district;

    @FXML
    private TableColumn<ModelReportOverall, String> gender;

    @FXML
    private TableColumn<ModelReportOverall, String> housenumber;

    @FXML
    private TableColumn<ModelReportOverall, String> phonenumber;

    @FXML
    private TableColumn<ModelReportOverall, String> ssn;

    @FXML
    private TableColumn<ModelReportOverall, String> state;



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
