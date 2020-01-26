package com.example.vegcustomerapp;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AdminRegisterRequestInterface {

    @POST("admin_registration.php")
    @FormUrlEncoded
    Call<AdminRegistrationResponsePOJO> getRegistrationPOJO(@Field("admin_name") String admin_name, @Field("admin_user_name") String admin_user_name, @Field("admin_mobile") String admin_mobile, @Field("admin_email") String admin_email, @Field("admin_gender") String admin_gender, @Field("admin_password") String admin_password);
}
