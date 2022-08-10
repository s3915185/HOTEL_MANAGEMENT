package com.example.hotelmanagement.Objects;

import java.sql.Date;

public class PaymentInformation {
    private int payment_ID;
    private int customer_ID;
    private Date payment_date;
    private int reservation_ID;
    private double amount;

    public PaymentInformation(int payment_ID, int customer_ID, Date payment_date, int reservation_ID, double amount) {
        this.payment_ID = payment_ID;
        this.customer_ID = customer_ID;
        this.payment_date = payment_date;
        this.reservation_ID = reservation_ID;
        this.amount = amount;
    }


    public int getPayment_ID() {
        return payment_ID;
    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public int getReservation_ID() {
        return reservation_ID;
    }
    public double getAmount() {
        return amount;
    }
}
