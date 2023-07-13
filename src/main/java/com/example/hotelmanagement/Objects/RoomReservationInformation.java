package com.example.hotelmanagement.Objects;

import java.sql.Time;
import java.time.DateTimeException;
import java.util.Date;

public class RoomReservationInformation {
    int room_ID;
    String date_in_date;
    String date_in_time;

    String date_out_date;
    String date_out_time;

    int customer_ID;

    public RoomReservationInformation(int room_ID, String date_in_date, String date_in_time, String date_out_date, String date_out_time, int customer_ID) {
        this.room_ID = room_ID;
        this.date_in_date = date_in_date;
        this.date_in_time = date_in_time;
        this.date_out_date = date_out_date;
        this.date_out_time = date_out_time;
        this.customer_ID = customer_ID;
    }

    public int getRoom_ID() {
        return room_ID;
    }

    public String getDate_in_date() {
        return date_in_date;
    }

    public String getDate_in_time() {
        return date_in_time;
    }

    public String getDate_out_date() {
        return date_out_date;
    }

    public String getDate_out_time() {
        return date_out_time;
    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    @Override
    public String toString() {
        return "RoomReservationInformation{" +
                "room_ID=" + room_ID +
                ", date_in_date='" + date_in_date + '\'' +
                ", date_in_time='" + date_in_time + '\'' +
                ", date_out_date='" + date_out_date + '\'' +
                ", date_out_time='" + date_out_time + '\'' +
                ", customer_ID=" + customer_ID +
                '}';
    }
}
