package com.example.licenta.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.licenta.R;
import java.util.ArrayList;

public class favoritesItemsAdapter extends BaseAdapter {

    private ArrayList<items> itemsList;
    private Context context;

    public favoritesItemsAdapter(ArrayList<items> list, Context cont) {
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

        ViewHolder holder = null;

        if (convertView == null) {

            LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.list_item, null);

            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.icon_item);
            holder.name =(TextView)convertView.findViewById(R.id.name_item);
            holder.price =(TextView)convertView.findViewById(R.id.price_item);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        items itm = itemsList.get(position);
        holder.imageView.setImageResource(itm.getlImageId());
        holder.name.setText(itm.getlName());
        holder.price.setText(itm.getlPrice() + " $");

        return convertView;
    }

    private static class ViewHolder {
        public ImageView imageView;
        public TextView name,price;
    }
}