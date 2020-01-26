package com.example.vegcustomerapp;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CustomerRegisterRequestInterface {

    @POST("customer_registration.php")
    @FormUrlEncoded
    Call<CustomerRegistrationResponsePOJO> getRegistrationPOJO(@Field("customer_name") String customer_name, @Field("customer_password") String customer_password, @Field("customer_user_name") String customer_user_name, @Field("customer_mobile") String customer_mobile, @Field("customer_address") String customer_address, @Field("customer_email") String customer_email, @Field("customer_dob") String customer_dob, @Field("customer_gender") String customer_gender);
}
