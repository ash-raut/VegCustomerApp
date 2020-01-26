package com.example.vegcustomerapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ORDERS {


    private static ORDERS currentOrders= null;


    public static ORDERS getCurrentOrders() {
        return currentOrders;
    }

    public static void setCurrentOrders(ORDERS currentOrders) {
        ORDERS.currentOrders = currentOrders;
    }



    @SerializedName("orders_id")
    @Expose
    private String ordersId;
    @SerializedName("orders_customer_id")
    @Expose
    private String ordersCustomerId;
    @SerializedName("orders_address_id")
    @Expose
    private String ordersAddressId;
    @SerializedName("orders_status")
    @Expose
    private String ordersStatus;
    @SerializedName("orders_date_of_order")
    @Expose
    private String ordersDateOfOrder;
    @SerializedName("orders_date_of_delivery")
    @Expose
    private Object ordersDateOfDelivery;
    @SerializedName("orders_date_of_cancellation")
    @Expose
    private Object ordersDateOfCancellation;
    @SerializedName("orders_total_price")
    @Expose
    private String ordersTotalPrice;

    public String getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(String ordersId) {
        this.ordersId = ordersId;
    }

    public String getOrdersCustomerId() {
        return ordersCustomerId;
    }

    public void setOrdersCustomerId(String ordersCustomerId) {
        this.ordersCustomerId = ordersCustomerId;
    }

    public String getOrdersAddressId() {
        return ordersAddressId;
    }

    public void setOrdersAddressId(String ordersAddressId) {
        this.ordersAddressId = ordersAddressId;
    }

    public String getOrdersStatus() {
        return ordersStatus;
    }

    public void setOrdersStatus(String ordersStatus) {
        this.ordersStatus = ordersStatus;
    }

    public String getOrdersDateOfOrder() {
        return ordersDateOfOrder;
    }

    public void setOrdersDateOfOrder(String ordersDateOfOrder) {
        this.ordersDateOfOrder = ordersDateOfOrder;
    }

    public Object getOrdersDateOfDelivery() {
        return ordersDateOfDelivery;
    }

    public void setOrdersDateOfDelivery(Object ordersDateOfDelivery) {
        this.ordersDateOfDelivery = ordersDateOfDelivery;
    }

    public Object getOrdersDateOfCancellation() {
        return ordersDateOfCancellation;
    }

    public void setOrdersDateOfCancellation(Object ordersDateOfCancellation) {
        this.ordersDateOfCancellation = ordersDateOfCancellation;
    }

    public String getOrdersTotalPrice() {
        return ordersTotalPrice;
    }

    public void setOrdersTotalPrice(String ordersTotalPrice) {
        this.ordersTotalPrice = ordersTotalPrice;
    }

}
