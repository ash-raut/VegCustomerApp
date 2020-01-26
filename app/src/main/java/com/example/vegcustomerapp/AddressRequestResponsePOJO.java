package com.example.vegcustomerapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AddressRequestResponsePOJO {

    private static ArrayList<ADDRESS> addressArrayList = null;

    public static ArrayList<ADDRESS> getAddressArrayList() {
        return AddressRequestResponsePOJO.addressArrayList;
    }

    public static void setAddressArrayList(ArrayList<ADDRESS> addressArrayList) {
        AddressRequestResponsePOJO.addressArrayList = addressArrayList;
    }

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<ADDRESS> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<ADDRESS> getData() {
        return data;
    }

    public void setData(ArrayList<ADDRESS> data) {
        this.data = data;
    }


}
