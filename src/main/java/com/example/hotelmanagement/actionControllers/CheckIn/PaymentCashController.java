package com.example.hotelmanagement.actionControllers.CheckIn;

import com.example.hotelmanagement.Main;
import com.example.hotelmanagement.Objects.PaymentInformation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class PaymentCashController {
    @FXML
    private Button payWithCashBtn;

    public void payWithCashBtnClicked() {
        LocalDateTime LocalDateTime = java.time.LocalDateTime.now();
        String date = LocalDateTime.getYear()+"-"+LocalDateTime.getMonthValue()+"-"+LocalDateTime.getDayOfMonth();
        String time = LocalDateTime.getHour()+":"+LocalDateTime.getMinute()+":"+LocalDateTime.getSecond();
        System.out.println("Date: " + date);
        System.out.println("Time: "+ time);
        Main.setRandomObject(new PaymentInformation(Main.getIDcurrentGuest(), date, time, 0, 0, "CASH"));
        Stage stage = (Stage) payWithCashBtn.getScene().getWindow();
        stage.close();
    }
}
