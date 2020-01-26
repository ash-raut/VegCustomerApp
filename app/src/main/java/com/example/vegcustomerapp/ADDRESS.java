package com.example.vegcustomerapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ADDRESS {

    private static ADDRESS currentAddress = null;

    public static ADDRESS getCurrentAddress() {
        return currentAddress;
    }

    public static void setCurrentAddress(ADDRESS currentAddress) {
        ADDRESS.currentAddress = currentAddress;
    }

    @SerializedName("address_id")
    @Expose
    private String addressId;
    @SerializedName("address_customer_id")
    @Expose
    private String addressCustomerId;
    @SerializedName("address_name")
    @Expose
    private String addressName;
    @SerializedName("address_mobile")
    @Expose
    private String addressMobile;
    @SerializedName("address_country")
    @Expose
    private String addressCountry;
    @SerializedName("address_state")
    @Expose
    private String addressState;
    @SerializedName("address_city")
    @Expose
    private String addressCity;
    @SerializedName("address_address")
    @Expose
    private String addressAddress;
    @SerializedName("address_pincode")
    @Expose
    private String addressPincode;
    @SerializedName("address_landmark")
    @Expose
    private String addressLandmark;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAddressCustomerId() {
        return addressCustomerId;
    }

    public void setAddressCustomerId(String addressCustomerId) {
        this.addressCustomerId = addressCustomerId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressMobile() {
        return addressMobile;
    }

    public void setAddressMobile(String addressMobile) {
        this.addressMobile = addressMobile;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressAddress() {
        return addressAddress;
    }

    public void setAddressAddress(String addressAddress) {
        this.addressAddress = addressAddress;
    }

    public String getAddressPincode() { return addressPincode; }

    public void setAddressPincode(String addressPincode) { this.addressPincode = addressPincode; }

    public String getAddressLandmark() {
        return addressLandmark;
    }

    public void setAddressLandmark(String addressLandmark) {
        this.addressLandmark = addressLandmark;
    }



}
