package com.example.vegcustomerapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CUSTOMER {

    private static CUSTOMER currentCustomer = null;

    public static CUSTOMER getCurrentCustomer() {
        return currentCustomer;
    }

    public static void setCurrentCustomer(CUSTOMER currentCustomer) {
        CUSTOMER.currentCustomer = currentCustomer;
    }

    @SerializedName("customer_id")
    @Expose
    private String customerId;
    @SerializedName("customer_name")
    @Expose
    private String customerName;
    @SerializedName("customer_user_name")
    @Expose
    private String customerUserName;
    @SerializedName("customer_mobile")
    @Expose
    private String customerMobile;
    @SerializedName("customer_gender")
    @Expose
    private String customerGender;
    @SerializedName("customer_email")
    @Expose
    private String customerEmail;
    @SerializedName("customer_dob")
    @Expose
    private String customerDob;
    @SerializedName("customer_address")
    @Expose
    private String customerAddress;
    @SerializedName("customer_registration_date")
    @Expose
    private String customerRegistrationDate;
    @SerializedName("customer_password")
    @Expose
    private String customerPassword;



    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public void setCustomerUserName(String customerUserName) {
        this.customerUserName = customerUserName;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerDob() {
        return customerDob;
    }

    public void setCustomerDob(String customerDob) {
        this.customerDob = customerDob;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerRegistrationDate() {
        return customerRegistrationDate;
    }

    public void setCustomerRegistrationDate(String customerRegistrationDate) {
        this.customerRegistrationDate = customerRegistrationDate;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }


}
