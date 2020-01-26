package com.example.vegcustomerapp;

public class AddressList {

private String Name;
private String address;
private String country;
private  String mobile_no;
private  String city;
private String state;
private String pincode;
private String landmark;

public AddressList(String Name,String address,String country,String mobile_no,String city,String state,String pincode,String landmark){

    this.Name=Name;
    this.landmark=landmark;
    this.address=address;
    this.country=country;
    this.mobile_no=mobile_no;
    this.city=city;
    this.state=state;
    this.pincode=pincode;

}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }
}
