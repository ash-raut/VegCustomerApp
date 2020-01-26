package com.example.vegcustomerapp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface OrdersListRequestInterface {

    @POST("orders_get_orders_list.php")

    @FormUrlEncoded
    Call<OrdersListRequestResponsePOJO> getOrdersListResponse(@Field("orders_fetching_condition") String orders_fetching_condition);



}
