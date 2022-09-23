package com.example.licenta.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.licenta.Details;
import com.example.licenta.R;
import com.example.licenta.SQLite.DatabaseHelper;
import java.util.ArrayList;

public class cartItemRecyclerView extends RecyclerView.Adapter<cartItemRecyclerView.ViewHolder> {

    private DatabaseHelper db;
    private Details details = new Details();
    private ArrayList<items> itemsList;
    private Context context;

    interface IImageButtonListener {
        void onImageButtonClick(View view, int pos);
    }

    public cartItemRecyclerView(ArrayList<items> item, DatabaseHelper db, Context context) {
        this.itemsList = item;
        this.db = db;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);


        View contactView = inflater.inflate(R.layout.list_cart_item_view, parent, false);


        ViewHolder viewHolder = new ViewHolder(contactView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        items itm = itemsList.get(position);


        holder.nameC.setText(itm.getlName());
        holder.iconC.setImageResource(itm.getlImageId());
        holder.priceC.setText(itm.getlPrice() + " $");
        holder.quantityC.setText(itm.getQuantity() + "");

        holder.setListener(new IImageButtonListener() {
            @Override
            public void onImageButtonClick(View view, int pos) {
                int position = itemsList.get(pos).getlImageId();
                db.deleteCart(position);
                Toast.makeText(context, "Swipe Up For Refresh", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameC, priceC, quantityC;
        public ImageView  iconC;
        IImageButtonListener listener;
        public Button removeItem;

        public void setListener(IImageButtonListener listener) {
            this.listener = listener;
        }

        public ViewHolder(View itemView) {
            super(itemView);
            nameC = itemView.findViewById(R.id.name_item_cart);
            priceC = itemView.findViewById(R.id.price_item_cart);
            quantityC = itemView.findViewById(R.id.textview_quantity_items);
            iconC = itemView.findViewById(R.id.icon_item_cart);
            removeItem = itemView.findViewById(R.id.remove_item_from_cart);

            removeItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onImageButtonClick(v, getAdapterPosition());
                }
            });
        }
    }


}
