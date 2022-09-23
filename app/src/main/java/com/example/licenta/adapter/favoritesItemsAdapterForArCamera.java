package com.example.licenta.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.example.licenta.R;
import java.util.ArrayList;

public class favoritesItemsAdapterForArCamera extends BaseAdapter {

    private ArrayList<items> itemsList;
    private Context context;

    public favoritesItemsAdapterForArCamera(ArrayList<items> list, Context cont) {
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

        favoritesItemsAdapterForArCamera.ViewHolder holder = null;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.list_image_favorites_view, null);

            holder = new favoritesItemsAdapterForArCamera.ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.list_image_favorites_view_image_view);

            convertView.setTag(holder);
        } else {
            holder = (favoritesItemsAdapterForArCamera.ViewHolder) convertView.getTag();
        }

        items itm = itemsList.get(position);
        holder.imageView.setImageResource(itm.getlImageId());


        return convertView;
    }

    private static class ViewHolder {
        public ImageView imageView;
    }
}
