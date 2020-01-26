package com.example.vegcustomerapp;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AdminLoginRequestInterface {

    @POST("admin_login.php")
    @FormUrlEncoded
    Call<ADMIN> getAdmin(@Field("admin_id") String admin_id, @Field("admin_password") String admin_password);

}
