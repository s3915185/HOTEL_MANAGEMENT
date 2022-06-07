package com.example.hotelmanagement.actionControllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CheckInController implements Initializable {

    @FXML
    private TextField balance;

    @FXML
    private TextField changes;

    @FXML
    private ChoiceBox<?> choiceboxAdultsRI;

    @FXML
    private ChoiceBox<String> choiceboxAdultsRR;
    private String[] adultsRR = {"1", "2", "3", "4", "5", "6", "7"};

    @FXML
    private ChoiceBox<?> choiceboxChildrensRI;

    @FXML
    private ChoiceBox<String> choiceboxChildrensRR;
    private String[] childrensRR = {"0", "1", "2", "3", "4", "5", "6", "7"};

    @FXML
    private ChoiceBox<?> choiceboxDateInDateRI;

    @FXML
    private ChoiceBox<?> choiceboxDateInDateRR;

    @FXML
    private ChoiceBox<?> choiceboxDateInTimeRI;

    @FXML
    private ChoiceBox<?> choiceboxDateInTimeRR;

    @FXML
    private ChoiceBox<?> choiceboxDateOutDateRI;

    @FXML
    private ChoiceBox<?> choiceboxDateOutDateRR;

    @FXML
    private ChoiceBox<?> choiceboxDateOutTimeRI;

    @FXML
    private ChoiceBox<?> choiceboxDateOutTimeRR;

    @FXML
    private ChoiceBox<?> choiceboxRoomNumberRI;

    @FXML
    private ChoiceBox<?> choiceboxRoomTypeRI;

    @FXML
    private ChoiceBox<String> choiceboxRoomTypeRR;

    private String[] roomType = {"Single", "Double", "King", "Studio", "Master Suite"};

    @FXML
    private TextField discountPercent;

    @FXML
    private TextField grandTotal;

    @FXML
    private TextField roomCharges;

    @FXML
    private TextField serviceCharges;

    @FXML
    private TextField totalPaid;

    @FXML
    private TextField userDistrict;

    @FXML
    private TextField userFirstName;

    @FXML
    private TextField userGender;

    @FXML
    private TextField userHouseNumber;

    @FXML
    private TextField userLastName;

    @FXML
    private TextField userPhoneNumber;

    @FXML
    private TextField userSSN;

    @FXML
    private TextField userState;

    public void customerEraseTempInfo() {
        userFirstName.clear();
        userLastName.clear();
        userSSN.clear();
        userHouseNumber.clear();
        userDistrict.clear();
        userState.clear();
        userGender.clear();
        userPhoneNumber.clear();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceboxRoomTypeRR.getItems().addAll(roomType);
        choiceboxAdultsRR.getItems().addAll(adultsRR);
        choiceboxChildrensRR.getItems().addAll(childrensRR);
    }
}