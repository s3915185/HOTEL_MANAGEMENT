package com.example.hotelmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Set;

public class HomeController implements Initializable {

    @FXML
    private Button btnCheckIn;

    @FXML
    private Button btnCheckOut;

    @FXML
    private Button btnHallReservation;

    @FXML
    private Button btnRoomReservation;

    @FXML
    private Button btnRoomService;

    @FXML
    private Button btnVoucher;

    @FXML
    private VBox leftnavigation;

    @FXML
    private Button reportAllTransactions;

    @FXML
    private Button reportCheckOutDue;

    @FXML
    private Button reportDayBook;

    @FXML
    private Button reportDebtors;

    @FXML
    private Button reportHallReservation;

    @FXML
    private Button reportOverall;

    @FXML
    private Button reportRoomOccupancy;

    @FXML
    private Button reportRoomReservation;
    HashMap<Integer, String> reports = new HashMap<Integer, String>();
    HashMap<Integer, String> actions = new HashMap<Integer, String>();

    public void moveToReport(ActionEvent event) throws IOException {
        Button clicked = (Button) event.getSource();
        String reportClickedId = clicked.getId();
        Set<Integer> keySet = reports.keySet();
        for (Integer key: keySet) {
            if (reports.get(key) == reportClickedId) {
                // To that Window
            }
        }
    }

    public void moveToPage(ActionEvent event) throws IOException {
        Button clicked = (Button) event.getSource();
        String buttonClickedId = clicked.getId();
        Set<Integer> keySet = actions.keySet();
        for (Integer key : keySet) {
            if (actions.get(key) == buttonClickedId) {
                // Display action choices in the same window
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize for Report Buttons
        reports.put(1, "reportDayBook");
        reports.put(2, "reportCheckOutDue");
        reports.put(3, "reportOverall");
        reports.put(4, "reportRoomOccupancy");
        reports.put(5, "reportHallReservation");
        reports.put(6, "reportRoomReservation");
        reports.put(7, "reportAllTransactions");
        reports.put(8, "reportDebtors");

        // Initialize for Action Buttons
        actions.put(1, "btnCheckIn");
        actions.put(2, "btnCheckOut");
        actions.put(3, "btnRoomReservation");
        actions.put(4, "btnHallReservation");
        actions.put(5, "btnRoomService");
        actions.put(6, "btnVoucher");
    }
}

