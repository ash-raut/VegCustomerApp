package com.example.vegcustomerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddressSelectionActivity extends AppCompatActivity {
    Button newaddress,procced;

    @Override
    protected void onPostResume() {
        String address_fetching_condition = "address_customer_id = " + CUSTOMER.getCurrentCustomer().getCustomerId();
        getAddress(address_fetching_condition);

        super.onPostResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_selection);
        newaddress = findViewById(R.id.newaddress);
        procced = findViewById(R.id.proceed);
        procced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddressSelectionActivity.this,PaymentActivity.class);
                startActivity(intent);
            }
        });


        String address_fetching_condition = "address_customer_id = " + CUSTOMER.getCurrentCustomer().getCustomerId();
        getAddress(address_fetching_condition);

        newaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddressSelectionActivity.this, AddNewAddressActivity.class);
                startActivity(intent);


            }
        });

    }





    //============================================  Address Fetching Function ==========================================



    private void getAddress(String address_fetching_condition)
    {



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_address))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AddressRequestInterface requestInteface = retrofit.create(AddressRequestInterface.class);
        Call<AddressRequestResponsePOJO> call = requestInteface.getCartResponse(address_fetching_condition);

        call.enqueue(new Callback<AddressRequestResponsePOJO>() {
            @Override
            public void onResponse(Call<AddressRequestResponsePOJO> call, Response<AddressRequestResponsePOJO> response) {


                AddressRequestResponsePOJO addressRequestResponsePOJO = response.body();

                if(addressRequestResponsePOJO.getStatus().equals("successful"))
                {
                    //================================= Code to write on successful address Fetching =====================================


                    AddressRequestResponsePOJO.setAddressArrayList(addressRequestResponsePOJO.getData());

                    ArrayList<ADDRESS> addressArrayList = AddressRequestResponsePOJO.getAddressArrayList();
                    AddressRequestResponsePOJO.setAddressArrayList(addressArrayList);



                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.addressselection_recyclerview);
                    AddressListAdapter adapter = new AddressListAdapter(addressArrayList);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setItemViewCacheSize(addressArrayList.size());
                    recyclerView.setLayoutManager(new LinearLayoutManager(AddressSelectionActivity.this));
                    recyclerView.setAdapter(adapter);

                    //================================= *** Code to write on successful address fetching =======================================


                }

                else
                {
                    Toast.makeText(AddressSelectionActivity.this, "Address Fetching Failed\n"+addressRequestResponsePOJO.getMessage(), Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onFailure(Call<AddressRequestResponsePOJO> call, Throwable t) {
                Toast.makeText(AddressSelectionActivity.this, "Response Failed\n"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    //========================================  *** Address Fetching Function   ===========================================
}
