package com.example.vegcustomerapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OrdersRequestResponsePOJO {




    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data_order")
    @Expose
    private ArrayList<ORDERS> dataOrder = null;
    @SerializedName("data_ordered_products")
    @Expose
    private ArrayList<CARTITEM> dataOrderedProducts = null;

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

    public ArrayList<ORDERS> getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(ArrayList<ORDERS> dataOrder) {
        this.dataOrder = dataOrder;
    }

    public ArrayList<CARTITEM> getDataOrderedProducts() {
        return dataOrderedProducts;
    }

    public void setDataOrderedProducts(ArrayList<CARTITEM> dataOrderedProducts) {
        this.dataOrderedProducts = dataOrderedProducts;
    }


}
