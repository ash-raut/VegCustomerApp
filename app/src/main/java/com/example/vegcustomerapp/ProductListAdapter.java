package com.example.vegcustomerapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder>{
    View listItem;
    private ArrayList<PRODUCT> productArrayList = new ArrayList<>();
    public static  int pos=0;

    public ProductListAdapter( ArrayList<PRODUCT> productArrayList) {
        this.productArrayList = productArrayList;
    }

    @NonNull
    @Override
    public ProductListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        listItem = layoutInflater.inflate(R.layout.fruit_list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull final ProductListAdapter.ViewHolder holder, int position) {
        //final PRODUCT product = productArrayList.get(position);
        holder.fruitname.setText( productArrayList.get(position).getProductName());
        holder.fruitprice.setText( "₹ "+productArrayList.get(position).getProductPrice());
        holder.description.setText( productArrayList.get(position).getProductDescription());
        holder.fruitimg.setImageBitmap( productArrayList.get(position).getProductImageBitmap());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pos = position;
                PRODUCT.setCurrentProduct(productArrayList.get(position));
                Intent intent=new Intent(holder.linearLayout.getContext(),ProductDescriptionActivity.class);
                v.getContext().startActivity(intent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return productArrayList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView fruitname,fruitprice,description;
        ImageView fruitimg;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
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

