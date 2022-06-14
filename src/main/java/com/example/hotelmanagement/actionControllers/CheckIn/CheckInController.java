package com.example.hotelmanagement.actionControllers.CheckIn;

import com.example.hotelmanagement.DatabaseConnection;
import com.example.hotelmanagement.Main;
import com.example.hotelmanagement.Objects.RoomInformation;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
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
    @FXML
    private DatePicker choiceboxRoomDateInDateRR;

    private String[] roomType = {"All Type", "Single", "Double", "King", "Studio", "Master Suite"};

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

    @FXML
    private TableView<RoomInformation> roomAvailabilityT;
    @FXML
    private TableColumn<RoomInformation, Integer> roomNumberTC;
    @FXML
    private TableColumn<RoomInformation, String> roomQualityTC;
    @FXML
    private TableColumn<RoomInformation, String> roomTypeTC;
    @FXML
    private TableColumn<RoomInformation, Double> roomChargesTC;
    @FXML
    private TableColumn<RoomInformation, String> roomCommentsTC;
    @FXML
    private ImageView reloadRoomAvailability;
    @FXML
    private DatePicker choiceboxRoomDateOutDateRR;
    @FXML
    private ChoiceBox<Integer> choiceboxRoomDateInHourRR;
    @FXML
    private ChoiceBox<Integer> choiceboxRoomDateInMinuteRR;
    @FXML
    private ChoiceBox<Integer> choiceboxRoomDateOutHourRR;
    @FXML
    private ChoiceBox<Integer> choiceboxRoomDateOutMinuteRR;

    private Integer[] dateInHourArray;
    private Integer[] dateInMinuteArray;
    private Integer[] dateOutHourArray;
    private Integer[] dateOutMinuteArray;


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
        userEntryClear();
        Main.setIDcurrentGuest(0);
        setUserEntryEditable(true);
        rollingAnimation(customerErase);
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

        insertCustomer();
        userEntryClear();
    }

    public void customerListClicked() {
        openOldCustomerList();
        rollingAnimation(customerList);
    }


    public void reloadRoomAvailabilityClicked() {
        String roomType = choiceboxRoomTypeRR.getValue();
        if (roomType == "All Type") {
            roomType = null;
        }
        Main.loadRoomData(roomType);
        displayRoomAvailability();
        rollingAnimation(reloadRoomAvailability);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceboxRoomTypeRR.getItems().addAll(roomType);
        choiceboxAdultsRR.getItems().addAll(adultsRR);
        choiceboxChildrensRR.getItems().addAll(childrensRR);
        Main.loadRoomData(null);
        displayRoomAvailability();
        DateTimeInitializer(choiceboxRoomDateInDateRR, choiceboxRoomDateInHourRR, choiceboxRoomDateInMinuteRR);
        DateTimeInitializer(choiceboxRoomDateOutDateRR, choiceboxRoomDateOutHourRR, choiceboxRoomDateOutMinuteRR);
        setHourBasedOnDate(choiceboxRoomDateInDateRR.getValue(), choiceboxRoomDateInHourRR, choiceboxRoomDateInHourRR.getValue());
        setHourBasedOnDate(choiceboxRoomDateOutDateRR.getValue(), choiceboxRoomDateOutHourRR, choiceboxRoomDateOutHourRR.getValue());
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
                System.out.println(user.getClass());
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
        if (Main.getIDcurrentGuest() != 0 ) {
            setUserEntryEditable(false);
        }
    }

    private void displayRoomAvailability() {
        roomNumberTC.setCellValueFactory(new PropertyValueFactory<>("room_number"));
        roomQualityTC.setCellValueFactory(new PropertyValueFactory<>("room_quality"));
        roomTypeTC.setCellValueFactory(new PropertyValueFactory<>("room_type"));
        roomChargesTC.setCellValueFactory(new PropertyValueFactory<>("room_price"));
        roomCommentsTC.setCellValueFactory(new PropertyValueFactory<>("comments"));
        roomAvailabilityT.setItems(Main.getRoomData());
    }

    private void userEntryClear() {
        userFirstName.clear();
        userLastName.clear();
        userSSN.clear();
        userHouseNumber.clear();
        userDistrict.clear();
        userState.clear();
        userGender.clear();
        userPhoneNumber.clear();
    }

    private void setUserEntryEditable(boolean value) {
        userFirstName.setEditable(value);
        userLastName.setEditable(value);
        userSSN.setEditable(value);
        userHouseNumber.setEditable(value);
        userDistrict.setEditable(value);
        userState.setEditable(value);
        userGender.setEditable(value);
        userPhoneNumber.setEditable(value);
    }

    private void openOldCustomerList() {
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
    }
    private void insertCustomer() {
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

    private void DateTimeInitializer(DatePicker forDate, ChoiceBox<Integer> forHour, ChoiceBox<Integer> forMinute) {

        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        forDate.setValue(localDate);
        forHour.setValue(localTime.getHour());
        forHour.setValue(localTime.getHour());
        forMinute.setValue(localTime.getMinute());
    }

    private void setHourBasedOnDate(LocalDate date, ChoiceBox<Integer> forHour, Integer value) {
        forHour.getItems().clear();
        if (date.isEqual(LocalDate.now())) {
            Integer[] forHourArray = new Integer[(24 - LocalTime.now().getHour())];
            int arrayIndex = 0;
            for (int i = LocalTime.now().getHour(); i < 24; i++) {
                forHourArray[arrayIndex] = i;
                arrayIndex++;
            }
            forHour.getItems().addAll(forHourArray);
        }
        else {
            Integer[] forHourArray = new Integer[24];
            for (int i = 0; i < 24; i++) {
                forHourArray[i] = i;
            }
            forHour.getItems().addAll(forHourArray);
        }
        forHour.setValue(value);
    }
    private void setMinuteBasedOnHour(Integer hour, ChoiceBox<Integer> forMinute, Integer value) {
        forMinute.getItems().clear();
        if (LocalTime.now().getHour() == hour) {
            Integer[] forMinuteArray = new Integer[(60 - LocalTime.now().getMinute())];
            int arrayIndex = 0;
            for (int i = LocalTime.now().getMinute(); i < 60; i++) {
                forMinuteArray[arrayIndex] = i;
                arrayIndex++;
            }
            forMinute.getItems().addAll(forMinuteArray);
        }
        else {
            Integer[] forMinuteArray = new Integer[60];
            for (int i = 0; i < 60; i++) {
                forMinuteArray[i] = i;
            }
            forMinute.getItems().addAll(forMinuteArray);
        }
        forMinute.setValue(value);
    }

    public void showHourForDateIn(ActionEvent actionEvent) {
        setHourBasedOnDate(choiceboxRoomDateInDateRR.getValue(), choiceboxRoomDateInHourRR, choiceboxRoomDateInHourRR.getValue());
    }
    public void showHourForDateOut(ActionEvent actionEvent) {
        setHourBasedOnDate(choiceboxRoomDateOutDateRR.getValue(), choiceboxRoomDateOutHourRR, choiceboxRoomDateOutHourRR.getValue());
    }
    public void mouseEntered(javafx.scene.input.MouseEvent mouseEvent) {
        setMinuteBasedOnHour(choiceboxRoomDateInHourRR.getSelectionModel().getSelectedItem(), choiceboxRoomDateInMinuteRR, choiceboxRoomDateInMinuteRR.getValue());
        setMinuteBasedOnHour(choiceboxRoomDateOutHourRR.getSelectionModel().getSelectedItem(), choiceboxRoomDateOutMinuteRR, choiceboxRoomDateOutMinuteRR.getValue());
        setInfoForOldCustomer();
        reloadRoomAvailabilityClicked();
    }
}