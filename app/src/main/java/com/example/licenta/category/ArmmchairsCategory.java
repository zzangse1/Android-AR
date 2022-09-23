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

public class ArmmchairsCategory extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cateogry_armchairs);

        getSupportActionBar().setTitle("Armmchairs");

        // Armchairs items
        final ArrayList<items> armchairs = new ArrayList<items>();
        armchairs.add(new items("의자 1", 23, R.drawable.armchair1, R.drawable.armchair11, R.drawable.armchair111,"armchair1.sfb","의자1"));
        armchairs.add(new items("의자 2", 43, R.drawable.armchair2, R.drawable.armchair22, R.drawable.armchair222, "armchair2.sfb" ,"의자2"));
        armchairs.add(new items("의자 3", 54, R.drawable.armchair3, R.drawable.armchair33, R.drawable.armchair333,  "armchair3.sfb","의자3"));
        armchairs.add(new items("의자 4", 34, R.drawable.armchair4, R.drawable.armchair44, R.drawable.armchair444, "armchair4.sfb","의자4"));
        armchairs.add(new items("의자 5", 65, R.drawable.armchair5, R.drawable.armchair55, R.drawable.armchair555, "armchair5.sfb","의자5"));
//        armchairs.add(new items("Fosa Armchair", 23, R.drawable.armchair1, R.drawable.armchair11, R.drawable.armchair111,  "armchair1.sfb",armchairsDescription));
//        armchairs.add(new items("Morel Armchair", 43, R.drawable.armchair2, R.drawable.armchair22, R.drawable.armchair222,  "armchair2.sfb",armchairsDescription));
//        armchairs.add(new items("Dufa Armchair", 54, R.drawable.armchair3, R.drawable.armchair33, R.drawable.armchair333,  "armchair3.sfb",armchairsDescription));
//        armchairs.add(new items("Sofa Armchair", 34, R.drawable.armchair4, R.drawable.armchair44, R.drawable.armchair444, "armchair4.sfb",armchairsDescription));
//        armchairs.add(new items("Polon Armchair", 65, R.drawable.armchair5, R.drawable.armchair55, R.drawable.armchair555,  "armchair5.sfb",armchairsDescription));
//        armchairs.add(new items("Ikea Armchair", 23, R.drawable.armchair1, R.drawable.armchair11, R.drawable.armchair111,  "armchair1.sfb",armchairsDescription));
//        armchairs.add(new items("Standk Armchair", 43, R.drawable.armchair2, R.drawable.armchair22, R.drawable.armchair222,  "armchair2.sfb",armchairsDescription));
//        armchairs.add(new items("Merlon Armchair", 54, R.drawable.armchair3, R.drawable.armchair33, R.drawable.armchair333,  "armchair3.sfb",armchairsDescription));
//        armchairs.add(new items("Guji Armchair", 34, R.drawable.armchair4, R.drawable.armchair44, R.drawable.armchair444,  "armchair4.sfb",armchairsDescription));
//        armchairs.add(new items("Bello Armchair", 65, R.drawable.armchair5, R.drawable.armchair55, R.drawable.armchair555,  "armchair5.sfb",armchairsDescription));
        itemsAdapter itAdapter = new itemsAdapter(this, armchairs);


        ListView listView = (ListView) findViewById(R.id.armchairs_category_list_view);
        listView.setAdapter(itAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                items e = armchairs.get(position);

                String name = e.getlName();
                int price = e.getlPrice();
                String details = e.getlDetails();
                String model = e.getlModel();
                int im = e.getlImageId();
                int im1 = e.getlImageId1();
                int im2 = e.getlImageId2();

                Bundle bundle = new Bundle();
                bundle.putString("Name", name);
                bundle.putInt("Price", price);
                bundle.putString("Details", details);
                bundle.putInt("Image", im);
                bundle.putInt("Image1", im1);
                bundle.putInt("Image2", im2);
                bundle.putString("Model", model);

                Intent intent = new Intent(ArmmchairsCategory.this, Details.class);
                intent.putExtras(bundle);

                startActivity(intent);

            }
        });
    }
}
