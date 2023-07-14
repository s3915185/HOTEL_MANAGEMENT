package com.example.hotelmanagement.actionControllers.CheckIn;

import com.example.hotelmanagement.DatabaseConnection;
import com.example.hotelmanagement.Main;
import com.example.hotelmanagement.Objects.PaymentInformation;
import com.example.hotelmanagement.Objects.RoomInformation;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

public class CheckInController implements Initializable {

    @FXML
    private TextField balance;

    @FXML
    private TextField changes;


    @FXML
    private ChoiceBox<String> choiceboxAdultsRR;
    private String[] adultsRR = {"1", "2", "3", "4", "5", "6", "7"};


    @FXML
    private ChoiceBox<String> choiceboxChildrensRR;
    private String[] childrensRR = {"0", "1", "2", "3", "4", "5", "6", "7"};

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
    private TextField firstPay;

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

    @FXML
    private TableView<PaymentInformation> paidList;
    @FXML
    private TableColumn<PaymentInformation, Integer> paymentID;
    @FXML
    private TableColumn<PaymentInformation, Double> amount;
    @FXML
    private TableColumn<PaymentInformation, Date> date;
    @FXML
    private TableColumn<PaymentInformation, Integer> signature;



    @FXML
    private TextField choiceboxRoomNumberRI;
    @FXML
    private TextField choiceboxDateInDateRI;
    @FXML
    private TextField choiceboxDateInTimeRI;
    @FXML
    private TextField choiceboxDateOutDateRI;
    @FXML
    private TextField choiceboxDateOutTimeRI;
    @FXML
    private TextField choiceboxAdultsRI;
    @FXML
    private TextField choiceboxChildrensRI;
    @FXML
    private TextField choiceboxRoomTypeRI;
    @FXML
    private TextField discountPercentConverted;


    @FXML
    private ImageView paymentDirectBtn;





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
        int currentCheckerID = Main.getIDcurrentGuest();
        int hourIn = choiceboxRoomDateInHourRR.getValue();
        int minuteIn = choiceboxRoomDateInMinuteRR.getValue();
        int hourOut = choiceboxRoomDateOutHourRR.getValue();
        int minuteOut = choiceboxRoomDateOutMinuteRR.getValue();
        LocalDate dateIn = choiceboxRoomDateInDateRR.getValue();
        LocalDate dateOut = choiceboxRoomDateOutDateRR.getValue();

        String timeIn = dateIn + " " + hourIn + ":" + minuteIn + ":00";
        String timeOut = dateOut + " " + hourOut + ":" + minuteOut + ":00";
        Main.loadSpecificSelectedRoom(roomType, timeIn, timeOut);
        displayRoomAvailability();
        rollingAnimation(reloadRoomAvailability);
        if (Main.getRandomObject() != null) {
            addResClicked();
            Main.setRandomObject(null);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (choiceboxRoomTypeRR != null) {
            choiceboxRoomTypeRR.getItems().addAll(roomType);
            choiceboxRoomTypeRR.setValue(roomType[0]);
            choiceboxAdultsRR.getItems().addAll(adultsRR);
            choiceboxAdultsRR.setValue(adultsRR[0]);
            choiceboxChildrensRR.getItems().addAll(childrensRR);
            choiceboxChildrensRR.setValue(childrensRR[0]);
            Main.loadRoomData(null);
            displayRoomAvailability();
            DateTimeInitializer(choiceboxRoomDateInDateRR, choiceboxRoomDateInHourRR, choiceboxRoomDateInMinuteRR);
            DateTimeInitializer(choiceboxRoomDateOutDateRR, choiceboxRoomDateOutHourRR, choiceboxRoomDateOutMinuteRR);
            setHourBasedOnDate(choiceboxRoomDateInDateRR.getValue(), choiceboxRoomDateInHourRR, choiceboxRoomDateInHourRR.getValue());
            setHourBasedOnDate(choiceboxRoomDateOutDateRR.getValue(), choiceboxRoomDateOutHourRR, choiceboxRoomDateOutHourRR.getValue());
        }
    }


    private static void rollingAnimation(ImageView icon) {
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
            Integer[] forMinuteArray = new Integer[(60 - LocalTime.now().getMinute()) / 15];
            int arrayIndex = 0;
            for (int i = LocalTime.now().getMinute(); i < 60; i++) {
                if ((i % 15 == 0)) {
                    forMinuteArray[arrayIndex] = i;
                    arrayIndex++;
                }
            }
            forMinute.getItems().addAll(forMinuteArray);
        }
        else {
            Integer[] forMinuteArray = new Integer[4];
            forMinuteArray[0] = 0;
            forMinuteArray[1] = 15;
            forMinuteArray[2] = 30;
            forMinuteArray[3] = 45;
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

    public void roomSelected(MouseEvent mouseEvent) {
        TableView tableView = (TableView) mouseEvent.getSource();
        ObservableList<RoomInformation> roomSelected = tableView.getSelectionModel().getSelectedItems();
        if (mouseEvent.getClickCount() == 2) {
            showRoomInformation(roomSelected.get(0).getRoom_ID());
            //loadPaymentHistory(roomSelected.get(0).getRoom_ID());
            paymentID.setCellValueFactory(new PropertyValueFactory<>("payment_ID"));
            amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
            date.setCellValueFactory(new PropertyValueFactory<>("payment_date"));
            signature.setCellValueFactory(new PropertyValueFactory<>("customer_ID"));
            paidList.setItems(getPaymentDataObjectList());
        }
    }
    private void showRoomInformation(Integer roomID) {
        discountPercent.setText("10");
        for (RoomInformation object : Main.getRoomData()) {
            if (object.getRoom_ID() == roomID) {
                choiceboxRoomNumberRI.setText(String.valueOf(object.getRoom_number()));
                choiceboxDateInDateRI.setText(String.valueOf(choiceboxRoomDateInDateRR.getValue()));
                choiceboxDateInTimeRI.setText(choiceboxRoomDateInHourRR.getValue() + ": " + choiceboxRoomDateInMinuteRR.getValue());
                choiceboxDateOutDateRI.setText(String.valueOf(choiceboxRoomDateOutDateRR.getValue()));
                choiceboxDateOutTimeRI.setText(choiceboxRoomDateOutHourRR.getValue() + ": " + choiceboxRoomDateOutMinuteRR.getValue());
                choiceboxAdultsRI.setText(String.valueOf(choiceboxAdultsRR.getValue()));
                choiceboxChildrensRI.setText(String.valueOf(choiceboxChildrensRR.getValue()));
                choiceboxRoomTypeRI.setText(object.getRoom_type());
                roomCharges.setText(String.valueOf(object.getRoom_price()));
                choiceboxRoomNumberRI.setEditable(false);
                choiceboxDateInDateRI.setEditable(false);
                choiceboxDateInTimeRI.setEditable(false);
                choiceboxDateOutDateRI.setEditable(false);
                choiceboxDateOutTimeRI.setEditable(false);
                choiceboxAdultsRI.setEditable(false);
                choiceboxChildrensRI.setEditable(false);
                choiceboxRoomTypeRI.setEditable(false);
                roomCharges.setEditable(false);
                roomID = object.getRoom_ID();
                double discount = Double.parseDouble(discountPercent.getText()) * object.getRoom_price() / 100;
                discountPercentConverted.setText(String.valueOf(discount));
                discountPercentConverted.setEditable(false);
                serviceCharges.setText("0");
                changes.setText("0");
                grandTotal.setText(String.valueOf(object.getRoom_price() - discount));
                grandTotal.setEditable(false);
                firstPay.setText("0");
                balance.setText(grandTotal.getText());
                balance.setEditable(false);
            }
        }
    }
    public void mouseEntered(javafx.scene.input.MouseEvent mouseEvent) {
        if (choiceboxRoomDateInHourRR != null) {
            setMinuteBasedOnHour(choiceboxRoomDateInHourRR.getSelectionModel().getSelectedItem(), choiceboxRoomDateInMinuteRR, choiceboxRoomDateInMinuteRR.getValue());
            setMinuteBasedOnHour(choiceboxRoomDateOutHourRR.getSelectionModel().getSelectedItem(), choiceboxRoomDateOutMinuteRR, choiceboxRoomDateOutMinuteRR.getValue());
            setInfoForOldCustomer();
            reloadRoomAvailabilityClicked();
        }
    }

    public void keyPressed() {
        if (discountPercent.getText().equals("")) {
            discountPercent.setText("0");
        }
        double discount = Double.parseDouble(discountPercent.getText()) * Double.parseDouble(roomCharges.getText()) / 100;
        discountPercentConverted.setText(String.valueOf(discount));
        grandTotal.setText(String.valueOf(Double.parseDouble(roomCharges.getText()) - Double.parseDouble(discountPercentConverted.getText())));
        balance.setText(String.valueOf(Double.parseDouble(grandTotal.getText().toString()) - Double.parseDouble(firstPay.getText().toString())));

    }

    public void addResClicked() {
        System.out.println("Went to Add REs");
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();

            int hourIn = choiceboxRoomDateInHourRR.getValue();
            int minuteIn = choiceboxRoomDateInMinuteRR.getValue();
            int hourOut = choiceboxRoomDateOutHourRR.getValue();
            int minuteOut = choiceboxRoomDateOutMinuteRR.getValue();
            LocalDate dateIn = choiceboxRoomDateInDateRR.getValue();
            LocalDate dateOut = choiceboxRoomDateOutDateRR.getValue();

            String timeIn = dateIn + " " + hourIn + ":" + minuteIn + ":00";
            String timeOut = dateOut + " " + hourOut + ":" + minuteOut + ":00";

            System.out.println("Time In: " + timeIn);
            System.out.println("Time Out: " + timeOut);

            for (RoomInformation room : Main.getRoomData()) {
                if (room.getRoom_number() == Integer.valueOf(choiceboxRoomNumberRI.getText())) {
                    String connectQuery = "INSERT INTO reservation (room_ID, date_in, date_out, customer_ID) VALUES " +
                            "(?,?,?,?); ";
                    PreparedStatement preparedStatement = connectDB.prepareStatement(connectQuery);
                    preparedStatement.setInt(1, room.getRoom_ID());
                    preparedStatement.setString(2, timeIn);
                    preparedStatement.setString(3, timeOut);
                    preparedStatement.setInt(4, Main.getIDcurrentGuest());
                    preparedStatement.execute();
                    break;
                }
            }

            String secondQuery = "insert into hotelmanagement.payment (customer_ID, payment_date, amount, reservation_ID, payment_type)\n" +
                    "values (?, ?, ?, \n" +
                    "(SELECT reservation_ID FROM hotelmanagement.reservation ORDER BY reservation_ID DESC LIMIT 0, 1)\n" +
                    ", ?);";
            PreparedStatement preparedStatementSecond = connectDB.prepareStatement(secondQuery);
            preparedStatementSecond.setInt(1, PaymentInformation.class.cast(Main.getRandomObject()).getCustomer_ID());
            preparedStatementSecond.setString(2, PaymentInformation.class.cast(Main.getRandomObject()).getPayment_date() + " " +
                    PaymentInformation.class.cast(Main.getRandomObject()).getPayment_time());
            preparedStatementSecond.setDouble(3, Double.parseDouble(firstPay.getText()));
            preparedStatementSecond.setString(4, PaymentInformation.class.cast(Main.getRandomObject()).getPaymentType());
            preparedStatementSecond.execute();
            rollingAnimation(customerAdd);
            Main.loadUserData();
            Main.loadRoomReservation();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void paymentDirectBtnClicked() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/hotelmanagement/actionFXMLs/CheckIn/Payment_Information.fxml"));
            Parent paymentInfoQR = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(paymentInfoQR));
            stage.setTitle("Scan Payment");
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ObservableList<PaymentInformation> paymentDataObjectList = FXCollections.observableArrayList();
    /*
    public void loadPaymentHistory(Integer roomID) {
        if (paymentDataObjectList != null) {
            paymentDataObjectList.clear();
        }
        int currentCheckerID = Main.getIDcurrentGuest();
        int hourIn = choiceboxRoomDateInHourRR.getValue();
        int minuteIn = choiceboxRoomDateInMinuteRR.getValue();
        int hourOut = choiceboxRoomDateOutHourRR.getValue();
        int minuteOut = choiceboxRoomDateOutMinuteRR.getValue();
        LocalDate dateIn = choiceboxRoomDateInDateRR.getValue();
        LocalDate dateOut = choiceboxRoomDateOutDateRR.getValue();

        String timeIn = dateIn + " " + hourIn + ":" + minuteIn + ":00";
        String timeOut = dateOut + " " + hourOut + ":" + minuteOut + ":00";

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String connectQuery = "SELECT p.payment_ID as payment_ID, p.customer_ID as customer_ID, r.room_ID as room_ID, r.reservation_ID as reservation_ID, p.payment_date as payment_date, p.amount as amount" +
                " FROM Reservation r, Payment p" +
                " WHERE r.reservation_ID = p.reservation_ID" +
               " AND p.customer_ID = " + currentCheckerID + " " +
                " AND r.room_ID = " + roomID + " ";
//                "AND r.date_in = " + timeIn + " " +
//                "AND r.date_out = " + timeOut +"";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet outputQuery = statement.executeQuery(connectQuery);

            while (outputQuery.next()) {
                paymentDataObjectList.add(new PaymentInformation(outputQuery.getInt("payment_ID"),
                        outputQuery.getInt("customer_ID"),
                        outputQuery.getDate("payment_date"),
                        outputQuery.getInt("reservation_ID"), outputQuery.getDouble("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     */
    public static ObservableList<PaymentInformation> getPaymentDataObjectList() {
        return paymentDataObjectList;
    }

    public void addResClicked(MouseEvent mouseEvent) {
    }
}