package com.example.licenta.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.licenta.R;
import java.util.ArrayList;

public class ordersAdapter extends BaseAdapter {

    private ArrayList<items> itemsList;
    private Context context;

    public ordersAdapter(ArrayList<items> list, Context cont) {
        this.itemsList = list;
        this.context = cont;
    }

    @Override
    public int getCount() {
        return this.itemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.itemsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ordersAdapter.ViewHolder holder = null;

        if (convertView == null) {

            LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.list_orders_item, null);

            holder = new ordersAdapter.ViewHolder();
            holder.payment =(TextView)convertView.findViewById(R.id.order_payment);
            holder.price =(TextView)convertView.findViewById(R.id.order_price);

            convertView.setTag(holder);

        } else {
            holder = (ordersAdapter.ViewHolder) convertView.getTag();
        }

        items itm = itemsList.get(position);
        holder.payment.setText(itm.getlPayment());
        holder.price.setText("Your order was:  " + itm.getlPrice() + " $");

        return convertView;
    }

    private static class ViewHolder {
        public TextView payment , price;
    }
}
