package com.example.hotelmanagement;

import com.example.hotelmanagement.Objects.UserInformation;
import com.example.hotelmanagement.actionControllers.CheckIn.CheckInController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main extends Application {

    private static ObservableList<UserInformation> objlist = FXCollections.observableArrayList();

    public static int getIDcurrentGuest() {
        return IDcurrentGuest;
    }

    public static void setIDcurrentGuest(int IDcurrentGuest) {
        Main.IDcurrentGuest = IDcurrentGuest;

    }

    private static int IDcurrentGuest = 0;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("loadingScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        fxmlLoader.getController();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
        loadUserData();


    }

    public static void main(String[] args) {
        launch();
    }

    public static void loadUserData() {
        if (objlist != null) {
            objlist.clear();
        }
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String connectQuery = "SELECT cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber FROM CUSTOMER";
        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                objlist.add(new UserInformation(queryOutput.getInt("cust_ID"), queryOutput.getString("custfname"),
                        queryOutput.getString("custlname"), queryOutput.getString("SSN"), queryOutput.getString("housenumber"), queryOutput.getString("district"),
                        queryOutput.getString("state"), queryOutput.getString("gender"), queryOutput.getString("phonenumber")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static ObservableList<UserInformation> getUserData() {
        return objlist;
    }

}