package com.example.licenta.category;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.licenta.R;
import java.util.ArrayList;
import com.example.licenta.*;
import com.example.licenta.adapter.items;
import com.example.licenta.adapter.itemsAdapter;

public class TablesCategory extends AppCompatActivity {

    // product table description
    private String tablesDescription = "A table is an arrangement of columns and rows that organizes and positions data. Tables can be created on Wikipedia pages using special wikitext syntax, and many different styles and tricks can be used to customise them. A table is an arrangement of columns and rows that organizes and positions data. Tables can be created on Wikipedia pages using special wikitext syntax, and many different styles and tricks can be used to customise them. A table is an arrangement of columns and rows that organizes and positions data. Tables can be created on Wikipedia pages using special wikitext syntax, and many different styles and tricks can be used to customise them.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_tables);

        getSupportActionBar().setTitle("Tables");

        // Tables products
        final ArrayList<items> tables = new ArrayList<items>();
        tables.add(new items("Table1", 23, R.drawable.table1, R.drawable.table11, R.drawable.table111, "table1.sfb", "책상 1"));
        tables.add(new items("Table2", 43, R.drawable.table2, R.drawable.table22, R.drawable.table222, "table2.sfb", "책상 2"));
        tables.add(new items("Table3", 54, R.drawable.table3, R.drawable.table33, R.drawable.table333, "table3.sfb", "책상 3"));
        tables.add(new items("Table4", 34, R.drawable.table4, R.drawable.table44, R.drawable.table444, "table4.sfb", "책상 4"));
        tables.add(new items("Table5", 65, R.drawable.table5, R.drawable.table55, R.drawable.table555, "table5.sfb", "책상 5"));
//        tables.add(new items("Table6", 23, R.drawable.table1, R.drawable.table11, R.drawable.table111, "table1.sfb", tablesDescription));
//        tables.add(new items("Table7", 43, R.drawable.table2, R.drawable.table22, R.drawable.table222, "table2.sfb", tablesDescription));
//        tables.add(new items("Table8", 54, R.drawable.table3, R.drawable.table33, R.drawable.table333, "table3.sfb", tablesDescription));
//        tables.add(new items("Table9", 34, R.drawable.table4, R.drawable.table44, R.drawable.table444, "table4.sfb", tablesDescription));
//        tables.add(new items("Table10", 65, R.drawable.table5, R.drawable.table55, R.drawable.table555, "table5.sfb", tablesDescription));
//        tables.add(new items("Table11", 23, R.drawable.table1, R.drawable.table11, R.drawable.table111, "table1.sfb", tablesDescription));
//        tables.add(new items("Table12", 43, R.drawable.table2, R.drawable.table22, R.drawable.table222, "table2.sfb", tablesDescription));
//        tables.add(new items("Table13", 54, R.drawable.table3, R.drawable.table33, R.drawable.table333, "table3.sfb", tablesDescription));
//        tables.add(new items("Table14", 34, R.drawable.table4, R.drawable.table44, R.drawable.table444, "table4.sfb", tablesDescription));
//        tables.add(new items("Table15", 65, R.drawable.table5, R.drawable.table55, R.drawable.table555, "table5.sfb", tablesDescription));

        itemsAdapter itAdapter = new itemsAdapter(this, tables);

        // ListView에 대한 참조를 가져오고 어댑터를 listView에 연결합니다.
        ListView listView = (ListView) findViewById(R.id.tables_category_list_view);
        listView.setAdapter(itAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                items e = tables.get(position);

                String name = e.getlName();
                int price = e.getlPrice();
                String details = e.getlDetails();
                int im = e.getlImageId();
                int im1 = e.getlImageId1();
                int im2 = e.getlImageId2();
                String model = e.getlModel();

                Bundle bundle = new Bundle();
                bundle.putString("Model", model);
                bundle.putString("Name", name);
                bundle.putInt("Price", price);
                bundle.putString("Details", details);
                bundle.putInt("Image", im);
                bundle.putInt("Image1", im1);
                bundle.putInt("Image2", im2);

                Intent intent = new Intent(TablesCategory.this, Details.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
}
