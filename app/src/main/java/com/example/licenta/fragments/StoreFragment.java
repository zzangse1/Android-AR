package com.example.licenta.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.licenta.R;
import com.example.licenta.category.ArmmchairsCategory;
import com.example.licenta.category.BedsCategory;
import com.example.licenta.category.ChairsCategory;
import com.example.licenta.category.DeskCategory;
import com.example.licenta.category.DrawersCategory;
import com.example.licenta.category.TablesCategory;

public class StoreFragment extends Fragment {

    private Button btnCategoryBeds, btnCategoryChairs, btnCategoryTables, btnCategoryDesks, btnCategoryDrawers, btnCategoryArmchairs;

    // Required empty public Constructor
    public StoreFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_store, container, false);

        // FIND VIEW BY ID
        btnCategoryDesks = (Button) view.findViewById(R.id.button_category_desks);
        btnCategoryTables = (Button) view.findViewById(R.id.button_category_table);
        btnCategoryBeds = (Button) view.findViewById(R.id.button_category_beds);
        btnCategoryChairs = (Button) view.findViewById(R.id.button_category_chairs);
        btnCategoryDrawers = (Button) view.findViewById(R.id.button_category_drawers);
        btnCategoryArmchairs = (Button) view.findViewById(R.id.button_category_armchairs);

        // onClick Button Action
        btnCategoryBeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BedsCategory.class);
                startActivity(intent);
            }
        });

        btnCategoryTables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TablesCategory.class);
                startActivity(intent);
            }
        });

        btnCategoryChairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChairsCategory.class);
                startActivity(intent);
            }
        });

        btnCategoryDesks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DeskCategory.class);
                startActivity(intent);
            }
        });

        btnCategoryDrawers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DrawersCategory.class);
                startActivity(intent);
            }
        });

        btnCategoryArmchairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ArmmchairsCategory.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
