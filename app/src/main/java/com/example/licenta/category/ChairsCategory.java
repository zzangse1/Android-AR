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

public class ChairsCategory extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_chairs);

        getSupportActionBar().setTitle("Chairs");

        // Chairs items
        final ArrayList<items> chairs = new ArrayList<items>();
        chairs.add(new items("Chair1", 42, R.drawable.chair1, R.drawable.chair11, R.drawable.chair111,  "chair1.sfb" ,"의자 1"));
        chairs.add(new items("Chair2", 46, R.drawable.chair2, R.drawable.chair22, R.drawable.chair222,  "chair2.sfb","의자 2"));
        chairs.add(new items("Chair3", 54, R.drawable.chair3, R.drawable.chair33, R.drawable.chair333,  "chair3.sfb","의자 3"));
        chairs.add(new items("Chair4", 38, R.drawable.chair4, R.drawable.chair44, R.drawable.chair444,  "chair4.sfb","의자 4"));
        chairs.add(new items("Chair5", 65, R.drawable.chair5, R.drawable.chair55, R.drawable.chair555, "chair5.sfb","의자 5"));
//        chairs.add(new items("Chair6", 23, R.drawable.chair1, R.drawable.chair11, R.drawable.chair111,  "chair1.sfb",chairsDescription));
//        chairs.add(new items("Chair7", 46, R.drawable.chair2, R.drawable.chair22, R.drawable.chair222,  "chair2.sfb",chairsDescription));
//        chairs.add(new items("Chair8", 54, R.drawable.chair3, R.drawable.chair33, R.drawable.chair333,  "chair3.sfb",chairsDescription));
//        chairs.add(new items("Chair9", 37, R.drawable.chair4, R.drawable.chair44, R.drawable.chair444, "chair4.sfb",chairsDescription));
//        chairs.add(new items("Chair10", 65, R.drawable.chair5, R.drawable.chair55, R.drawable.chair555,  "chair5.sfb",chairsDescription));
//        chairs.add(new items("Chair11", 23, R.drawable.chair1, R.drawable.chair11, R.drawable.chair111,  "chair1.sfb",chairsDescription));
//        chairs.add(new items("Chair12", 43, R.drawable.chair2, R.drawable.chair22, R.drawable.chair222,  "chair2.sfb",chairsDescription));
//        chairs.add(new items("Chair13", 54, R.drawable.chair3, R.drawable.chair33, R.drawable.chair333, "chair3.sfb",chairsDescription));
//        chairs.add(new items("Chair14", 34, R.drawable.chair4, R.drawable.chair44, R.drawable.chair444,  "chair4.sfb",chairsDescription));
//        chairs.add(new items("Chair15", 65, R.drawable.chair5, R.drawable.chair55, R.drawable.chair555,  "chair5.sfb",chairsDescription));
        itemsAdapter itAdapter = new itemsAdapter(this, chairs);


        ListView listView = (ListView) findViewById(R.id.chairs_category_list_view);
        listView.setAdapter(itAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                items e = chairs.get(position);

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

                Intent intent = new Intent(ChairsCategory.this, Details.class);
                intent.putExtras(bundle);
                startActivity(intent);


            }
        });
    }
}
