package com.example.hotelmanagement.actionControllers.CheckIn;

import com.example.hotelmanagement.DatabaseConnection;
import com.example.hotelmanagement.Main;
import com.example.hotelmanagement.Objects.PaymentInformation;
import com.example.hotelmanagement.Objects.RoomInformation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PaymentBankingController {
    @FXML
    private Button receivedFeeBtn;

    public void receivedFeeBtnClicked() {
        LocalDateTime LocalDateTime = java.time.LocalDateTime.now();
        String date = LocalDateTime.getYear()+"-"+LocalDateTime.getMonthValue()+"-"+LocalDateTime.getDayOfMonth();
        String time = LocalDateTime.getHour()+":"+LocalDateTime.getMinute()+":"+LocalDateTime.getSecond();
        System.out.println("Date: " + date);
        System.out.println("Time: "+ time);
        Main.setRandomObjectPayment(new PaymentInformation(Main.getIDcurrentGuest(), date, time, 0, 0, "BANKING"));
        //Main.setRandomObject(new PaymentInformation(Main.getIDcurrentGuest(), ));
        /*
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String connectQuery = "insert into hotelmanagement.payment (customer_ID, payment_date, amount, reservation_ID, payment_type)\n" +
                    "values (?, ?, ?, \n" +
                    "(SELECT reservation_ID FROM hotelmanagement.reservation ORDER BY reservation_ID DESC LIMIT 0, 1)\n" +
                    ", ?);";
            PreparedStatement preparedStatement = connectDB.prepareStatement(connectQuery);
            preparedStatement.setInt(1, Main.getIDcurrentGuest());
            preparedStatement.setString(2, timeIn);
            preparedStatement.setString(3, timeOut);
            preparedStatement.setInt(4, Main.getIDcurrentGuest());
            preparedStatement.execute();
            Main.loadUserData();
            Main.loadRoomReservation();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

         */
        Stage stage = (Stage) receivedFeeBtn.getScene().getWindow();
        stage.close();
    }
}
