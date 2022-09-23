package com.example.licenta.SQLite;

import com.example.licenta.adapter.items;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "favorites.db";
    public static final String TABLE_NAME_FAVORITES = "favorites_table";
    public static final String TABLE_NAME_CART = "cart_table";
    public static final String TABLE_NAME_MY_ORDERS = "orders_table";
    public static final String COL_1 = "IMAGE";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "PRICE";
    public static final String COL_4 = "DETAILS";
    public static final String COL_5 = "MODEL";
    public static final String COL_6 = "IMAGEE";
    public static final String COL_7 = "IMAGEEE";
    public static final String COL_8 = "QUANTITY";
    public static final String COL_9 = "PAYMENT";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    private static DatabaseHelper sDatabaseHelper;


    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    public static DatabaseHelper getInstance(Context context) {
        if (sDatabaseHelper == null) {
            sDatabaseHelper = new DatabaseHelper(context);
        }
        return sDatabaseHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME_FAVORITES + " (" + COL_1 + " INTEGER, " + COL_2 + " VARCHAR, " + COL_3 + " INTEGER, " + COL_4 + " VARCHAR, " + COL_5 + " VARCHAR, " + COL_6 + " INTEGER, " + COL_7 + " INTEGER, " + COL_8 + " INTEGER);");
        db.execSQL("CREATE TABLE " + TABLE_NAME_CART + " (" + COL_1 + " INTEGER, " + COL_2 + " VARCHAR, " + COL_3 + " INTEGER, " + COL_4 + " VARCHAR, " + COL_5 + " VARCHAR, " + COL_6 + " INTEGER, " + COL_7 + " INTEGER, " + COL_8 + " INTEGER);");
        db.execSQL("CREATE TABLE " + TABLE_NAME_MY_ORDERS + " (" + COL_3 + " INTEGER, " + COL_9 + " VARCHAR);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_FAVORITES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_CART);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_MY_ORDERS);
        onCreate(db);
    }

    // Insert Data in My Orders
    public boolean insertMyOrders(items items) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_3, items.getlPrice());
        contentValues.put(COL_9, items.getlPayment());

        long result = db.insert(TABLE_NAME_MY_ORDERS, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    // Insert Data in favorites table
    public boolean insertData(items items) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, items.getlImageId());
        contentValues.put(COL_2, items.getlName());
        contentValues.put(COL_3, items.getlPrice());
        contentValues.put(COL_4, items.getlDetails());
        contentValues.put(COL_5, items.getlModel());
        contentValues.put(COL_6, items.getlImageId1());
        contentValues.put(COL_7, items.getlImageId2());
        contentValues.put(COL_8, items.getQuantity());

        long result = db.insert(TABLE_NAME_FAVORITES, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    // Insert Data in cart table
    public boolean insertDataCart(items items) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, items.getlImageId());
        contentValues.put(COL_2, items.getlName());
        contentValues.put(COL_3, items.getlPrice());
        contentValues.put(COL_4, items.getlDetails());
        contentValues.put(COL_5, items.getlModel());
        contentValues.put(COL_6, items.getlImageId1());
        contentValues.put(COL_7, items.getlImageId2());
        contentValues.put(COL_8, items.getQuantity());

        long result = db.insert(TABLE_NAME_CART, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    // See Data My Orders
    public ArrayList<items> getAllDataMyOrders() {
        ArrayList<items> myOrders = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME_MY_ORDERS, null);

        while (res.moveToNext()) {
            int price = res.getInt(0);
            String payment = res.getString(1);

            items newItems = new items(price, payment);
            myOrders.add(newItems);
        }
        return myOrders;
    }

    // See Data Favorites
    public ArrayList<items> getAllData() {
        ArrayList<items> favItem = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME_FAVORITES, null);

        while (res.moveToNext()) {
            int img = res.getInt(0);
            String name = res.getString(1);
            int price = res.getInt(2);
            String details = res.getString(3);
            String model = res.getString(4);
            int img1 = res.getInt(5);
            int img2 = res.getInt(6);
            int quantity = res.getInt(7);

            items newItems = new items(name, price, img, img1, img2, details, model, quantity);
            favItem.add(newItems);
        }
        return favItem;
    }

    // See Data Cart
    public ArrayList<items> getAllDataCart() {
        ArrayList<items> favItem = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME_CART, null);

        while (res.moveToNext()) {
            int img = res.getInt(0);
            String name = res.getString(1);
            int price = res.getInt(2);
            String details = res.getString(3);
            String model = res.getString(4);
            int img1 = res.getInt(5);
            int img2 = res.getInt(6);
            int quantity = res.getInt(7);
            items newItems = new items(name, price, img, img1, img2, details, model, quantity);
            favItem.add(newItems);
        }
        return favItem;
    }

    // Delete Data Favorites
    public void deleteFavorite(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME_FAVORITES, COL_1 + "=" + id, null);
    }

    // Delete Data Cart
    public void deleteCart(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME_CART, COL_1 + "=" + id, null);
    }

    // Update Cart Quantity
    public void updateDataCard(int id, int quantity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(COL_8, quantity);

        db.update(TABLE_NAME_CART, val, "IMAGE=" + id, null);

    }

    // See Total Price
    public int sumPriceCartItems() {
        int result = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select sum(" + COL_3 + " * " + COL_8 + ") from " + TABLE_NAME_CART, null);
        if (cursor.moveToFirst()) result = cursor.getInt(0);
        cursor.close();
        db.close();
        return result;
    }


}
