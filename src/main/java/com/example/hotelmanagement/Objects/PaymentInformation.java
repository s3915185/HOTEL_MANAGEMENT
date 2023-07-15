package com.example.hotelmanagement.Objects;

import java.sql.Date;
import java.sql.Time;

public class PaymentInformation {
    private int payment_ID;
    private int customer_ID;
    private String payment_date;

    private String payment_time;
    private double amount;
    private int reservation_ID;
    private String paymentType;

    public int getPayment_ID() {
        return payment_ID;
    }

    public PaymentInformation(int customer_ID, String payment_date, String payment_time, double amount, int reservation_ID, String paymentType) {
        this.customer_ID = customer_ID;
        this.payment_date = payment_date;
        this.payment_time = payment_time;
        this.amount = amount;
        this.reservation_ID = reservation_ID;
        this.paymentType = paymentType;
    }

    public PaymentInformation(int payment_ID, int customer_ID, String payment_date, String payment_time, double amount, int reservation_ID, String paymentType) {
        this.payment_ID = payment_ID;
        this.customer_ID = customer_ID;
        this.payment_date = payment_date;
        this.payment_time = payment_time;
        this.amount = amount;
        this.reservation_ID = reservation_ID;
        this.paymentType = paymentType;
    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public String getPayment_time() {
        return payment_time;
    }

    public double getAmount() {
        return amount;
    }

    public int getReservation_ID() {
        return reservation_ID;
    }

    public String getPaymentType() {
        return paymentType;
    }

    @Override
    public String toString() {
        return "PaymentInformation{" +
                "customer_ID=" + customer_ID +
                ", payment_date=" + payment_date +
                ", payment_time=" + payment_time +
                ", amount=" + amount +
                ", reservation_ID=" + reservation_ID +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }
}
