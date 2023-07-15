package com.example.hotelmanagement.actionControllers.RoomReservation;

import com.example.hotelmanagement.DatabaseConnection;
import com.example.hotelmanagement.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static com.example.hotelmanagement.Main.randomObjectList;

public class RoomReservationController implements Initializable{

    @FXML
    private DatePicker monthPicker;

    @FXML
    private TilePane tilePaneDirections;

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

    private Pane[] myPane;
    private Pane[] colorband;
    private Text[] roomNumberText;

    private Pane[] calendarPane;


    public void sun__1(int value) {
        this.sun__1.setText(String.valueOf(value));
    }

    public void mon__2(int value) {
        this.mon__2.setText(String.valueOf(value));
    }

    public void tue__3(int value) {
        this.tue__3.setText(String.valueOf(value));
    }

    public void wed__4(int value) {
        this.wed__4.setText(String.valueOf(value));
    }

    public void thu__5(int value) {
        this.thu__5.setText(String.valueOf(value));
    }

    public void fri__6(int value) {
        this.fri__6.setText(String.valueOf(value));
    }

    public void sat__7(Integer value) {
        this.sat__7.setText(String.valueOf(value));
    }

    public void sun__8(Integer value) {
        sun__8.setText(String.valueOf(value));
    }

    public void mon__9(Integer value) {
        mon__9.setText(String.valueOf(value));
    }

    public void tue__10(Integer value) {
        tue__10.setText(String.valueOf(value));
    }

    public void wed__11(Integer value) {
        wed__11.setText(String.valueOf(value));
    }

    public void thu__12(Integer value) {
        thu__12.setText(String.valueOf(value));
    }

    public void fri__13(Integer value) {
        fri__13.setText(String.valueOf(value));
    }

    public void sat__14(Integer value) {
        sat__14.setText(String.valueOf(value));
    }

    public void sun__15(Integer value) {
        sun__15.setText(String.valueOf(value));
    }

    public void mon__16(Integer value) {
        mon__16.setText(String.valueOf(value));
    }

    public void tue__17(Integer value) {
        tue__17.setText(String.valueOf(value));
    }

    public void wed__18(Integer value) {
        wed__18.setText(String.valueOf(value));
    }

    public void thu__19(Integer value) {
        thu__19.setText(String.valueOf(value));
    }

    public void fri__20(Integer value) {
        fri__20.setText(String.valueOf(value));
    }

    public void sat__21(Integer value) {
        sat__21.setText(String.valueOf(value));
    }

    public void sun__22(Integer value) {
        sun__22.setText(String.valueOf(value));
    }

    public void mon__23(Integer value) {
        mon__23.setText(String.valueOf(value));
    }

    public void tue__24(Integer value) {
        tue__24.setText(String.valueOf(value));
    }

    public void wed__25(Integer value) {
        wed__25.setText(String.valueOf(value));
    }

    public void thu__26(Integer value) {
        thu__26.setText(String.valueOf(value));
    }

    public void fri__27(Integer value) {
        fri__27.setText(String.valueOf(value));
    }

    public void sat__28(Integer value) {
        sat__28.setText(String.valueOf(value));
    }


    public void sun__29(Integer value) {
        sun__29.setText(String.valueOf(value));
    }

    public void mon__30(Integer value) {
        mon__30.setText(String.valueOf(value));
    }

    public void tue__31(Integer value) {
        tue__31.setText(String.valueOf(value));
    }

    public void wed__32(Integer value) {
        wed__32.setText(String.valueOf(value));
    }

    public void thu__33(Integer value) {
        thu__33.setText(String.valueOf(value));
    }

    public void fri__34(Integer value) {
        fri__34.setText(String.valueOf(value));
    }

    public void sat__35(Integer value) {
        sat__35.setText(String.valueOf(value));
    }

    public void sun__36(Integer value) {
        sun__36.setText(String.valueOf(value));
    }

    public void mon__37(Integer value) {
        mon__37.setText(String.valueOf(value));
    }

    public void tue__38(Integer value) {
        tue__38.setText(String.valueOf(value));
    }

    public void wed__39(Integer value) {
        wed__39.setText(String.valueOf(value));
    }

    public void thu__40(Integer value) {
        thu__40.setText(String.valueOf(value));
    }

    public void fri__41(Integer value) {
        fri__41.setText(String.valueOf(value));
    }

    public void sat__42(Integer value) {
        sat__42.setText(String.valueOf(value));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LocalDate localDate = LocalDate.now();
        monthPicker.setValue(localDate);
        if (this.sat__7 == null) {
            System.out.println("Its null in init");
        }
            daySelected();
        for(int a = 0; a < 6; a++) {
            for (int b = 0; b < 7; b++) {
                dayCalendarMap[a][b] = 0;
                dayFormatCalendarMap[a][b] = "none";
            }
        }
    }



    public void daySelected(){

        String value = monthPicker.getValue().toString();
        String year = value.split("-")[0];
        String month = value.split("-")[1];
        String date = year + "-" + month + "-" + "01";
        LocalDate localDateFromOne = LocalDate.parse(date);
        LocalDate previousDate = localDateFromOne.minusDays(1);

        if (this.sat__7 == null) {
            System.out.println("Its null in daySelected()");
        }

        String dayPane = "";
        String day = "";
        int dayValue = 0;
        int numDayValue = 0;
        String dayString = "";

        if (localDateFromOne.getDayOfWeek().toString().equals("MONDAY")) {
            dayPane = "mon_2";
            day = "mon__2";
            dayValue = 2;
            numDayValue = 2;
        }
        else if (localDateFromOne.getDayOfWeek().toString().equals("TUESDAY")) {
            dayPane = "tue_3";
            day = "tue__3";
            dayValue = 3;
            numDayValue = 3;
        }
        else if (localDateFromOne.getDayOfWeek().toString().equals("WEDNESDAY")) {
            dayPane = "wed_4";
            day = "wed__4";
            dayValue = 4;
            numDayValue = 4;
        }
        else if (localDateFromOne.getDayOfWeek().toString().equals("THURSDAY")) {
            dayPane = "thu_5";
            day = "thu__5";
            dayValue = 5;
            numDayValue = 5;
        }
        else if (localDateFromOne.getDayOfWeek().toString().equals("FRIDAY")) {
            dayPane = "fri_6";
            day = "fri__6";
            dayValue = 6;
            numDayValue = 6;
        }
        else if (localDateFromOne.getDayOfWeek().toString().equals("SATURDAY")) {
            dayPane = "sat_7";
            day = "sat__7";
            dayValue = 7;
            numDayValue = 7;
        }
        else {
            dayPane = "sun_1";
            day = "sun__1";
            dayValue = 1;
            numDayValue = 1;
        }

        int row = 0;
        int column = dayValue;

        for (int y = column - 2; y >= 0; y--) {
            dayCalendarMap[row][y] = previousDate.getDayOfMonth();
            dayFormatCalendarMap[row][y] = previousDate.toString();
            previousDate = previousDate.minusDays(1);
        }


        for (int i = 1; i <= monthPicker.getValue().withDayOfMonth(monthPicker.getValue().getMonth().length(monthPicker.getValue().isLeapYear())).getDayOfMonth(); i++) {
            if (column - 1 == 7) {
                row++;
                column = 1;
            }
            dayCalendarMap[row][column - 1] = i;
            dayFormatCalendarMap[row][column - 1] = localDateFromOne.toString();
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
            localDateFromOne = localDateFromOne.plusDays(1);
            column++;
        }
        sun__1(dayCalendarMap[0][0]);
        mon__2(dayCalendarMap[0][1]);
        tue__3(dayCalendarMap[0][2]);
        wed__4(dayCalendarMap[0][3]);
        thu__5(dayCalendarMap[0][4]);
        fri__6(dayCalendarMap[0][5]);
        sat__7(dayCalendarMap[0][6]);

        sun__8(dayCalendarMap[1][0]);
        mon__9(dayCalendarMap[1][1]);
        tue__10(dayCalendarMap[1][2]);
        wed__11(dayCalendarMap[1][3]);
        thu__12(dayCalendarMap[1][4]);
        fri__13(dayCalendarMap[1][5]);
        sat__14(dayCalendarMap[1][6]);

        sun__15(dayCalendarMap[2][0]);
        mon__16(dayCalendarMap[2][1]);
        tue__17(dayCalendarMap[2][2]);
        wed__18(dayCalendarMap[2][3]);
        thu__19(dayCalendarMap[2][4]);
        fri__20(dayCalendarMap[2][5]);
        sat__21(dayCalendarMap[2][6]);

        sun__22(dayCalendarMap[3][0]);
        mon__23(dayCalendarMap[3][1]);
        tue__24(dayCalendarMap[3][2]);
        wed__25(dayCalendarMap[3][3]);
        thu__26(dayCalendarMap[3][4]);
        fri__27(dayCalendarMap[3][5]);
        sat__28(dayCalendarMap[3][6]);

        sun__29(dayCalendarMap[4][0]);
        mon__30(dayCalendarMap[4][1]);
        tue__31(dayCalendarMap[4][2]);
        wed__32(dayCalendarMap[4][3]);
        thu__33(dayCalendarMap[4][4]);
        fri__34(dayCalendarMap[4][5]);
        sat__35(dayCalendarMap[4][6]);

        sun__36(dayCalendarMap[5][0]);
        mon__37(dayCalendarMap[5][1]);
        tue__38(dayCalendarMap[5][2]);
        wed__39(dayCalendarMap[5][3]);
        thu__40(dayCalendarMap[5][4]);
        fri__41(dayCalendarMap[5][5]);
        sat__42(dayCalendarMap[5][6]);


        loadReservationArraySize(dayFormatCalendarMap[0][0], dayFormatCalendarMap[5][6]);
        loadReservationWithMonth(dayFormatCalendarMap[0][0], dayFormatCalendarMap[5][6]);



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
                System.out.println(queryOutput.getInt("count"));
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
                Color randomColor = Color.color(Math.random(), Math.random(), Math.random());
                myPane[index] = new Pane();
                myPane[index].setPrefWidth(90);
                myPane[index].setPrefHeight(15);

                calendarPane[index] = new Pane();
                calendarPane[index].setPrefSize(5, 5);
                calendarPane[index].setBackground(new Background(new BackgroundFill(randomColor, CornerRadii.EMPTY, Insets.EMPTY)));
                calendarPane[index].setBorder(new Border(new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

                colorband[index] = new Pane();
                colorband[index].setPrefSize(5, 5);
                colorband[index].setBackground(new Background(new BackgroundFill(randomColor, CornerRadii.EMPTY, Insets.EMPTY)));
                colorband[index].setBorder(new Border(new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

                roomNumberText[index] = new Text(String.valueOf(queryOutput.getInt("roomNumber")));
                mon_2.getChildren().add(calendarPane[index]);
                myPane[index].getChildren().addAll(colorband[index], roomNumberText[index]);
                tilePaneDirections.getChildren().add(myPane[index]);
                System.out.println(myPane[index].hashCode());

//                Pane temp = new Pane();
//                temp.setPrefHeight(15);
//                temp.setPrefWidth(90);
//
//                Pane colorBand = new Pane();
//                temp.setPrefSize(5, 5);
//                temp.setBackground(new Background(new BackgroundFill(randomColor, CornerRadii.EMPTY, Insets.EMPTY)));
//                temp.setBorder(new Border(new BorderStroke(Color.BLACK,
//                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
//                Text text = new Text(String.valueOf(queryOutput.getInt("roomNumber")));
//
//                tilePaneDirections.getChildren().addAll(colorBand, text);
                index++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
