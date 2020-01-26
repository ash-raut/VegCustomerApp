package com.example.vegcustomerapp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ProductAddInterface {

    @POST("product_add_product.php")

    @FormUrlEncoded

    Call<ProductRequestResponsePOJO> addProductResponse(@Field("product_name") String product_name, @Field("product_category_id") String product_category_id, @Field("product_price") String product_price, @Field("product_color") String product_color, @Field("product_image") String product_image, @Field("product_description") String product_description);


}
