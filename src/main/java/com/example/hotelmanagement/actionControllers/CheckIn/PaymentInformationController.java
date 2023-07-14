package com.example.hotelmanagement.actionControllers.CheckIn;

import com.example.hotelmanagement.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.stream.IntStream;

public class PaymentInformationController {
    @FXML
    private Button bankingTypeBtn;

    @FXML
    private Button cashTypeBtn;

    @FXML
    private BorderPane borderPanePayment;

    public void toBankingClicked() throws IOException {
        Pane view = FXMLLoader.load(Main.class.getResource("actionFXMLs/CheckIn/payment_banking.fxml"));
        borderPanePayment.setCenter(view);
    }
    public void toCashClicked() throws IOException {
        Pane view = FXMLLoader.load(Main.class.getResource("actionFXMLs/CheckIn/payment_cash.fxml"));
        borderPanePayment.setCenter(view);
    }

}
