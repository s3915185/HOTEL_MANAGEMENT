package com.example.hotelmanagement.actionControllers.RoomReservation;

import com.example.hotelmanagement.DatabaseConnection;
import com.example.hotelmanagement.Main;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.util.Duration;


import java.lang.reflect.Field;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class RoomReservationController implements Initializable{

    @FXML
    private VBox sun_1;
    @FXML
    private VBox mon_2;
    @FXML
    private VBox tue_3;
    @FXML
    private VBox wed_4;
    @FXML
    private VBox thu_5;
    @FXML
    private VBox fri_6;
    @FXML
    private VBox sat_7;
    @FXML
    private VBox sun_8;
    @FXML
    private VBox mon_9;
    @FXML
    private VBox tue_10;
    @FXML
    private VBox wed_11;
    @FXML
    private VBox thu_12;
    @FXML
    private VBox fri_13;
    @FXML
    private VBox sat_14;
    @FXML
    private VBox sun_15;
    @FXML
    private VBox mon_16;
    @FXML
    private VBox tue_17;
    @FXML
    private VBox wed_18;
    @FXML
    private VBox thu_19;
    @FXML
    private VBox fri_20;
    @FXML
    private VBox sat_21;
    @FXML
    private VBox sun_22;
    @FXML
    private VBox mon_23;
    @FXML
    private VBox tue_24;
    @FXML
    private VBox wed_25;
    @FXML
    private VBox thu_26;
    @FXML
    private VBox fri_27;
    @FXML
    private VBox sat_28;
    @FXML
    private VBox sun_29;
    @FXML
    private VBox mon_30;
    @FXML
    private VBox tue_31;
    @FXML
    private VBox wed_32;
    @FXML
    private VBox thu_33;
    @FXML
    private VBox fri_34;
    @FXML
    private VBox sat_35;
    @FXML
    private VBox sun_36;
    @FXML
    private VBox mon_37;
    @FXML
    private VBox tue_38;
    @FXML
    private VBox wed_39;
    @FXML
    private VBox thu_40;
    @FXML
    private VBox fri_41;
    @FXML
    private VBox sat_42;

    @FXML
    private HBox firstBadge;

    @FXML
    private Text sun__1;
    @FXML
    private Text mon__2;
    @FXML
    private Text tue__3;
    @FXML
    private Text wed__4;
    @FXML
    private Text thu__5;
    @FXML
    private Text fri__6;
    @FXML
    private Text sat__7;
    @FXML
    private Text sun__8;
    @FXML
    private Text mon__9;
    @FXML
    private Text tue__10;
    @FXML
    private Text wed__11;
    @FXML
    private Text thu__12;
    @FXML
    private Text fri__13;
    @FXML
    private Text sat__14;
    @FXML
    private Text sun__15;
    @FXML
    private Text mon__16;
    @FXML
    private Text tue__17;
    @FXML
    private Text wed__18;
    @FXML
    private Text thu__19;
    @FXML
    private Text fri__20;
    @FXML
    private Text sat__21;
    @FXML
    private Text sun__22;
    @FXML
    private Text mon__23;
    @FXML
    private Text tue__24;
    @FXML
    private Text wed__25;
    @FXML
    private Text thu__26;
    @FXML
    private Text fri__27;
    @FXML
    private Text sat__28;
    @FXML
    private Text sun__29;
    @FXML
    private Text mon__30;
    @FXML
    private Text tue__31;
    @FXML
    private Text wed__32;
    @FXML
    private Text thu__33;
    @FXML
    private Text fri__34;
    @FXML
    private Text sat__35;
    @FXML
    private Text sun__36;
    @FXML
    private Text mon__37;
    @FXML
    private Text tue__38;
    @FXML
    private Text wed__39;
    @FXML
    private Text thu__40;
    @FXML
    private Text fri__41;
    @FXML
    private Text sat__42;

    private int[][] dayCalendarMap = new int[6][7];
    private String[][] dayFormatCalendarMap = new String[6][7];
    private ObservableList[][] dayTasks = new ObservableList[6][7];
    private String[][] calendarPaneColor = new String[6][7];
    private String[][] paneName = {{"sun_1", "mon_2", "tue_3", "wed_4", "thu_5", "fri_6", "sat_7"},
                                    {"sun_8", "mon_9", "tue_10", "wed_11", "thu_12", "fri_13", "sat_14"},
                                   {"sun_15", "mon_16", "tue_17", "wed_18", "thu_19", "fri_20", "sat_21"},
                                     {"sun_22", "mon_23", "tue_24", "wed_25", "thu_26", "fri_27", "sat_28"},
                                      {"sun_29", "mon_30", "tue_31", "wed_32", "thu_33", "fri_34", "sat_35"},
                                   {"sun_36", "mon_37", "tue_38", "wed_39", "thu_40", "fri_41", "sat_42"},
    };

    private Pane[] myPane;
    private Pane[] colorband;
    private Text[] roomNumberText;
    private Pane[] calendarPane;

    private Field[] fields;

    @FXML
    private Pane cardPane;
    @FXML
    private VBox cardPaneVBox;

    @FXML
    private DatePicker monthPicker;

    @FXML
    private TilePane tilePaneDirections;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LocalDate localDate = LocalDate.now();
        monthPicker.setValue(localDate);
        for(int a = 0; a < 6; a++) {
            for (int b = 0; b < 7; b++) {
                dayCalendarMap[a][b] = 0;
                dayFormatCalendarMap[a][b] = "none";
                dayTasks[a][b] = FXCollections.observableArrayList();
                calendarPaneColor[a][b] = "#fff1f1";
            }
        }
        fields = this.getClass().getDeclaredFields();
        try {
            daySelected();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        cardPane.setVisible(false);
        cardPane.setOnMouseClicked(mouseEvent -> {
            cardPane.setVisible(false);
        });
    }




    public void daySelected() throws IllegalAccessException {
        clearVboxForCalendarPane();
        tilePaneDirections.getChildren().clear();
        dayTasksClear();

        String value = monthPicker.getValue().toString();
        String year = value.split("-")[0];
        String month = value.split("-")[1];
        String date = year + "-" + month + "-" + "01";
        LocalDate localDateFromOne = LocalDate.parse(date);
        LocalDate previousDate = localDateFromOne.minusDays(1);

        int dayValue = 0;

        if (localDateFromOne.getDayOfWeek().toString().equals("MONDAY")) {
            dayValue = 2;
        }
        else if (localDateFromOne.getDayOfWeek().toString().equals("TUESDAY")) {
            dayValue = 3;
        }
        else if (localDateFromOne.getDayOfWeek().toString().equals("WEDNESDAY")) {
            dayValue = 4;
        }
        else if (localDateFromOne.getDayOfWeek().toString().equals("THURSDAY")) {
            dayValue = 5;
        }
        else if (localDateFromOne.getDayOfWeek().toString().equals("FRIDAY")) {
            dayValue = 6;
        }
        else if (localDateFromOne.getDayOfWeek().toString().equals("SATURDAY")) {
            dayValue = 7;
        }
        else {
            dayValue = 1;
        }

        int row = 0;
        int column = dayValue;

        for (int y = column - 2; y >= 0; y--) {
            dayCalendarMap[row][y] = previousDate.getDayOfMonth();
            dayFormatCalendarMap[row][y] = previousDate.toString();
            calendarPaneColor[row][y] = "#dddddd";
            previousDate = previousDate.minusDays(1);
        }


        for (int i = 1; i <= monthPicker.getValue().withDayOfMonth(monthPicker.getValue().getMonth().length(monthPicker.getValue().isLeapYear())).getDayOfMonth(); i++) {
            if (column - 1 == 7) {
                row++;
                column = 1;
            }
            dayCalendarMap[row][column - 1] = i;
            dayFormatCalendarMap[row][column - 1] = localDateFromOne.toString();
            calendarPaneColor[row][column - 1] = "#fff1f1";
            localDateFromOne = localDateFromOne.plusDays(1);
            column++;
        }
        for (int x = 1; x <= 14; x++) {
            if (column - 1 == 7) {
                row++;
                column = 1;
            }
            if (row == 6) {
                break;
            }
            dayCalendarMap[row][column - 1] = x;
            dayFormatCalendarMap[row][column - 1] = localDateFromOne.toString();
            calendarPaneColor[row][column - 1] = "#dddddd";
            localDateFromOne = localDateFromOne.plusDays(1);
            column++;
        }

        for (int a = 0; a < 6; a++) {
            for (int b = 0; b <7; b++) {
                boolean clearObject = false;
                Object tempObj = null;
                Object tempObj2 = null;
                for (Object object : dayTasks[a][b]) {
                    if (object.getClass() == Label.class) {
                        clearObject = true;
                        tempObj = object;
                    }
                    if (object.getClass() == Text.class) {
                        tempObj2 = object;
                    }
                }
                if (clearObject) {
                    dayTasks[a][b].remove(tempObj);
                    dayTasks[a][b].remove(tempObj2);
                }
                dayTasks[a][b].add(new Text(String.valueOf(dayCalendarMap[a][b])));
                dayTasks[a][b].add(new Label("No Reservation"));
                if (LocalDate.parse(dayFormatCalendarMap[a][b]).compareTo(LocalDate.parse(monthPicker.getValue().toString())) == 0) {
                    calendarPaneColor[a][b] = "#ccceee";
                }
            }
        }



        loadReservationArraySize(dayFormatCalendarMap[0][0], dayFormatCalendarMap[5][6]);
        loadReservationWithMonth(dayFormatCalendarMap[0][0], dayFormatCalendarMap[5][6]);

        loadDayTasks();
    }

    public void loadReservationArraySize(String firstDate, String lastDate) {
        if (myPane != null) {
            myPane = null;
        }

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        int index = 0;


        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery("SELECT COUNT(*) as count FROM (" +
                    "SELECT room_ID, date_in, date_out, customer_ID as count FROM hotelmanagement.reservation " +
                    "                    WHERE date_in BETWEEN '"+ firstDate +"%' AND '"+ lastDate + "%' " +
                    "                    OR date_out BETWEEN '"+ firstDate +"%' AND '"+ lastDate + "%'" +
                    "                    OR '"+ firstDate +"%' BETWEEN date_in AND date_out " +
                    "                    OR '"+ lastDate + "%' BETWEEN date_in AND date_out" +
                    ") as T");
            while (queryOutput.next()) {
                myPane = new Pane[queryOutput.getInt("count")];
                colorband = new Pane[queryOutput.getInt("count")];
                roomNumberText = new Text[queryOutput.getInt("count")];
                calendarPane = new Pane[queryOutput.getInt("count")];
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void loadReservationWithMonth(String firstDate, String lastDate) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        int index = 0;
        String connectQuery = "SELECT RE.room_ID as room_ID, RE.date_in as date_in, RE.date_out as date_out, RE.customer_ID as customer_ID, RO.roomNumber as roomNumber\n" +
                "FROM hotelmanagement.room RO, (SELECT room_ID, date_in, date_out, customer_ID FROM hotelmanagement.reservation\n" +
                "WHERE date_in BETWEEN '"+ firstDate + "%' AND '" + lastDate+ "%'" +
                "OR date_out BETWEEN '"+ firstDate + "%' AND '" + lastDate+ "%'" +
                "OR '"+ firstDate + "%' BETWEEN date_in AND date_out " +
                "OR '" + lastDate+ "%' BETWEEN date_in AND date_out) as RE " +
                "WHERE RE.room_ID = RO.room_ID";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);
            while (queryOutput.next()) {
                int calendarPaneColorHeight = 10;
                int calendarPaneColorWidth = 110;
                Color randomColor = Color.color(Math.random(), Math.random(), Math.random());
                myPane[index] = new Pane();
                myPane[index].setPrefWidth(30);
                myPane[index].setPrefHeight(15);

                calendarPane[index] = new Pane();
                calendarPane[index].setPrefHeight(calendarPaneColorHeight);
                calendarPane[index].setPrefWidth(calendarPaneColorWidth);
                calendarPane[index].setBackground(new Background(new BackgroundFill(randomColor, CornerRadii.EMPTY, Insets.EMPTY)));
                calendarPane[index].setBorder(new Border(new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

                colorband[index] = new Pane();
                colorband[index].setPrefSize(15, 15);
                colorband[index].setBackground(new Background(new BackgroundFill(randomColor, CornerRadii.EMPTY, Insets.EMPTY)));

                roomNumberText[index] = new Text(String.valueOf(queryOutput.getInt("roomNumber")));
                myPane[index].getChildren().addAll(colorband[index], roomNumberText[index]);
                tilePaneDirections.getChildren().add(myPane[index]);

                if (LocalDate.parse(queryOutput.getString("date_in").split(" ")[0]).compareTo(LocalDate.parse(dayFormatCalendarMap[0][0])) <= 0 &&
                LocalDate.parse(queryOutput.getString("date_out").split(" ")[0]).compareTo(LocalDate.parse(dayFormatCalendarMap[5][6])) >= 0) {
                    for (int a = 0; a < 6; a++) {
                        for (int b = 0; b < 7;b++) {
                            cleanLabels(a, b);
                            dayTasks[a][b].add(createNewPane(queryOutput.getInt("roomNumber"), index, randomColor, calendarPaneColorWidth, calendarPaneColorHeight,
                                    a, b));
                        }
                    }

                }
                // DATE IN - WITHIN BUT DATE OUT - OUT RANGE
                else if (LocalDate.parse(queryOutput.getString("date_in").split(" ")[0]).compareTo(LocalDate.parse(dayFormatCalendarMap[0][0])) > 0 &&
                        LocalDate.parse(queryOutput.getString("date_out").split(" ")[0]).compareTo(LocalDate.parse(dayFormatCalendarMap[5][6])) >= 0) {
                    boolean toBreakLoop = false;
                    int x = 0, y= 0;
                    for (int a = 0; a < 6; a++) {
                        for (int b = 0; b < 7; b++) {
                            if (LocalDate.parse(dayFormatCalendarMap[a][b]).compareTo(LocalDate.parse(queryOutput.getString("date_in").split(" ")[0])) == 0) {
                                x = a; y = b;
                                toBreakLoop = true;
                                break;
                            }
                        }
                        if (toBreakLoop) {
                            break;
                        }
                    }
                    boolean firstLoop = true;
                    for (int m = x; m < 6; m++) {
                        if (firstLoop) {
                            for (int n = y; n < 7; n++) {
                                cleanLabels(m, n);
                                dayTasks[m][n].add(createNewPane(queryOutput.getInt("roomNumber"), index, randomColor, calendarPaneColorWidth, calendarPaneColorHeight,
                                        m, n));
                            }
                            firstLoop = false;
                        }
                        else {
                            for (int n = 0; n < 7; n++) {
                                cleanLabels(m, n);
                                dayTasks[m][n].add(createNewPane(queryOutput.getInt("roomNumber"), index, randomColor, calendarPaneColorWidth, calendarPaneColorHeight,
                                        m, n));
                            }
                        }
                    }
                }

                // DATE IN - OUT RANGE BUT DATE OUT - WITHIN
                else if (LocalDate.parse(queryOutput.getString("date_in").split(" ")[0]).compareTo(LocalDate.parse(dayFormatCalendarMap[0][0])) <= 0 &&
                        LocalDate.parse(queryOutput.getString("date_out").split(" ")[0]).compareTo(LocalDate.parse(dayFormatCalendarMap[5][6])) < 0) {
                    boolean toBreakOut = false;
                    for (int a = 0; a < 6; a++) {
                        for (int b = 0; b < 7; b++) {
                            if (LocalDate.parse(dayFormatCalendarMap[a][b]).compareTo(LocalDate.parse(queryOutput.getString("date_out").split(" ")[0])) == 0) {
                                cleanLabels(a, b);
                                dayTasks[a][b].add(createNewPane(queryOutput.getInt("roomNumber"), index, randomColor, calendarPaneColorWidth, calendarPaneColorHeight,
                                        a, b));
                                toBreakOut = true;
                                break;
                            }
                            cleanLabels(a, b);
                            dayTasks[a][b].add(createNewPane(queryOutput.getInt("roomNumber"), index, randomColor, calendarPaneColorWidth, calendarPaneColorHeight,
                                    a, b));
                        }
                        if (toBreakOut) {
                            break;
                        }
                    }
                }


                // DATE IN - WITHIN AND DATE OUT - WITHIN
                else if (LocalDate.parse(queryOutput.getString("date_in").split(" ")[0]).compareTo(LocalDate.parse(dayFormatCalendarMap[0][0])) >= 0 &&
                        LocalDate.parse(queryOutput.getString("date_out").split(" ")[0]).compareTo(LocalDate.parse(dayFormatCalendarMap[5][6])) <= 0) {
                    int x = 0, y= 0;
                    boolean toBreakLoop1 = false;
                    for (int a = 0; a < 6; a++) {
                        for (int b = 0; b < 7; b++) {
                            if (LocalDate.parse(dayFormatCalendarMap[a][b]).compareTo(LocalDate.parse(queryOutput.getString("date_in").split(" ")[0])) == 0) {
                                x = a; y = b;
                                toBreakLoop1 = true;
                                break;
                            }
                        }
                        if (toBreakLoop1) {
                            break;
                        }
                    }
                    boolean toBreakLoop2 = false;
                    boolean firstLoop = true;
                    for (int m = x; m < 6; m++) {
                        if (firstLoop) {
                            for (int n = y; n < 7; n++) {
                                if (LocalDate.parse(dayFormatCalendarMap[m][n]).compareTo(LocalDate.parse(queryOutput.getString("date_out").split(" ")[0])) == 0) {
                                    toBreakLoop2 = true;
                                    cleanLabels(m, n);
                                    dayTasks[m][n].add(createNewPane(queryOutput.getInt("roomNumber"), index, randomColor, calendarPaneColorWidth, calendarPaneColorHeight,
                                            m, n));
                                    break;
                                }
                                cleanLabels(m, n);
                                dayTasks[m][n].add(createNewPane(queryOutput.getInt("roomNumber"), index, randomColor, calendarPaneColorWidth, calendarPaneColorHeight,
                                        m, n));
                            }
                            firstLoop = false;
                            if (toBreakLoop2) {
                                break;
                            }
                        }
                        else {
                            for (int n = 0; n < 7; n++) {
                                if (LocalDate.parse(dayFormatCalendarMap[m][n]).compareTo(LocalDate.parse(queryOutput.getString("date_out").split(" ")[0])) == 0) {
                                    toBreakLoop2 = true;
                                    cleanLabels(m, n);
                                    dayTasks[m][n].add(createNewPane(queryOutput.getInt("roomNumber"), index, randomColor, calendarPaneColorWidth, calendarPaneColorHeight,
                                            m, n));
                                    break;
                                }
                                cleanLabels(m, n);
                                dayTasks[m][n].add(createNewPane(queryOutput.getInt("roomNumber"), index, randomColor, calendarPaneColorWidth, calendarPaneColorHeight,
                                        m, n));
                            }
                            if (toBreakLoop2) {
                                break;
                            }
                        }
                    }
                }

                index++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void cleanLabels(int a, int b) {
        boolean clearObject = false;
        Object tempObj = null;
        for (Object obserb : dayTasks[a][b]) {
            if (obserb instanceof Label) {
                clearObject = true;
                tempObj = obserb;
            }
        }
        if (clearObject) {
            dayTasks[a][b].remove(tempObj);
        }
    }

    public Pane createNewPane(int roomNumber, int index, Color randomColor, int paneWidth, int paneHeight, int a, int b) {
        Pane newPane = new Pane();
        newPane.setPrefHeight(paneHeight);
        newPane.setPrefWidth(paneWidth);
        newPane.setBackground(new Background(new BackgroundFill(randomColor, CornerRadii.EMPTY, Insets.EMPTY)));
        newPane.cursorProperty().set(Cursor.HAND);
        newPane.setId(roomNumber + "_"+ a +"_" + b);
        int finalIndex1 = index;
        newPane.setOnMouseClicked(mouseEvent -> {
            HBox hBox = new HBox();
            Text roomNumberTextString = new Text(roomNumberText[finalIndex1].getText());
            ImageView roomImage = new ImageView();
            roomImage.setImage(new Image("file:src/main/resources/images/logo/"+roomNumberTextString.getText().substring(0, 1) + "_type.jpg"));
            hBox.getChildren().addAll(roomImage, roomNumberTextString);

            if (cardPaneVBox.getChildren().size() != 0) {
                cardPaneVBox.getChildren().clear();
            }
            cardPaneVBox.getChildren().add(hBox);
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5));
            fadeTransition.setNode(cardPane);
            fadeTransition.setFromValue(0.1);
            fadeTransition.setToValue(1);
            fadeTransition.play();
            cardPane.setVisible(true);
            System.out.println(newPane.getId());
        });
        return newPane;
    }
    public void loadDayTasks() throws IllegalAccessException {
        int index1 = 0;
        int index2 = 0;
        Object object = this;
        for (Field field : fields) {
            field.setAccessible(true);
            if (index2 % 7 == 0 && index2 != 0) {
                index1++;
                index2 = 0;
            }
            if (field.get(object) instanceof VBox && field.getName().substring(3, 4).equals("_")) {
                VBox vBox = (VBox) field.get(object);
                vBox.getChildren().addAll(dayTasks[index1][index2]);
                vBox.setBackground(new Background(new BackgroundFill(Paint.valueOf(calendarPaneColor[index1][index2]), CornerRadii.EMPTY, Insets.EMPTY)));
            }
            index2++;
        }
    }
    public void clearVboxForCalendarPane() {
        sun_1.getChildren().clear();
        mon_2.getChildren().clear();
        tue_3.getChildren().clear();
        wed_4.getChildren().clear();
        thu_5.getChildren().clear();
        fri_6.getChildren().clear();
        sat_7.getChildren().clear();

        sun_8.getChildren().clear();
        mon_9.getChildren().clear();
        tue_10.getChildren().clear();
        wed_11.getChildren().clear();
        thu_12.getChildren().clear();
        fri_13.getChildren().clear();
        sat_14.getChildren().clear();

        sun_15.getChildren().clear();
        mon_16.getChildren().clear();
        tue_17.getChildren().clear();
        wed_18.getChildren().clear();
        thu_19.getChildren().clear();
        fri_20.getChildren().clear();
        sat_21.getChildren().clear();

        sun_22.getChildren().clear();
        mon_23.getChildren().clear();
        tue_24.getChildren().clear();
        wed_25.getChildren().clear();
        thu_26.getChildren().clear();
        fri_27.getChildren().clear();
        sat_28.getChildren().clear();

        sun_29.getChildren().clear();
        mon_30.getChildren().clear();
        tue_31.getChildren().clear();
        wed_32.getChildren().clear();
        thu_33.getChildren().clear();
        fri_34.getChildren().clear();
        sat_35.getChildren().clear();

        sun_36.getChildren().clear();
        mon_37.getChildren().clear();
        tue_38.getChildren().clear();
        wed_39.getChildren().clear();
        thu_40.getChildren().clear();
        fri_41.getChildren().clear();
        sat_42.getChildren().clear();
    }

    public void dayTasksClear() {
        for (int a = 0; a < 6; a++) {
            for (int b = 0; b < 7; b++) {
                dayTasks[a][b].clear();
            }
        }
    }

    public void calendarMouseHover(MouseEvent mouseEvent) {
        try {
            if (mouseEvent.getSource() instanceof VBox) {
                VBox vBox = (VBox) mouseEvent.getSource();
                Object obj = this;

                for (Field field : fields) {
                    int x = 0, y = 0;
                    if (vBox.getId().equals(field.getName())) {
                        if (field.get(obj) instanceof VBox && field.getName().substring(3, 4).equals("_")) {
                            VBox vBox1 = (VBox) field.get(obj);
                            for (int a = 0; a < 6; a++) {
                                for (int b = 0; b < 7; b++) {
                                    if (paneName[a][b].equals(field.getName())) {
                                        x = a;
                                        y = b;
                                    }
                                }
                            }
                            vBox1.setBackground(new Background(new BackgroundFill(Color.web("#fff5ff"), CornerRadii.EMPTY, Insets.EMPTY)));
                            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.1));
                            fadeTransition.setNode(vBox1);
                            fadeTransition.setFromValue(0.1);
                            fadeTransition.setToValue(1);
                            fadeTransition.play();
                            PauseTransition pauseTransition = new PauseTransition(Duration.seconds(0.2));
                            pauseTransition.play();
                            int finalX = x;
                            int finalY = y;
                            pauseTransition.setOnFinished(event -> {
                                vBox1.setBackground(new Background(new BackgroundFill(Color.web(calendarPaneColor[finalX][finalY]), CornerRadii.EMPTY, Insets.EMPTY)));
                            });
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
