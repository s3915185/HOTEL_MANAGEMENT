package com.example.hotelmanagement.actionControllers.CheckIn;

import com.example.hotelmanagement.DatabaseConnection;
import com.example.hotelmanagement.Main;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.sql.*;
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

    @FXML
    private ImageView customerErase;
    @FXML
    private ImageView customerAdd;
    @FXML
    private ImageView customerList;
    @FXML
    private ImageView reloadTotalPage;


    public void reloadTotalPageClicked() {
        setInfoForOldCustomer();
        rollingAnimation(reloadTotalPage);
    }

    public void customerEraseTempInfoClicked() {
        if (userFirstName.getText().isEmpty() && userLastName.getText().isEmpty() && userSSN.getText().isEmpty() && userHouseNumber.getText().isEmpty() &&
                userDistrict.getText().isEmpty() && userState.getText().isEmpty() && userGender.getText().isEmpty() && userPhoneNumber.getText().isEmpty()) {
            System.out.println("All inputs are blank");
            jigglingAnimation(customerErase);
            return;
        }
        rollingAnimation(customerErase);
        userFirstName.clear();
        userLastName.clear();
        userSSN.clear();
        userHouseNumber.clear();
        userDistrict.clear();
        userState.clear();
        userGender.clear();
        userPhoneNumber.clear();
        Main.setIDcurrentGuest(0);
    }

    public void customerAddClicked() {
        if (userFirstName.getText().isEmpty() || userLastName.getText().isEmpty() || userSSN.getText().isEmpty() || userHouseNumber.getText().isEmpty() ||
                userDistrict.getText().isEmpty() || userState.getText().isEmpty() || userGender.getText().isEmpty() || userPhoneNumber.getText().isEmpty()) {
            System.out.println("The inputs cannot be left blank");
            jigglingAnimation(customerAdd);
            return;
        }
        if (Main.getIDcurrentGuest() != 0) {
            System.out.println("This is already a guest");
            jigglingAnimation(customerAdd);
            return;
        }
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();

            String connectQuery = "INSERT INTO Customer (custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) VALUES " +
                    "(?,?,?,?,?,?,?,?); ";
            PreparedStatement preparedStatement = connectDB.prepareStatement(connectQuery);
            preparedStatement.setString(1, userFirstName.getText());
            preparedStatement.setString(2, userLastName.getText());
            preparedStatement.setString(3, userSSN.getText());
            preparedStatement.setString(4, userHouseNumber.getText());
            preparedStatement.setString(5, userDistrict.getText());
            preparedStatement.setString(6, userState.getText());
            preparedStatement.setString(7, userGender.getText());
            preparedStatement.setString(8, userPhoneNumber.getText());
            preparedStatement.execute();
            rollingAnimation(customerAdd);
            Main.loadUserData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void customerListClicked() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/hotelmanagement/actionFXMLs/CheckIn/UserRegistered.fxml"));
            Parent customerListRoot = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(customerListRoot));
            stage.setTitle("Old Customers List");
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        rollingAnimation(customerList);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceboxRoomTypeRR.getItems().addAll(roomType);
        choiceboxAdultsRR.getItems().addAll(adultsRR);
        choiceboxChildrensRR.getItems().addAll(childrensRR);
    }


    private void rollingAnimation(ImageView icon) {
        RotateTransition rollingAnimation = new RotateTransition(Duration.millis(300), icon);
        rollingAnimation.setByAngle(360);
        rollingAnimation.setCycleCount(1);
        rollingAnimation.play();
    }

    private void jigglingAnimation (ImageView icon) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(20), icon);
        translateTransition.setByX(2f);
        translateTransition.setCycleCount(2);
        translateTransition.setAutoReverse(true);
        translateTransition.play();
    }

    public void setInfoForOldCustomer() {
        Main.getUserData().forEach(user -> {
            if (Main.getIDcurrentGuest() == user.getCust_ID()) {
                userFirstName.setText(user.getCustfname());
                userLastName.setText(user.getCustlname());
                userSSN.setText(user.getSSN());
                userHouseNumber.setText(user.getHousenumber());
                userDistrict.setText(user.getDistrict());
                userState.setText(user.getState());
                userGender.setText(user.getGender());
                userPhoneNumber.setText(user.getPhonenumber());
            }
        });
    }

    public void mouseEntered(javafx.scene.input.MouseEvent mouseEvent) {
        setInfoForOldCustomer();
    }
}