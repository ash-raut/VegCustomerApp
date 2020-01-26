package com.example.vegcustomerapp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CartRequestInterface {

    @POST("cart_get_cart.php")

    @FormUrlEncoded

    Call<CartRequestResponsePOJO> getCartResponse(@Field("cart_fetching_condition") String cart_fetching_condition);




}
