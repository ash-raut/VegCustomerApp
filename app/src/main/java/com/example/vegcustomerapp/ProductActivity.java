package com.example.vegcustomerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.vegcustomerapp.ui.home.HomeFragment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
/*
        MyListFruit[] myListData= new MyListFruit[]{

                new MyListFruit("APPLE","100",R.drawable.apple,"This is red apple.an apple a day keeps doctor away"),
                new MyListFruit("LIMES","70",R.drawable.mosambi,"This is A Lemon "),
                new MyListFruit("RASPBERRIES","120",R.drawable.raspberries,"There is a  Raspberry Pi"),
                new MyListFruit("STRAWBERRY","80",R.drawable.strawberry,"I love Strawberries"),
                new MyListFruit("LIMES","60",R.drawable.limes,"This is Lemon ."),


        };
*/

        getProductList(HomeFragment.getCondition());


    }



    //============================================  Product Fetching Function ==========================================



    private void getProductList(String product_fetching_condition)
    {



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_address))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductRequestInterface requestInteface = retrofit.create(ProductRequestInterface.class);
        Call<ProductRequestResponsePOJO> call = requestInteface.getProductResponse(product_fetching_condition);

        call.enqueue(new Callback<ProductRequestResponsePOJO>() {
            @Override
            public void onResponse(Call<ProductRequestResponsePOJO> call, Response<ProductRequestResponsePOJO> response) {


                ProductRequestResponsePOJO productRequestResponsePOJO = response.body();
                //name.setText(productRequestResponsePOJO.getStatus());

                if(productRequestResponsePOJO.getStatus().equals("successful"))
                {
                    ProductRequestResponsePOJO.setCurrentProductList(productRequestResponsePOJO.getData());

                    //================================= Code to write on successful product data Fetching =====================================

                    ArrayList<PRODUCT> productArrayList = ProductRequestResponsePOJO.getCurrentProductList();

                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fruit_recycler_view);
                    ProductListAdapter adapter = new ProductListAdapter(productArrayList);
                    recyclerView.setHasFixedSize(false);
                    recyclerView.setItemViewCacheSize(productArrayList.size());
                    recyclerView.setLayoutManager(new LinearLayoutManager(ProductActivity.this));
                    recyclerView.setAdapter(adapter);







                    //================================= *** Code to write on successful product fetching =======================================


                }

                else
                {
                    Toast.makeText(ProductActivity.this, "Product Fetching Failed", Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onFailure(Call<ProductRequestResponsePOJO> call, Throwable t) {
                Toast.makeText(ProductActivity.this, "Response Failed\n"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    //========================================  *** Product Fetching Function   ===========================================

}


