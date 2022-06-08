package com.example.hotelmanagement.actionControllers.CheckIn;

import com.example.hotelmanagement.DatabaseConnection;
import com.example.hotelmanagement.reportControllers.reportOverall.ModelReportOverall;
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

public class UserRegistered implements Initializable {

    @FXML
    private TableColumn<ModelReportOverall, String> userFirstName;

    @FXML
    private TableColumn<ModelReportOverall, String> userLastName;

    @FXML
    private TableColumn<ModelReportOverall, String> userPhoneNumber;

    @FXML
    private TableView<ModelReportOverall> userRegisteredInfo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        userFirstName.setCellValueFactory(new PropertyValueFactory<>("custfname"));
        userLastName.setCellValueFactory(new PropertyValueFactory<>("custlname"));
        userPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));

        String connectQuery = "SELECT cust_ID, custfname, custlname, phonenumber FROM Customer";
        ObservableList<ModelReportOverall> objlist = FXCollections.observableArrayList();

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                objlist.add(new ModelReportOverall(queryOutput.getString("cust_Id"),
                        queryOutput.getString("custfname"), queryOutput.getString("custlname"),
                        queryOutput.getString("phonenumber")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        userRegisteredInfo.setItems(objlist);

    }
}
