package com.example.hotelmanagement.reportControllers.reportOverall;

public class ModelReportOverall {
    private String cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber;

    public ModelReportOverall(String cust_ID, String custfname, String custlname, String SSN, String housenumber, String district, String state, String gender, String phonenumber) {
        this.cust_ID = cust_ID;
        this.custfname = custfname;
        this.custlname = custlname;
        this.SSN = SSN;
        this.housenumber = housenumber;
        this.district = district;
        this.state = state;
        this.gender = gender;
        this.phonenumber = phonenumber;
    }

    public ModelReportOverall(String cust_ID, String custfname, String custlname, String phonenumber) {
        this.cust_ID = cust_ID;
        this.custfname = custfname;
        this.custlname = custlname;
        this.SSN = null;
        this.housenumber = null;
        this.district = null;
        this.state = null;
        this.gender = null;
        this.phonenumber = phonenumber;
    }

    public String getCust_ID() {
        return cust_ID;
    }

    public void setCust_ID(String cust_ID) {
        this.cust_ID = cust_ID;
    }

    public String getCustfname() {
        return custfname;
    }

    public void setCustfname(String custfname) {
        this.custfname = custfname;
    }

    public String getCustlname() {
        return custlname;
    }

    public void setCustlname(String custlname) {
        this.custlname = custlname;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
