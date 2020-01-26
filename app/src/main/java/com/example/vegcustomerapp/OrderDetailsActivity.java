package com.example.vegcustomerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OrderDetailsActivity extends AppCompatActivity {

    TextView OrderId,DeliveryAddress,OrderDate,OrderStatus,DateOfOrder,TotalAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        OrderId = findViewById(R.id.orderdetailid);
        DeliveryAddress = findViewById(R.id.orderdetailaddress);
        OrderDate = findViewById(R.id.orderdate);
        OrderStatus = findViewById(R.id.orderdetailstatus);
        DateOfOrder = findViewById(R.id.orderdateofdetail);
        TotalAmount = findViewById(R.id.totalammount);






        getOrders(ORDERS.getCurrentOrders());

    }


    //======================================== Get Orders by order ID Function   ===========================================


    private void getOrders(ORDERS orders)
    {



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_address))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OrdersRequestInterface requestInteface = retrofit.create(OrdersRequestInterface.class);
        Call<OrdersRequestResponsePOJO> call = requestInteface.getOrdersResponse(orders.getOrdersId());

        call.enqueue(new Callback<OrdersRequestResponsePOJO>() {
            @Override
            public void onResponse(Call<OrdersRequestResponsePOJO> call, Response<OrdersRequestResponsePOJO> response) {


                OrdersRequestResponsePOJO ordersRequestResponsePOJO = response.body();

                if(ordersRequestResponsePOJO.getStatus().equals("successful"))
                {
                    //================================= Code to write on successful Order Fetching=====================================

                    OrdersListRequestResponsePOJO.setCurrentOrdersList(ordersRequestResponsePOJO.getDataOrder());
                    CartRequestResponsePOJO.setCartitemArrayList(ordersRequestResponsePOJO.getDataOrderedProducts());
                    ArrayList<CARTITEM> cartArrayList = CartRequestResponsePOJO.getCartitemArrayList();



                    OrderId.setText(ORDERS.getCurrentOrders().getOrdersId());
                    DeliveryAddress.setText(ORDERS.getCurrentOrders().getOrdersAddressId());
                    OrderStatus.setText(ORDERS.getCurrentOrders().getOrdersStatus());
                    DateOfOrder.setText(ORDERS.getCurrentOrders().getOrdersDateOfOrder());
                    TotalAmount.setText(ORDERS.getCurrentOrders().getOrdersTotalPrice());
                   





                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cart_recycler_view);
                    CartListAdapter adapter = new CartListAdapter(cartArrayList);
                    recyclerView.setHasFixedSize(false);
                    recyclerView.setItemViewCacheSize(cartArrayList.size());
                    recyclerView.setLayoutManager(new LinearLayoutManager(OrderDetailsActivity.this));
                    recyclerView.setAdapter(adapter);







                    //================================= *** Code to write on successful Order Fetching=======================================


                }

                else
                {
                    Toast.makeText(OrderDetailsActivity.this, "Responded Order Fetching Failed", Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onFailure(Call<OrdersRequestResponsePOJO> call, Throwable t) {
                Toast.makeText(OrderDetailsActivity.this, "Responded Order fetching Failed\n"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });



    }

    //========================================  *** Get Orders by Order ID Function   ===========================================


}
