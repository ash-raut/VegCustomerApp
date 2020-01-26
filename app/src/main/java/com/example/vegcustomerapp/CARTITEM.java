package com.example.vegcustomerapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CARTITEM extends PRODUCT {

    private static CARTITEM currentCartItem= null;

    public static CARTITEM getCurrentCartItem() {
        return currentCartItem;
    }

    public static void setCurrentCartItem(CARTITEM currentCartItem) {
        CARTITEM.currentCartItem = currentCartItem;
    }

    @SerializedName("cart_item_id")
    @Expose
    private String cartItemId;
    @SerializedName("cart_item_customer_id")
    @Expose
    private String cartItemCustomerId;
    @SerializedName("cart_item_product_id")
    @Expose
    private String cartItemProductId;
    @SerializedName("cart_item_quantity")
    @Expose
    private String cartItemQuantity;
    @SerializedName("cart_item_product_price")
    @Expose
    private String cartItemProductPrice;
    @SerializedName("cart_item_date_of_adding")
    @Expose
    private String cartItemDateOfAdding;
    @SerializedName("cart_item_orders_id")
    @Expose
    private String cartItemOrdersId;










    public String getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(String cartItemId) {
        this.cartItemId = cartItemId;
    }

    public String getCartItemCustomerId() {
        return cartItemCustomerId;
    }

    public void setCartItemCustomerId(String cartItemCustomerId) {
        this.cartItemCustomerId = cartItemCustomerId;
    }

    public String getCartItemProductId() {
        return cartItemProductId;
    }

    public void setCartItemProductId(String cartItemProductId) {
        this.cartItemProductId = cartItemProductId;
    }

    public String getCartItemQuantity() {
        return cartItemQuantity;
    }

    public void setCartItemQuantity(String cartItemQuantity) {
        this.cartItemQuantity = cartItemQuantity;
    }

    public String getCartItemProductPrice() {
        return cartItemProductPrice;
    }

    public void setCartItemProductPrice(String cartItemProductPrice) {
        this.cartItemProductPrice = cartItemProductPrice;
    }

    public String getCartItemDateOfAdding() {
        return cartItemDateOfAdding;
    }

    public void setCartItemDateOfAdding(String cartItemDateOfAdding) {
        this.cartItemDateOfAdding = cartItemDateOfAdding;
    }

    public String getCartItemOrdersId() {
        return cartItemOrdersId;
    }

    public void setCartItemOrdersId(String cartItemOrderxId) {
        this.cartItemOrdersId = cartItemOrderxId;
    }

}
