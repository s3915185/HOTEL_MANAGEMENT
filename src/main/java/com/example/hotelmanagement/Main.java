package com.example.hotelmanagement;

import com.example.hotelmanagement.Objects.PaymentInformation;
import com.example.hotelmanagement.Objects.RoomInformation;
import com.example.hotelmanagement.Objects.RoomReservationInformation;
import com.example.hotelmanagement.Objects.UserInformation;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main extends Application {

    private static ObservableList<UserInformation> userDataObjectList = FXCollections.observableArrayList();
    private static ObservableList<RoomInformation> roomDataObjectList = FXCollections.observableArrayList();
    private static ObservableList<RoomReservationInformation> roomReservationObjectList = FXCollections.observableArrayList();
    private static ObservableList<PaymentInformation> paymentDataObjectList = FXCollections.observableArrayList();
    private static Object randomObject;

    public static Object getRandomObjectPayment() {
        return randomObjectPayment;
    }

    public static void setRandomObjectPayment(Object randomObjectPayment) {
        Main.randomObjectPayment = randomObjectPayment;
    }

    private static Object randomObjectPayment;

    public static Object randomObjectList[];

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
        loadRoomReservation();
        loadRoomData("");
        loadPaymentData();
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
            roomTypeQuery = " AND rc.class_name = " + "'"+ roomType + "'";
        }
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String connectQuery = "SELECT r.room_ID as room_ID, r.roomNumber as room_number, rq.quality as room_quality, rc.class_name as room_type, (rc.class_price * rq.priceMultiply) as room_price, rc.class_description as comments" +
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

    public static void loadRoomReservation() {
        if (roomReservationObjectList != null) {
            roomReservationObjectList.clear();
        }


        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String connectQuery = "SELECT room_ID, date_in, date_out, customer_ID FROM reservation";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                String dateIn = String.valueOf(queryOutput.getString("date_in"));
                String dateInDate = dateIn.split(" ")[0];
                String dateInTime = dateIn.split(" ")[1];
                String dateOut = String.valueOf(queryOutput.getString("date_out"));
                String dateOutDate = dateOut.split(" ")[0];
                String dateOutTime = dateOut.split(" ")[1];
                roomReservationObjectList.add(new RoomReservationInformation(queryOutput.getInt("room_ID"), dateInDate, dateInTime, dateOutDate, dateOutTime, queryOutput.getInt("customer_ID")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Object loadOneCustomerInfo(int info) {
        if (randomObject != null) {
            randomObject = null;
        }
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String connectQuery = "SELECT cust_ID, custfname, custlname, SSN, housenumber, district, state, gender," +
                " phonenumber FROM hotelmanagement.customer " +
                "WHERE cust_ID = "+ info +";";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);
            while (queryOutput.next()) {
                return new UserInformation(queryOutput.getInt("cust_ID"), queryOutput.getString("custfname"),
                        queryOutput.getString("custlname"), queryOutput.getString("SSN"), queryOutput.getString("housenumber"), queryOutput.getString("district"),
                        queryOutput.getString("state"), queryOutput.getString("gender"), queryOutput.getString("phonenumber"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        randomObject = null;
        return null;
    }

    public static Object loadRoomInformation(int info) {
        if (randomObject != null) {
            randomObject = null;
        }
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();


        String connectQuery = "SELECT r.room_ID as room_ID, r.roomNumber as room_number, rq.quality as room_quality, rc.class_name as room_type, (rc.class_price * rq.priceMultiply) as room_price, rc.class_description as comments\n" +
                "FROM hotelmanagement.room r, hotelmanagement.roomQuality rq, hotelmanagement.roomClass rc\n" +
                "WHERE r.roomQuality = rq.roomQuality_ID\n" +
                "AND rc.class_ID = r.class_ID\n" +
                "AND room_ID = " + info + ";";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                return new RoomInformation(queryOutput.getInt("room_ID"),
                        queryOutput.getInt("room_number"),
                        queryOutput.getString("room_quality"),
                        queryOutput.getString("room_type"),
                        queryOutput.getString("comments"), queryOutput.getDouble("room_price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void loadPaymentData() {
        if (paymentDataObjectList != null) {
            paymentDataObjectList.clear();
        }
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String connectQuery = "Select payment_ID, customer_ID, payment_date, amount, reservation_ID, payment_type FROM hotelmanagement.payment";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                String dateReceived = String.valueOf(queryOutput.getString("payment_date"));
                String date = dateReceived.split(" ")[0];
                String time = dateReceived.split(" ")[1];
                paymentDataObjectList.add(new PaymentInformation(queryOutput.getInt("payment_ID"),
                        queryOutput.getInt("customer_ID"), date, time,
                        queryOutput.getDouble("amount"), queryOutput.getInt("reservation_ID"), queryOutput.getString("payment_type")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public static void setRandomObject(Object object) {
        randomObject = object;
    }


    public static void loadSpecificSelectedRoom(String roomType, String timeIn, String timeOut) {
        if (roomDataObjectList != null) {
            roomDataObjectList.clear();
        }
        String roomTypeQuery = "";
        if (!Objects.equals(roomType, null)) {
            roomTypeQuery = " AND rc.class_name = " + "'"+ roomType + "'";
        }
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String connectQuery = "SELECT T.room_ID as room_ID, T.roomNumber as room_number, rq.quality as room_quality, rc.class_name as room_type, (rc.class_price * rq.priceMultiply) as room_price, rc.class_description as comments\n" +
                "FROM RoomQuality rq, RoomClass rc, (Select Room.room_ID, Room.roomNumber, Room.roomQuality, Room.class_ID\n" +
                "FROM Room\n" +
                "WHERE room_ID NOT IN (Select Room.room_ID FROM room\n" +
                "inner JOIN Reservation\n" +
                "ON Room.room_ID = Reservation.room_ID\n" +
                "WHERE Reservation.date_in BETWEEN '"+ timeIn + "' AND '"+ timeOut + "'\n" +
                "or Reservation.date_out BETWEEN '"+ timeIn + "' AND '"+ timeOut + "'\n" +
                "or '"+ timeIn + "' BETWEEN Reservation.date_in AND Reservation.date_out\n" +
                "or '"+ timeOut + "' BETWEEN Reservation.date_in AND Reservation.date_out)) as T\n" +
                "WHERE T.roomQuality = rq.roomQuality_ID\n" + roomTypeQuery +
                "AND rc.class_ID = T.class_ID\n" +
                "ORDER BY T.room_ID";
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
    public static ObservableList<RoomReservationInformation> getRoomReservationData() {return roomReservationObjectList;}
    public static Object getRandomObject() {return randomObject;}
    public static ObservableList<PaymentInformation> getPaymentData() {return paymentDataObjectList;}


}