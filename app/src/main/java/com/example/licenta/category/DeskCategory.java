package com.example.licenta.category;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.licenta.Details;
import com.example.licenta.R;
import com.example.licenta.adapter.items;
import com.example.licenta.adapter.itemsAdapter;
import java.util.ArrayList;

public class DeskCategory extends AppCompatActivity {

    private String deskDescription = "A desk or bureau is a piece of furniture with a flat table-style work surface used in a school, office, home or the like for academic, professional or domestic activities such as reading, writing, or using equipment such as a computer.[1] Desks often have one or more drawers, compartments, or pigeonholes to store items such as office supplies and papers.[2] Desks are usually made of wood or metal, although materials such as glass are sometimes seen. Some desks have the form of a table, although usually only one side of a desk is suitable to sit at (there are some exceptions, such as a partners desk),[3] unlike most usual tables. Some desks do not have the form of a table.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_desks);

        getSupportActionBar().setTitle("Desks");


        // Desks items
        final ArrayList<items> desks = new ArrayList<items>();
        desks.add(new items("Desk1", 23, R.drawable.desk1, R.drawable.desk11, R.drawable.desk111, "desk1.sfb", "책상 1"));
        desks.add(new items("Desk2", 43, R.drawable.desk2, R.drawable.desk22, R.drawable.desk222, "desk2.sfb", "책상 2"));
        desks.add(new items("Desk3", 54, R.drawable.desk3, R.drawable.desk33, R.drawable.desk333, "desk3.sfb", "책상 3"));
        desks.add(new items("Desk4", 34, R.drawable.desk4, R.drawable.desk44, R.drawable.desk444, "desk4.sfb", "책상 4"));
        desks.add(new items("Desk5", 65, R.drawable.desk5, R.drawable.desk55, R.drawable.desk555, "desk5.sfb", "책상 5"));
//        desks.add(new items("Desk6", 23, R.drawable.desk1, R.drawable.desk11, R.drawable.desk111, "desk1.sfb", deskDescription));
//        desks.add(new items("Desk7", 43, R.drawable.desk2, R.drawable.desk22, R.drawable.desk222, "desk2.sfb", deskDescription));
//        desks.add(new items("Desk8", 54, R.drawable.desk3, R.drawable.desk33, R.drawable.desk333, "desk3.sfb", deskDescription));
//        desks.add(new items("Desk9", 34, R.drawable.desk4, R.drawable.desk44, R.drawable.desk444, "desk4.sfb", deskDescription));
//        desks.add(new items("Desk10", 65, R.drawable.desk5, R.drawable.desk55, R.drawable.desk555, "desk5.sfb", deskDescription));
//        desks.add(new items("Desk11", 23, R.drawable.desk1, R.drawable.desk11, R.drawable.desk111, "desk1.sfb", deskDescription));
//        desks.add(new items("Desk12", 43, R.drawable.desk2, R.drawable.desk22, R.drawable.desk222, "desk2.sfb", deskDescription));
//        desks.add(new items("Desk13", 54, R.drawable.desk3, R.drawable.desk33, R.drawable.desk333, "desk3.sfb", deskDescription));
//        desks.add(new items("Desk14", 34, R.drawable.desk4, R.drawable.desk44, R.drawable.desk444, "desk4.sfb", deskDescription));
//        desks.add(new items("Desk15", 65, R.drawable.desk5, R.drawable.desk55, R.drawable.desk555, "desk5.sfb", deskDescription));
        itemsAdapter itAdapter = new itemsAdapter(this, desks);

        // Get a reference to the ListView, and attach the adapter to the listView
        ListView listView = (ListView) findViewById(R.id.desk_category_list_view);
        listView.setAdapter(itAdapter);

         /* ========================================================================
                        Go to Details Activity with item
        ====================================================================*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                items e = desks.get(position);

                String name = e.getlName();
                int price = e.getlPrice();
                String details = e.getlDetails();
                int im = e.getlImageId();
                int im1 = e.getlImageId1();
                int im2 = e.getlImageId2();
                String model = e.getlModel();

                Bundle bundle = new Bundle();
                bundle.putString("Name", name);
                bundle.putInt("Price", price);
                bundle.putString("Details", details);
                bundle.putInt("Image", im);
                bundle.putInt("Image1", im1);
                bundle.putInt("Image2", im2);
                bundle.putString("Model", model);

                Intent intent = new Intent(DeskCategory.this, Details.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
}
