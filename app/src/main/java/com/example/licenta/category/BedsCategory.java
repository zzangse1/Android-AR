package com.example.licenta.category;

import androidx.appcompat.app.AppCompatActivity;
import com.example.licenta.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.licenta.R;
import com.example.licenta.adapter.items;
import com.example.licenta.adapter.itemsAdapter;
import java.util.ArrayList;

public class BedsCategory extends AppCompatActivity {

    // Bed Object Description
    private String bedDescription = "A bed is a piece of furniture which is used as a place to sleep or relax. Most modern beds consist of a soft, cushioned mattress on a bed frame, the mattress resting either on a solid base, often wood slats, or a sprung base. Many beds include a box spring inner-sprung base, which is a large mattress-sized box containing wood and springs that provide additional support and suspension for the mattress. Beds are available in many sizes, ranging from infant-sized bassinets and cribs, to small beds for a single person or adult, to large queen and king-size beds designed for two people. While most beds are single mattresses on a fixed frame, there are other varieties, such as the murphy bed, which folds into a wall, the sofa bed, which folds out of a sofa, and the bunk bed, which provides two mattresses on two tiers.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_beds);

        getSupportActionBar().setTitle("Beds");

        // Beds items
        final ArrayList<items> beds = new ArrayList<items>();
        beds.add(new items("Bed1", 23, R.drawable.bed1, R.drawable.bed11, R.drawable.bed111, "bed1.sfb", "이 침대는 유럽풍의 분위기를 느낄 수 있습니다."));
        beds.add(new items("Bed2", 43, R.drawable.bed2, R.drawable.bed22, R.drawable.bed222, "bed2.sfb", "이 침대는 따로 시트를 구매 해야 합니다. ( 개별 판매 )"));
        beds.add(new items("Bed3", 54, R.drawable.bed3, R.drawable.bed33, R.drawable.bed333, "bed3.sfb", "이 침대는 어린이용 침대입니다."));
        beds.add(new items("Bed4", 34, R.drawable.bed4, R.drawable.bed44, R.drawable.bed444, "bed4.sfb", "이 침대는 쇼파와 같은 느낌의 침대입니다."));
        beds.add(new items("Bed5", 65, R.drawable.bed5, R.drawable.bed55, R.drawable.bed555, "bed5.sfb", "쇼파입니다."));

        itemsAdapter itAdapter = new itemsAdapter(this, beds);


        ListView listView = (ListView) findViewById(R.id.beds_category_list_view);
        listView.setAdapter(itAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                items e = beds.get(position);

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

                Intent intent = new Intent(BedsCategory.this, Details.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }

}
