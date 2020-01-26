package com.example.vegcustomerapp;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AddCartRequestInterface {


    @POST("cart_add_to_cart.php")

    @FormUrlEncoded

    Call<CartRequestResponsePOJO> getCartResponse(@Field("cart_item_customer_id") String cart_item_customer_id, @Field("cart_item_product_id") String cart_item_product_id, @Field("cart_item_quantity") String cart_item_quantity);





}
