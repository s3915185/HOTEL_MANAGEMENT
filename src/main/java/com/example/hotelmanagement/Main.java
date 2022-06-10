package com.example.hotelmanagement;

import com.example.hotelmanagement.Objects.RoomInformation;
import com.example.hotelmanagement.Objects.UserInformation;
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
import java.util.Objects;

public class Main extends Application {

    private static ObservableList<UserInformation> userDataObjectList = FXCollections.observableArrayList();
    private static ObservableList<RoomInformation> roomDataObjectList = FXCollections.observableArrayList();

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
        loadRoomData("");


    }

    public static void main(String[] args) {
        launch();
    }

    public static void loadUserData() {
        if (userDataObjectList != null) {
            userDataObjectList.clear();
        }
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String connectQuery = "SELECT cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber FROM CUSTOMER";
        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                userDataObjectList.add(new UserInformation(queryOutput.getInt("cust_ID"), queryOutput.getString("custfname"),
                        queryOutput.getString("custlname"), queryOutput.getString("SSN"), queryOutput.getString("housenumber"), queryOutput.getString("district"),
                        queryOutput.getString("state"), queryOutput.getString("gender"), queryOutput.getString("phonenumber")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void loadRoomData(String roomType) {
        if (roomDataObjectList != null) {
            roomDataObjectList.clear();
        }
        String roomTypeQuery = "";
        if (!Objects.equals(roomType, null)) {
            roomTypeQuery = " AND rc.name = " + "'"+ roomType + "'";
        }
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String connectQuery = "SELECT r.room_ID as room_ID, r.roomNumber as room_number, rq.quality as room_quality, rc.name as room_type, (rc.price * rq.priceMultiply) as room_price, rc.description as comments" +
                " FROM Room r, RoomQuality rq, RoomClass rc" +
                " WHERE r.roomQuality = rq.roomQuality_ID" +
                " AND rc.class_ID = r.class_ID" + roomTypeQuery +
                " ORDER BY r.room_ID";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                roomDataObjectList.add(new RoomInformation(queryOutput.getInt("room_ID"),
                        queryOutput.getInt("room_number"),
                        queryOutput.getString("room_quality"),
                        queryOutput.getString("room_type"),
                        queryOutput.getString("comments"), queryOutput.getDouble("room_price")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ObservableList<UserInformation> getUserData() {
        return userDataObjectList;
    }
    public static ObservableList<RoomInformation> getRoomData() {
        return  roomDataObjectList;
    }

}