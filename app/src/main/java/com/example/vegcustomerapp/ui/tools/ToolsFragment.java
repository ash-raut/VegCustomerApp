package com.example.vegcustomerapp.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vegcustomerapp.CARTITEM;
import com.example.vegcustomerapp.CUSTOMER;
import com.example.vegcustomerapp.CartListAdapter;
import com.example.vegcustomerapp.CartRequestResponsePOJO;
import com.example.vegcustomerapp.ORDERS;
import com.example.vegcustomerapp.OrderDetailsActivity;
import com.example.vegcustomerapp.OrderListAdapter;
import com.example.vegcustomerapp.OrdersListRequestInterface;
import com.example.vegcustomerapp.OrdersListRequestResponsePOJO;
import com.example.vegcustomerapp.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;
    LinearLayout linearLayout;
    View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);


       String orders_fetching_condition = "orders_customer_id = "+CUSTOMER.getCurrentCustomer().getCustomerId();
        getOrdersList(orders_fetching_condition);
        this.root =root;
        return root;


    }



    //========================================  *** Get Orders List by Customer_id Function   ===========================================


    private void getOrdersList(String orders_fetching_condition)
    {



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_address))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OrdersListRequestInterface requestInteface = retrofit.create(OrdersListRequestInterface.class);
        Call<OrdersListRequestResponsePOJO> call = requestInteface.getOrdersListResponse(orders_fetching_condition);

        call.enqueue(new Callback<OrdersListRequestResponsePOJO>() {
            @Override
            public void onResponse(Call<OrdersListRequestResponsePOJO> call, Response<OrdersListRequestResponsePOJO> response) {


                OrdersListRequestResponsePOJO ordersListRequestResponsePOJO = response.body();

                if(ordersListRequestResponsePOJO.getStatus().equals("successful"))
                {
                    //================================= Code to write on successful Order List Fetching=====================================

                    OrdersListRequestResponsePOJO.setCurrentOrdersList(ordersListRequestResponsePOJO.getData());


                    ArrayList<ORDERS> ordersArrayList = OrdersListRequestResponsePOJO.getCurrentOrdersList();
                    Toast.makeText(getContext(), "Successfully  "+ordersArrayList.size(), Toast.LENGTH_SHORT).show();


                    RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.Orders_Recycler_View);
                    OrderListAdapter adapter = new OrderListAdapter(ordersArrayList);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setItemViewCacheSize(ordersArrayList.size());
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(adapter);




                    //================================= *** Code to write on successful Order List Fetching=======================================


                }

                else
                {
                    Toast.makeText(getContext(), "Responded Order List Fetching Failed", Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onFailure(Call<OrdersListRequestResponsePOJO> call, Throwable t) {
                Toast.makeText(getContext(), "Responded Order List fetching Failed\n"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    //========================================  *** Get Orders Function   ===========================================




}