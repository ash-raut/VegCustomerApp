package com.example.vegcustomerapp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ProductRequestInterface {

    @POST("product_get_product_list.php")

    @FormUrlEncoded

    Call<ProductRequestResponsePOJO> getProductResponse(@Field("product_fetching_condition") String product_fetching_condition);


}
