package com.example.vegcustomerapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderListAdapter extends RecyclerView.Adapter <OrderListAdapter.ViewHolder>{

    View listItem;
    ORDERS orders = new ORDERS();
    private ArrayList<ORDERS> orderArrayList = new ArrayList<>();
    private static  int selectedDetailPosition = 0;
  public static  int pos = 0;

    public static int getSelectedDetailPosition() {
        return selectedDetailPosition;
    }

    public OrderListAdapter(ArrayList<ORDERS> orderArrayList) {
        this.orderArrayList= orderArrayList;

    }

    @NonNull
    @Override
    public OrderListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        listItem = layoutInflater.inflate(R.layout.order_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull OrderListAdapter.ViewHolder holder, int position) {

        holder.orderaddress.setText(orderArrayList.get(position).getOrdersAddressId());
        holder.orders.setText(orderArrayList.get(position).getOrdersId());
        holder.orderdate.setText(orderArrayList.get(position).getOrdersDateOfOrder());
        holder.orderstatus.setText(orderArrayList.get(position).getOrdersStatus());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos = position;
                Intent intent = new Intent(holder.linearLayout.getContext(),OrderDetailsActivity.class);
                v.getContext().startActivity(intent);
                selectedDetailPosition = position;
                ORDERS.setCurrentOrders(OrdersListRequestResponsePOJO.getCurrentOrdersList().get(position));

                Toast.makeText(holder.linearLayout.getContext(), ""+position, Toast.LENGTH_SHORT).show();

            }
        });


    }



    @Override
    public int getItemCount() {
        return orderArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

   public TextView orderaddress,orders,orderdate,orderstatus;
   public LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.orderaddress = (TextView) itemView.findViewById(R.id.orderaddress);
            this.orders = (TextView) itemView.findViewById(R.id.orderid);
            this.orderdate = (TextView) itemView.findViewById(R.id.orderdate);
            this.orderstatus = (TextView) itemView.findViewById(R.id.orderstatus);
            this.linearLayout = (LinearLayout) itemView.findViewById(R.id.OrderDetail_LY);

        }
    }
}
