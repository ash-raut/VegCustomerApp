package com.example.vegcustomerapp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface GenerateOrdersRequestInterface {

    @POST("orders_generate_orders.php")

    @FormUrlEncoded
    Call<OrdersRequestResponsePOJO> getGenerateOrdersResponse(@Field("orders_customer_id") String orders_customer_id, @Field("orders_address_id") String orders_address_id);


}
