package com.example.vegcustomerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PaymentActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    RadioButton R1,R2,R3;
    RadioGroup radioGroup;
    Button place_order;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        R1=findViewById(R.id.radioButton1);
        R2=findViewById(R.id.radioButton2);
        place_order = findViewById(R.id.place_order);
        place_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ORDERS orders= new ORDERS();

                orders.setOrdersCustomerId(CUSTOMER.getCurrentCustomer().getCustomerId());
                orders.setOrdersAddressId(ADDRESS.getCurrentAddress().getAddressId());

                generateOrders(orders);




            }
        });

        R1.setOnCheckedChangeListener(this);
        R2.setOnCheckedChangeListener(this);



    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean b) {
        switch (buttonView.getId())
        {
            case R.id.radioButton1:
                break;

            case R.id.radioButton2:
                break;
                case R.id.radioButton3:
             break;
        }

    }



    //========================================  *** Generate Orders Function   ===========================================


    private void generateOrders(ORDERS orders)
    {



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_address))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GenerateOrdersRequestInterface requestInteface = retrofit.create(GenerateOrdersRequestInterface.class);
        Call<OrdersRequestResponsePOJO> call = requestInteface.getGenerateOrdersResponse(
                orders.getOrdersCustomerId(),
                orders.getOrdersAddressId()

        );

        call.enqueue(new Callback<OrdersRequestResponsePOJO>() {
            @Override
            public void onResponse(Call<OrdersRequestResponsePOJO> call, Response<OrdersRequestResponsePOJO> response) {


                OrdersRequestResponsePOJO ordersRequestResponsePOJO = response.body();

                if(ordersRequestResponsePOJO.getStatus().equals("successful"))
                {
                    //================================= Code to write on successful Order Generating=====================================

                    ArrayList<ORDERS> ordersArrayList = ordersRequestResponsePOJO.getDataOrder();


                    ORDERS currentorders  = ordersArrayList.get(0); // It  gets current generated oreder details
                    ORDERS.setCurrentOrders(currentorders);

                    CartRequestResponsePOJO.setCartitemArrayList(ordersRequestResponsePOJO.getDataOrderedProducts());

                    Toast.makeText(PaymentActivity.this, "Order place Successfully", Toast.LENGTH_SHORT).show();



                    //================================= *** Code to write on successful Order Generating=======================================


                }

                else
                {
                    Toast.makeText(PaymentActivity.this, "Responded Order Generating Failed\n"+ordersRequestResponsePOJO.getMessage(), Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onFailure(Call<OrdersRequestResponsePOJO> call, Throwable t) {
                Toast.makeText(PaymentActivity.this, "Responded Order Generating Failed\n"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    //========================================  *** Generate Orders Function   ===========================================






}
