package com.example.vegcustomerapp;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CustomerLoginRequestInterface {

    @POST("customer_login.php")
    @FormUrlEncoded
    Call<CUSTOMER> getCustomer(@Field("customer_id") String customer_id, @Field("customer_password") String customer_password);

}
