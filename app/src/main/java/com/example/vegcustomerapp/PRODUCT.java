package com.example.vegcustomerapp;

import android.graphics.Bitmap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PRODUCT {

    private static PRODUCT currentProduct = null ;

    public static PRODUCT getCurrentProduct() {
        return currentProduct;
    }

    public static void setCurrentProduct(PRODUCT currentProduct) {
        PRODUCT.currentProduct = currentProduct;
    }


    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("product_name")
    @Expose
    private String productName;

    @SerializedName("product_category_id")
    @Expose
    private String productCategoryId;
    @SerializedName("product_price")
    @Expose
    private String productPrice;
    @SerializedName("product_color")
    @Expose
    private String productColor;
    @SerializedName("product_image")
    @Expose
    private String productImage;

    @SerializedName("product_description")
    @Expose
    private String productDescription;


    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }



    public String getCategoryName() {
        return categoryName;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCategoryId() {
        return productCategoryId;
    }


    public String getProductColor() {
        return productColor;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setProductCategoryId(String productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }


    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }




    public void setProductImageBitmap(Bitmap bitmap){
        productImage = ImageEncoder.convertBitmapToBase64(bitmap);
    }

    public Bitmap getProductImageBitmap(){

        return ImageDecoder.convertBase64ToBitmap(productImage);
    }

    //===================================================
}
