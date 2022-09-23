package com.example.licenta.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.licenta.R;
import com.example.licenta.SQLite.DatabaseHelper;
import com.example.licenta.adapter.items;
import com.example.licenta.adapter.ordersAdapter;
import java.util.ArrayList;

public class OrdersFragment extends Fragment {

    private DatabaseHelper dbHelper;
    private ListView listView;
    private ArrayList<items> item;
    private ordersAdapter ordersAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_orders, container, false);

        listView = (ListView) view.findViewById(R.id.list_orders_container);

        // List orders items from database in listview
        dbHelper = new DatabaseHelper(this.getActivity());
        item = dbHelper.getAllDataMyOrders();
        ordersAdapter = new ordersAdapter(item, getActivity());
        listView.setAdapter(ordersAdapter);

        return view;
    }
}
