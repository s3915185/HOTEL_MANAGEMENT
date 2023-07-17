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
        Main.setRandomObjectPayment(new PaymentInformation(Main.getIDcurrentGuest(), date, time, 0, 0, "BANKING"));
        Stage stage = (Stage) receivedFeeBtn.getScene().getWindow();
        stage.close();
    }
}
