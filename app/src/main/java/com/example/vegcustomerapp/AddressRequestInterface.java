package com.example.vegcustomerapp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AddressRequestInterface {
    @POST("address_get_address.php")

    @FormUrlEncoded

    Call<AddressRequestResponsePOJO> getCartResponse(@Field("address_fetching_condition") String cart_fetching_condition);


}
