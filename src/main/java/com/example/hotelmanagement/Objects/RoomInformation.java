package com.example.hotelmanagement.Objects;

public class RoomInformation {
    private int room_ID, room_number;
    private String room_quality, room_type, comments;
    private double room_price;

    public RoomInformation(int room_ID, int room_number, String room_quality, String room_type, String comments, double room_price) {
        this.room_ID = room_ID;
        this.room_number = room_number;
        this.room_quality = room_quality;
        this.room_type = room_type;
        this.comments = comments;
        this.room_price = room_price;
    }

    public int getRoom_ID() {
        return room_ID;
    }

    public int getRoom_number() {
        return room_number;
    }

    public String getRoom_quality() {
        return room_quality;
    }

    public String getRoom_type() {
        return room_type;
    }

    public String getComments() {
        return comments;
    }

    public double getRoom_price() {
        return room_price;
    }
}