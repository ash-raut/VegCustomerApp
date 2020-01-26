package com.example.vegcustomerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductDescriptionActivity extends AppCompatActivity {
    ImageView img;
    TextView name, price,description;
    Spinner spinner;
    Button addbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_description);
        addbutton=findViewById(R.id.addbt);
        img=findViewById(R.id.imageViewX);
        name=findViewById(R.id.name);
        price=findViewById(R.id.price);
        description=findViewById(R.id.description);


        name.setText(PRODUCT.getCurrentProduct().getProductName());
        img.setImageBitmap(PRODUCT.getCurrentProduct().getProductImageBitmap());
        price.setText(PRODUCT.getCurrentProduct().getProductPrice());
        description.setText(PRODUCT.getCurrentProduct().getProductDescription());
        spinner=findViewById(R.id.spinner);

       /* nextbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProductDescriptionActivity.this,AddNewAddressActivity.class);
                startActivity(intent);

            }
        });*/
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int quantity = 0;
                quantity = spinner.getSelectedItemPosition()+1;
                CARTITEM cartitem = new CARTITEM();
                cartitem.setCartItemCustomerId(CUSTOMER.getCurrentCustomer().getCustomerId());
                cartitem.setCartItemProductId(PRODUCT.getCurrentProduct().getProductId());
                cartitem.setCartItemQuantity(Integer.toString(quantity));
                addToCart(cartitem);

               // Toast.makeText(ProductDescriptionActivity.this, "Item Added Successfully", Toast.LENGTH_SHORT).show();

            }
        });

        //   ============================ spinner==================


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//===================================================================================



    }


    @Override
    protected void onPause() {
        finish();
        super.onPause();
    }


    //============================================  Add to Cart Function ==========================================



    private void addToCart(CARTITEM cartitem)
    {



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_address))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AddCartRequestInterface requestInteface = retrofit.create(AddCartRequestInterface.class);
        Call<CartRequestResponsePOJO> call = requestInteface.getCartResponse(
                cartitem.getCartItemCustomerId(),
                cartitem.getCartItemProductId(),
                cartitem.getCartItemQuantity()
        );

        call.enqueue(new Callback<CartRequestResponsePOJO>() {
            @Override
            public void onResponse(Call<CartRequestResponsePOJO> call, Response<CartRequestResponsePOJO> response) {


                CartRequestResponsePOJO cartRequestResponsePOJO = response.body();

                if(cartRequestResponsePOJO.getStatus().equals("successful"))
                {
                    CARTITEM.setCurrentCartItem(cartRequestResponsePOJO.getData().get(0));
                    //================================= Code to write on successful product add to cart data Fetching =====================================




                    Toast.makeText(ProductDescriptionActivity.this, "Added to cart succssefully", Toast.LENGTH_SHORT).show();




                    //================================= *** Code to write on successful add to cart data Fetching =======================================


                }

                else
                {
                    Toast.makeText(ProductDescriptionActivity.this, cartRequestResponsePOJO.getMessage(), Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onFailure(Call<CartRequestResponsePOJO> call, Throwable t) {
                Toast.makeText(ProductDescriptionActivity.this, "Response Failed\n"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    //========================================  *** Add to Cart Function   ===========================================


















}

