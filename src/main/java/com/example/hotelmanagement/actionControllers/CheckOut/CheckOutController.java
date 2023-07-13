package com.example.hotelmanagement.actionControllers.CheckOut;

import com.example.hotelmanagement.Main;
import com.example.hotelmanagement.Objects.RoomReservationInformation;
import com.example.hotelmanagement.Objects.UserInformation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class CheckOutController implements Initializable {

    @FXML
    private TextField checkout_inputNum;

    @FXML
    private DatePicker checkout_dateSelected;


    @FXML
    private Button checkout_searchInfoBtn;

    @FXML
    private TextField checkout_dateOut;

    @FXML
    private TextField checkout_totalPaid;

    @FXML
    private TextField checkout_extraFees;

    @FXML
    private TextField checkout_totalLeft;

    @FXML
    private Button checkout_payLeftOverBtn;

    @FXML
    private Button checkout_checkOutBtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Main.loadRoomReservation();
        for (RoomReservationInformation roomReservationInformation : Main.getRoomReservationData()) {
            System.out.println(roomReservationInformation.toString());
        }
    }

    public void searchInfoBtnClicked() {

        if ((checkout_inputNum.getText() != null) && (checkout_dateSelected.getValue() != null))  {
            boolean userFound = false;
            int userID = -1;
            boolean reservationFound = false;
            for (UserInformation user : Main.getUserData()) {
                if (user.getPhonenumber().equals(checkout_inputNum.getText().toString())) {
                    userFound = true;
                    userID = user.getCust_ID();
                    break;
                }
            }
            for (RoomReservationInformation roomReservationInformation : Main.getRoomReservationData()) {
                if (roomReservationInformation.getDate_in_date().equals(checkout_dateSelected.getValue().toString()) && userID == roomReservationInformation.getCustomer_ID()) {
                    reservationFound = true;
                    break;
                }
            }
            if (userFound == true && reservationFound == true) {
                System.out.println("Got to the clearer path");
            }
        }

    }
}
