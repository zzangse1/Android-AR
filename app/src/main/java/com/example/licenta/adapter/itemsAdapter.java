package com.example.licenta.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.licenta.R;
import java.util.ArrayList;

public class itemsAdapter extends ArrayAdapter<items> {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     */
    public itemsAdapter(Activity context, ArrayList<items> item){
        super(context,0,item);
    }

    //Provides a view for an AdapterView (ListView, GridView, etc.)
    public View getView(int position, View convertView, ViewGroup parent){
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the object located at this posiiton in the list
        items currentItems=getItem(position);

        // Find the TextView in the list_item.xml layout with the id name_items
        TextView nameTextView=(TextView)listItemView.findViewById(R.id.name_item);

        // Get the name from the current items object and set this text on the name TextView
        nameTextView.setText(currentItems.getlName());

        // Find the TextView in the list_item.xml layout with the id price_items
        TextView priceTextView=(TextView)listItemView.findViewById(R.id.price_item);

        // Get the price from the current items object and set this text on the price TextView
        priceTextView.setText(currentItems.getlPrice()+" $");

        // Find the ImageView in the list_item.xml layout with the id icon_item
        ImageView iconImageView=(ImageView)listItemView.findViewById(R.id.icon_item);

        // Get the image from the current items object and set this image on the image view
        iconImageView.setImageResource(currentItems.getlImageId());

        return listItemView;
    }
}
