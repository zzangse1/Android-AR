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

public class DrawersCategory extends AppCompatActivity {

    // Drawer Object Description
    private String drawersCategory = "Drawers can be built in a variety of manners using a variety of materials. Wood and various wood composites, sheet metal, & plastic are common materials used for drawers and the furniture that the drawer is contained in,         return \"Drawers can be built in a variety of manners using a variety of materials. Wood and various wood composites, sheet metal, & plastic are common materials used for drawers and the furniture that the drawer is contained in,         return \"Drawers can be built in a variety of manners using a variety of materials. Wood and various wood composites, sheet metal, & plastic are common materials used for drawers and the furniture that the drawer is contained in.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cateogry_drawers);

        getSupportActionBar().setTitle("Drawers");


        // Drawers items
        final ArrayList<items> drawers = new ArrayList<items>();
        drawers.add(new items("Drawer1", 23, R.drawable.drawer1, R.drawable.drawer11, R.drawable.drawer111, "drawer1.sfb", "서랍 1"));
        drawers.add(new items("Drawer2", 43, R.drawable.drawer2, R.drawable.drawer22, R.drawable.drawer222, "drawer2.sfb", "서랍 2"));
        drawers.add(new items("Drawer3", 54, R.drawable.drawer3, R.drawable.drawer33, R.drawable.drawer333, "drawer3.sfb", "서랍 3"));
        drawers.add(new items("Drawer4", 34, R.drawable.drawer4, R.drawable.drawer44, R.drawable.drawer444, "drawer4.sfb", "서랍 4"));
        drawers.add(new items("Drawer5", 65, R.drawable.drawer5, R.drawable.drawer55, R.drawable.drawer555, "drawer5.sfb", "서랍 5"));
//        drawers.add(new items("Drawer6", 23, R.drawable.drawer1, R.drawable.drawer11, R.drawable.drawer111, "drawer1.sfb", drawersCategory));
//        drawers.add(new items("Drawer7", 43, R.drawable.drawer2, R.drawable.drawer22, R.drawable.drawer222, "drawer2.sfb", drawersCategory));
//        drawers.add(new items("Drawer8", 54, R.drawable.drawer3, R.drawable.drawer33, R.drawable.drawer333, "drawer3.sfb", drawersCategory));
//        drawers.add(new items("Drawer9", 34, R.drawable.drawer4, R.drawable.drawer44, R.drawable.drawer444, "drawer4.sfb", drawersCategory));
//        drawers.add(new items("Drawer10", 65, R.drawable.drawer5, R.drawable.drawer55, R.drawable.drawer555, "drawer5.sfb", drawersCategory));
//        drawers.add(new items("Drawer11", 23, R.drawable.drawer1, R.drawable.drawer11, R.drawable.drawer111, "drawer1.sfb", drawersCategory));
//        drawers.add(new items("Drawer12", 43, R.drawable.drawer2, R.drawable.drawer22, R.drawable.drawer222, "drawer2.sfb", drawersCategory));
//        drawers.add(new items("Drawer13", 54, R.drawable.drawer3, R.drawable.drawer33, R.drawable.drawer333, "drawer3.sfb", drawersCategory));
//        drawers.add(new items("Drawer14", 34, R.drawable.drawer4, R.drawable.drawer44, R.drawable.drawer444, "drawer4.sfb", drawersCategory));
//        drawers.add(new items("Drawer15", 65, R.drawable.drawer5, R.drawable.drawer55, R.drawable.drawer555, "drawer5.sfb", drawersCategory));
        itemsAdapter itAdapter = new itemsAdapter(this, drawers);


        ListView listView = (ListView) findViewById(R.id.drawers_category_list_view);
        listView.setAdapter(itAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                items e = drawers.get(position);

                String name = e.getlName();
                int price = e.getlPrice();
                String details = e.getlDetails();
                String model = e.getlModel();
                int im = e.getlImageId();
                int im1 = e.getlImageId1();
                int im2 = e.getlImageId2();

                Bundle bundle = new Bundle();
                bundle.putString("Model", model);
                bundle.putString("Name", name);
                bundle.putInt("Price", price);
                bundle.putString("Details", details);
                bundle.putInt("Image", im);
                bundle.putInt("Image1", im1);
                bundle.putInt("Image2", im2);

                Intent intent = new Intent(DrawersCategory.this, Details.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
}
