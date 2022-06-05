package com.example.hotelmanagement.reportControllers.reportOverall;

import com.example.hotelmanagement.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ReportOverallController implements Initializable {

    @FXML
    private TableView<ModelReportOverall> custormerInfo;

    @FXML
    private TableColumn<ModelReportOverall, String> address;

    @FXML
    private TableColumn<ModelReportOverall, String> custId;

    @FXML
    private TableColumn<ModelReportOverall, String> custf;

    @FXML
    private TableColumn<ModelReportOverall, String> custl;

    @FXML
    private TableColumn<ModelReportOverall, String> status;


    ObservableList<ModelReportOverall> object = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();


        custId.setCellValueFactory(new PropertyValueFactory<>("cust_ID"));
        custf.setCellValueFactory(new PropertyValueFactory<>("custfname"));
        custl.setCellValueFactory(new PropertyValueFactory<>("custlname"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));

        String connectQuery = "SELECT cust_ID, custfname, custlname, address, status FROM CUSTOMER";
        ObservableList<ModelReportOverall> objlist = FXCollections.observableArrayList();

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                objlist.add(new ModelReportOverall(queryOutput.getString("cust_ID"), queryOutput.getString("custfname"),
                        queryOutput.getString("custlname"), queryOutput.getString("address"), queryOutput.getString("status")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        custormerInfo.setItems(objlist);
    }
}
