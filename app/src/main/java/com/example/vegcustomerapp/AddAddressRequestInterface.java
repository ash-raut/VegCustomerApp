package com.example.vegcustomerapp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AddAddressRequestInterface {

    @POST("address_add_address.php")

    @FormUrlEncoded
    Call<AddressRequestResponsePOJO> getAddAddressResponse(@Field("address_customer_id") String address_customer_id, @Field("address_name") String address_name, @Field("address_mobile") String address_mobile, @Field("address_country") String address_country, @Field("address_state") String address_state, @Field("address_city") String address_city, @Field("address_address") String address_address, @Field("address_pincode") String address_pincode, @Field("address_landmark") String address_landmark);



}
