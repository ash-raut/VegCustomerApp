package com.example.vegcustomerapp.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vegcustomerapp.AddressSelectionActivity;
import com.example.vegcustomerapp.CARTITEM;
import com.example.vegcustomerapp.CUSTOMER;
import com.example.vegcustomerapp.CartListAdapter;
import com.example.vegcustomerapp.CartRequestInterface;
import com.example.vegcustomerapp.CartRequestResponsePOJO;
import com.example.vegcustomerapp.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SlideshowFragment extends Fragment {

    View root;
    Button orderplace;
    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        //=====================================Button oBuy Now============================
        orderplace = root.findViewById(R.id.buynow);
        orderplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), AddressSelectionActivity.class);
                startActivity(intent);
            }
        });

        String cart_fetching_condition = "cart_item_customer_id = "+ CUSTOMER.getCurrentCustomer().getCustomerId()+" and cart_item_orders_id = 'u'";


        getCart(cart_fetching_condition);

        this.root =root;
        return root;



    }




    //============================================  Cart Fetching Function ==========================================



    private void getCart(String cart_fetching_condition)
    {



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_address))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CartRequestInterface requestInteface = retrofit.create(CartRequestInterface.class);
        Call<CartRequestResponsePOJO> call = requestInteface.getCartResponse(cart_fetching_condition);

        call.enqueue(new Callback<CartRequestResponsePOJO>() {
            @Override
            public void onResponse(Call<CartRequestResponsePOJO> call, Response<CartRequestResponsePOJO> response) {


                CartRequestResponsePOJO cartRequestResponsePOJO = response.body();

                if(cartRequestResponsePOJO.getStatus().equals("successful"))
                {
                    //================================= Code to write on successful cart data Fetching =====================================


                    CartRequestResponsePOJO.setCartitemArrayList(cartRequestResponsePOJO.getData());

                    Toast.makeText(getContext(), "successful", Toast.LENGTH_SHORT).show();


                    ArrayList<CARTITEM> cartArrayList = CartRequestResponsePOJO.getCartitemArrayList();

                    RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.cart_recycler_view);
                    CartListAdapter adapter = new CartListAdapter(cartArrayList);
                    recyclerView.setHasFixedSize(false);
                    recyclerView.setItemViewCacheSize(cartArrayList.size());
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(adapter);





                    //================================= *** Code to write on successful cart fetching =======================================


                }

                else
                {
                    Toast.makeText(getContext(), cartRequestResponsePOJO.getMessage(), Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onFailure(Call<CartRequestResponsePOJO> call, Throwable t) {
                Toast.makeText(getContext(), "Response Failed\n"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    //========================================  *** Cart Fetching Function   ===========================================







}