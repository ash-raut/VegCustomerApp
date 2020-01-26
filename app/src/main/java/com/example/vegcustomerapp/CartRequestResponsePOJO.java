package com.example.vegcustomerapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CartRequestResponsePOJO {

    private static ArrayList<CARTITEM> cartitemArrayList = null;

    public static ArrayList<CARTITEM> getCartitemArrayList() {
        return cartitemArrayList;
    }

    public static void setCartitemArrayList(ArrayList<CARTITEM> cartitemArrayList) {
        CartRequestResponsePOJO.cartitemArrayList = cartitemArrayList;
    }

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<CARTITEM> data = null;

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

    public ArrayList<CARTITEM> getData() {
        return data;
    }

    public void setData(ArrayList<CARTITEM> data) {
        this.data = data;
    }

}
