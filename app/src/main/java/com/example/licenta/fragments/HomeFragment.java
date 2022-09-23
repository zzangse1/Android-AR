package com.example.licenta.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.example.licenta.AR.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.licenta.R;
import com.example.licenta.category.ArmmchairsCategory;
import com.example.licenta.category.BedsCategory;
import com.example.licenta.category.ChairsCategory;
import com.example.licenta.category.DeskCategory;
import com.example.licenta.category.DrawersCategory;
import com.example.licenta.category.TablesCategory;

public class HomeFragment extends Fragment {

    private Button btnFavoritesAR;
    private ImageView goToBeds, goToChairs, goToDesks, goToArmchairs, goToDrawers, goToTables, goToBestDeals;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

//        btnFavoritesAR = (Button) view.findViewById(R.id.button_favorites_ar);
        goToArmchairs = (ImageView)view.findViewById(R.id.fragment_home_armchairs_cateogry);
        goToBeds = (ImageView)view.findViewById(R.id.fragment_home_beds_category);
        goToChairs = (ImageView)view.findViewById(R.id.fragment_home_chairs_category);
//        goToDesks = (ImageView)view.findViewById(R.id.fragment_home_desks_category);
        goToDrawers = (ImageView)view.findViewById(R.id.fragment_home_drawers_category);
        goToTables = (ImageView)view.findViewById(R.id.fragment_home_tables_category);
//        goToBestDeals = (ImageView)view.findViewById(R.id.fragment_home_best_deals_chairs);

//        goToBestDeals.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(),ChairsCategory.class);
//                startActivity(intent);
//            }
//        });

        goToTables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TablesCategory.class);
                startActivity(intent);
            }
        });

        goToDrawers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DrawersCategory.class);
                startActivity(intent);
            }
        });

//        goToDesks.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), DeskCategory.class);
//                startActivity(intent);
//            }
//        });

        goToChairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChairsCategory.class);
                startActivity(intent);
            }
        });

        goToBeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BedsCategory.class);
                startActivity(intent);
            }
        });

        goToArmchairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ArmmchairsCategory.class);
                startActivity(intent);
            }
        });

//        btnFavoritesAR.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), favoritesAr.class);
//                startActivity(intent);
//            }
//        });

        return view;
    }
}