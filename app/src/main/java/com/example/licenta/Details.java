package com.example.licenta;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.licenta.AR.CameraAr;
import com.example.licenta.SQLite.DatabaseHelper;
import com.example.licenta.adapter.items;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;

public class Details extends AppCompatActivity {

    private DatabaseHelper myDb;
    private SQLiteDatabase mDb;
    private ImageView image, image1, image2;
    private TextView name, price, details;
    private Button arBtn, cartBtn, cartBtnMy;
    private MaterialFavoriteButton favoritesBtn;
    private items i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_items);

        getSupportActionBar().setTitle("Product Details");


        myDb = new DatabaseHelper(this);
        mDb = myDb.getWritableDatabase();

        // ===========================================================
        //                     FIND VIEW BY ID
        // ===========================================================
        image = (ImageView) findViewById(R.id.details_image);
        image1 = (ImageView) findViewById(R.id.details_image_1);
        image2 = (ImageView) findViewById(R.id.details_image_2);
        name = (TextView) findViewById(R.id.details_name);
        price = (TextView) findViewById(R.id.details_price);
        details = (TextView) findViewById(R.id.details_details);
        arBtn = (Button) findViewById(R.id.detail_go_to_ar);
        //cartBtn = (Button) findViewById(R.id.cart_bar_button);
        favoritesBtn = (MaterialFavoriteButton) findViewById(R.id.detail_favorite_button);
        cartBtnMy = (Button) findViewById(R.id.detail_cart_button_my);

        // ===========================================================
        //                Get data from category using bundle
        // ===========================================================
        Bundle bundle = getIntent().getExtras();
        final int bundleImage = bundle.getInt("Image");
        final int bundleImage1 = bundle.getInt("Image1");
        final int bundleImage2 = bundle.getInt("Image2");
        final String bundleName = bundle.getString("Name");
        final int bundlePrice = bundle.getInt("Price");
        final String bundleDetails = bundle.getString("Details");
        final String bundleModel = bundle.getString("Model");

        // ===========================================================
        //          Set data from bundle in Details Activity
        // ===========================================================
        name.setText(bundleName);
        price.setText("Price: " + bundlePrice + " $");
        details.setText(bundleDetails);
        image.setImageResource(bundleImage);
        image1.setImageResource(bundleImage1);
        image2.setImageResource(bundleImage2);

        // ============================================================
        //                     Buttons action
        // ============================================================

        // AR BUTTON
        arBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle1 = new Bundle();
                bundle1.putString("ModelForAr", bundleModel);
                Intent intent = new Intent(Details.this, CameraAr.class);
                intent.putExtras(bundle1);
                startActivity(intent);
            }
        });

        // CART BUTTON
        cartBtnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle2 = new Bundle();

                bundle2.putString("Name", bundleName);
                bundle2.putInt("Price", bundlePrice);
                bundle2.putString("Details", bundleDetails);
                bundle2.putInt("Image", bundleImage);
                bundle2.putInt("Image1", bundleImage1);
                bundle2.putInt("Image2", bundleImage2);
                bundle2.putString("Model", bundleModel);

                DetailsDialog detailsDialog = new DetailsDialog();
                detailsDialog.setArguments(bundle2);
                detailsDialog.show(getSupportFragmentManager(), "dialog");

            }
        });

        // 즐겨찾기 테이블에 데이터를 삽입하기 위한 생성자
        i = new items(bundleName, bundlePrice, bundleImage, bundleImage1, bundleImage2, bundleDetails, bundleModel,1);

        // FAVORITES BUTTON
        if (Exists(bundleName)) {
            favoritesBtn.setFavorite(true);
            favoritesBtn.setOnFavoriteChangeListener(new MaterialFavoriteButton.OnFavoriteChangeListener() {
                @Override
                public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
                    if (favorite == true) {
                        myDb.insertData(i);
                        Toast.makeText(Details.this, "Added To Favorite", Toast.LENGTH_LONG).show();
                    } else {
                        myDb = new DatabaseHelper(Details.this);
                        myDb.deleteFavorite(bundleImage);
                        Toast.makeText(Details.this, "Removed From Favorite", Toast.LENGTH_LONG).show();
                    }
                }
            });
        } else {
            favoritesBtn.setOnFavoriteChangeListener(new MaterialFavoriteButton.OnFavoriteChangeListener() {
                @Override
                public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
                    if (favorite == true) {
                        myDb.insertData(i);
                        Toast.makeText(Details.this, "Added To Favorite", Toast.LENGTH_LONG).show();
                    } else {
                        myDb = new DatabaseHelper(Details.this);
                        myDb.deleteFavorite(bundleImage);
                        Toast.makeText(Details.this, "Removed From Favorite", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }

    // ==========================================================
    //      Favorites , Check if element exist in DB
    // ==========================================================
    public boolean Exists(String searchItem) {

        String[] imageID = {DatabaseHelper.COL_1, DatabaseHelper.COL_2, DatabaseHelper.COL_3, DatabaseHelper.COL_4, DatabaseHelper.COL_5, DatabaseHelper.COL_6, DatabaseHelper.COL_7};

        String selection = DatabaseHelper.COL_2 + " =?";

        String[] selectionArgs = {searchItem};

        String limit = "1";

        Cursor cursor = mDb.query(DatabaseHelper.TABLE_NAME_FAVORITES, imageID, selection, selectionArgs, null, null, null, limit);
        boolean exists = (cursor.getCount() > 0);
        cursor.close();

        return exists;
    }

}
