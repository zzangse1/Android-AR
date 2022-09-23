package com.example.licenta;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.example.licenta.adapter.items;
import com.example.licenta.SQLite.DatabaseHelper;

public class DetailsDialog extends AppCompatDialogFragment {

    private Button decrease,increase;
    private TextView quantity;
    private int inQuant;
    private DatabaseHelper myDb;
    private SQLiteDatabase mDb;
    private items i;

    public DetailsDialog(){}
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.details_dialog,null);

        myDb = new DatabaseHelper(getActivity());
        mDb = myDb.getWritableDatabase();

        // =====================================================
        //            Get info from Details Activity
        // =====================================================
        Bundle bundle = this.getArguments();
        final int bundleImage = bundle.getInt("Image");
        final int bundleImage1 = bundle.getInt("Image1");
        final int bundleImage2 = bundle.getInt("Image2");
        final String bundleName = bundle.getString("Name");
        final int bundlePrice = bundle.getInt("Price");
        final String bundleDetails = bundle.getString("Details");
        final String bundleModel = bundle.getString("Model");

        // ====================================================================================
        //                                 Cancel & Ok Buttons action
        // ====================================================================================
        builder.setView(view).setTitle("Select Quantity")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String strQ = quantity.getText().toString();
                inQuant = Integer.parseInt(strQ);
                i = new items(bundleName, bundlePrice, bundleImage, bundleImage1, bundleImage2, bundleDetails, bundleModel, inQuant);
                myDb.insertDataCart(i);

                Toast.makeText(getActivity(), inQuant+" Units Added To Cart", Toast.LENGTH_LONG).show();

            }
        });


        decrease = view.findViewById(R.id.details_decrease_button);
        increase = view.findViewById(R.id.details_increase_button);
        quantity = view.findViewById(R.id.details_q);

        String strQ = quantity.getText().toString();
        inQuant = Integer.parseInt(strQ);

        // ===============================================================
        //        Increase & Decrease Button action
        // ===============================================================
        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inQuant>0) {
                    inQuant--;
                    quantity.setText(Integer.toString(inQuant));
                }
            }
        });
        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inQuant<99) {
                    inQuant++;
                    quantity.setText(Integer.toString(inQuant));
                }
            }
        });
        return builder.create();

    }
}
