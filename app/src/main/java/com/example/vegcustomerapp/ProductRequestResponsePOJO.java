package com.example.vegcustomerapp;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProductRequestResponsePOJO {

    private static ArrayList<PRODUCT> currentProductList = null;

    public static ArrayList<PRODUCT> getCurrentProductList() {
        return currentProductList;
    }

    public static void setCurrentProductList(ArrayList<PRODUCT> currentProductList) {
        ProductRequestResponsePOJO.currentProductList = currentProductList;
    }

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<PRODUCT> data ;

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

    public ArrayList<PRODUCT> getData() {
        return data;
    }


}