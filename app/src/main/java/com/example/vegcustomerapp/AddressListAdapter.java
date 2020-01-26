package com.example.vegcustomerapp;

import android.graphics.Color;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AddressListAdapter extends RecyclerView.Adapter <AddressListAdapter.ViewHolder>{

    View listItem;
    ADDRESS address = new ADDRESS();
    private ArrayList<ADDRESS> addressArrayList = new ArrayList<>();
   private static  int seelectedAddressPosition = 0;

    public static int getSeelectedAddressPosition() {
        return seelectedAddressPosition;
    }



    public AddressListAdapter(ArrayList<ADDRESS> addressArrayList) {
            this.addressArrayList= addressArrayList;

    }

    @NonNull
    @Override
    public AddressListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        listItem = layoutInflater.inflate(R.layout.addressselection_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AddressListAdapter.ViewHolder holder, int position) {

        {
            holder.name.setText(addressArrayList.get(position).getAddressName());
            holder.mobileno.setText(addressArrayList.get(position).getAddressMobile());
            holder.address.setText(addressArrayList.get(position).getAddressAddress());
            holder.pincode.setText(addressArrayList.get(position).getAddressPincode());
            holder.city.setText(addressArrayList.get(position).getAddressCity());
            holder.state.setText(addressArrayList.get(position).getAddressState());
            holder.country.setText(addressArrayList.get(position).getAddressCountry());
            holder.landmark.setText(addressArrayList.get(position).getAddressLandmark());

        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seelectedAddressPosition = position;
               holder.linearLayout.setBackgroundColor(Color.GREEN);
                holder.linearLayout.setSelected(true);
                ADDRESS.setCurrentAddress(AddressRequestResponsePOJO.getAddressArrayList().get(position));
                Toast.makeText(holder.linearLayout.getContext(), ""+position, Toast.LENGTH_SHORT).show();

            }


        });






    }



    @Override
    public int getItemCount() {
        return addressArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name,mobileno,address,city,state,country,pincode,landmark;
        public LinearLayout linearLayout;
        public Button procced;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.procced = (Button) itemView.findViewById(R.id.proceed);
            this. linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.country = (TextView) itemView.findViewById(R.id.country);
            this.state = (TextView) itemView.findViewById(R.id.state);
            this.city = (TextView ) itemView.findViewById(R.id.city);
            this.pincode = (TextView ) itemView.findViewById(R.id.pincode);
            this.address = (TextView ) itemView.findViewById(R.id.address);
            this.mobileno = (TextView) itemView.findViewById(R.id.mobile_no);
            this.landmark= (TextView) itemView.findViewById(R.id.landmark);


        }
    }
}
