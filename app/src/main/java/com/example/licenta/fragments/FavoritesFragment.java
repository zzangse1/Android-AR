package com.example.licenta.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.licenta.Details;
import com.example.licenta.R;
import com.example.licenta.SQLite.DatabaseHelper;
import com.example.licenta.adapter.favoritesItemsAdapter;
import com.example.licenta.adapter.items;
import java.util.ArrayList;

public class FavoritesFragment extends Fragment {

    private DatabaseHelper favoriteDbHelper;
    private ListView listView;
    private ArrayList<items> item;
    private favoritesItemsAdapter myAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        listView = (ListView) view.findViewById(R.id.favorites_cateogry_container);
        favoriteDbHelper = new DatabaseHelper(this.getActivity());

        item = favoriteDbHelper.getAllData();

        myAdapter = new favoritesItemsAdapter(item, getActivity());
        listView.setAdapter(myAdapter);

        onResume();



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                items e = item.get(position);

                String name = e.getlName();
                int price = e.getlPrice();
                String details = e.getlDetails();
                String model = e.getlModel();
                int im = e.getlImageId();
                int im1 = e.getlImageId1();
                int im2 = e.getlImageId2();
                int quantity = e.getQuantity();

                Bundle bundle = new Bundle();
                bundle.putString("Name", name);
                bundle.putInt("Price", price);
                bundle.putString("Details", details);
                bundle.putInt("Image", im);
                bundle.putInt("Image1", im1);
                bundle.putInt("Image2", im2);
                bundle.putString("Model", model);
                bundle.putInt("Quantity", quantity);

                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        return view;
    }

}
