package com.example.hotelmanagement;

import com.example.hotelmanagement.actionControllers.CheckIn.CheckInController;
import com.example.hotelmanagement.reportControllers.reportOverall.ModelReportOverall;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main extends Application {

    private static ObservableList<ModelReportOverall> objlist = FXCollections.observableArrayList();

    public static int getIDcurrentGuest() {
        return IDcurrentGuest;
    }

    public static void setIDcurrentGuest(int IDcurrentGuest) {
        Main.IDcurrentGuest = IDcurrentGuest;

    }

    private static int IDcurrentGuest = 0;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        fxmlLoader.getController();
        stage.getIcons().add(new Image("file:src/main/resources/images/logo/VIVANT_PURPLE_BACKGROUND.png"));
        stage.setTitle("VIVANT®");
        stage.setScene(scene);
        stage.show();


        loadUserData();


    }

    public static void main(String[] args) {
        launch();
    }

    public void loadUserData() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String connectQuery = "SELECT cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber FROM CUSTOMER";
        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                objlist.add(new ModelReportOverall(queryOutput.getString("cust_ID"), queryOutput.getString("custfname"),
                        queryOutput.getString("custlname"), queryOutput.getString("SSN"), queryOutput.getString("housenumber"), queryOutput.getString("district"),
                        queryOutput.getString("state"), queryOutput.getString("gender"), queryOutput.getString("phonenumber")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ObservableList<ModelReportOverall> getUserData() {
        return objlist;
    }

}