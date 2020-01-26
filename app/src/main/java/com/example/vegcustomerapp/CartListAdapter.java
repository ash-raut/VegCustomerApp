package com.example.vegcustomerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {

    View listItem;
    private ArrayList<CARTITEM> cartArrayList = new ArrayList<>();
    public static  int pos=0;

    public CartListAdapter( ArrayList<CARTITEM> cartArrayList) {
        this.cartArrayList = cartArrayList;
    }

    @NonNull
    @Override
    public CartListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        listItem = layoutInflater.inflate(R.layout.fruit_list_item,parent,false);
        CartListAdapter.ViewHolder viewHolder = new CartListAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartListAdapter.ViewHolder holder, int position) {
        holder.fruitname.setText( cartArrayList.get(position).getProductName());
        holder.fruitprice.setText( "₹ "+cartArrayList.get(position).getProductPrice()+"\nQty :"+cartArrayList.get(position).getCartItemQuantity());
        holder.description.setText( cartArrayList.get(position).getProductDescription());
        holder.fruitimg.setImageBitmap( cartArrayList.get(position).getProductImageBitmap());

    }

    @Override
    public int getItemCount() {
        return cartArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView fruitname,fruitprice,description;
        ImageView fruitimg;
        public LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.fruitname=(TextView)itemView.findViewById(R.id.name);
            this.fruitprice=(TextView)itemView.findViewById(R.id.price);
            this.description=(TextView)itemView.findViewById(R.id.description);
            this.fruitimg=(ImageView) itemView.findViewById(R.id.fruitimg);
            this.linearLayout=(LinearLayout)itemView.findViewById(R.id.linearLayout);

            // this.linearLayout = (LinearLayout)itemView.findViewById(R.id.sales_linearlayout);


        }
    }
}
