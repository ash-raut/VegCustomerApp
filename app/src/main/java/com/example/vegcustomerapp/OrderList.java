package com.example.vegcustomerapp;

public class OrderList {

    private String OrderAddress;
    private String Orders;
    private String Orderdate;
    private String Orderstatus;
    private String Orderstotal;

    public OrderList(String OrderAddress,String Orders,String Orderdate,String Orderstatus,String Orderstotal) {

        this.OrderAddress = OrderAddress;
        this.Orders = Orders;
        this.Orderdate = Orderdate;
        this.Orderstatus = Orderstatus;
        this.Orderstotal = Orderstotal;

    }

    public String getOrderAddress() {
        return OrderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        OrderAddress = orderAddress;
    }

    public String getOrders() {
        return Orders;
    }

    public void setOrders(String orders) {
        Orders = orders;
    }

    public String getOrderdate() {
        return Orderdate;
    }

    public void setOrderdate(String orderdate) {
        Orderdate = orderdate;
    }

    public String getOrderstatus() {
        return Orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        Orderstatus = orderstatus;
    }

    public String getOrderstotal() {
        return Orderstotal;
    }

    public void setOrderstotal(String orderstotal) {
        Orderstotal = orderstotal;
    }


}