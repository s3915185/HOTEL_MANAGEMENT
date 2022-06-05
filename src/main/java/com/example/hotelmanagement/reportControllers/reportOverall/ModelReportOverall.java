package com.example.hotelmanagement.reportControllers.reportOverall;

public class ModelReportOverall {
    String cust_ID, custfname, custlname, address, status;

    public ModelReportOverall(String cust_ID, String custfname, String custlname, String address, String status) {
        this.cust_ID = cust_ID;
        this.custfname = custfname;
        this.custlname = custlname;
        this.address = address;
        this.status = status;
    }

    public String getCust_ID() {
        return cust_ID;
    }

    public String getCustfname() {
        return custfname;
    }

    public String getCustlname() {
        return custlname;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }
}
