package com.example.licenta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.licenta.SQLite.DatabaseHelper;
import com.example.licenta.adapter.cartItemRecyclerView;
import com.example.licenta.adapter.items;
//import com.example.licenta.checkout.checkout;
import java.util.ArrayList;

public class cart extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private ArrayList<items> item;
    private cartItemRecyclerView cartItemRecyclerView;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView showTotalSum;
    private Button checkoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);

        getSupportActionBar().setTitle("Shopping Cart");

        checkoutBtn = (Button) findViewById(R.id.cart_checkout_btn);
        showTotalSum = (TextView) findViewById(R.id.total_price);
        recyclerView = (RecyclerView) findViewById(R.id.cart_recycler);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.cart_sweipe_refresh_layout);

        // Get cart items from database and display them on recyclerView
        dbHelper = new DatabaseHelper(this);
        item = dbHelper.getAllDataCart();

        cartItemRecyclerView = new cartItemRecyclerView(item, dbHelper, this);
        recyclerView.setAdapter(cartItemRecyclerView);
        cartItemRecyclerView.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // refresh layout
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                finish();
                startActivity(getIntent());
            }
        });

        // set total price for cart items
        showTotalSum.setText(dbHelper.sumPriceCartItems() + " $");

//        // action
//        checkoutBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(cart.this, checkout.class);
//                startActivity(intent);
//            }
//        });

    }


}
