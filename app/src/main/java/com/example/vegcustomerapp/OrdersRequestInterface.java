package com.example.vegcustomerapp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface OrdersRequestInterface {

    @POST("orders_get_orders.php")

    @FormUrlEncoded
    Call<OrdersRequestResponsePOJO> getOrdersResponse(@Field("orders_id") String orders_id);



}
