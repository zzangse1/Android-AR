package com.example.licenta.AR;

import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.licenta.R;
import com.example.licenta.SQLite.DatabaseHelper;
import com.example.licenta.adapter.favoritesItemsAdapterForArCamera;
import com.example.licenta.adapter.items;
import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;
import java.util.ArrayList;

public class favoritesAr extends AppCompatActivity {

    private DatabaseHelper favoriteDbHelper;
    private ArrayList<items> item;
    private ListView listView;
    private favoritesItemsAdapterForArCamera myAdapter;
    private ArFragment arFragment;
    public Uri modelSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_camera_favorites);

        getSupportActionBar().setTitle("Camera AR");

        listView = (ListView) findViewById(R.id.favorites_camera_ar_list_view);

        favoriteDbHelper = new DatabaseHelper(this);

        item = favoriteDbHelper.getAllData();

        myAdapter = new favoritesItemsAdapterForArCamera(item, this);

        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                items e = item.get(position);
                String model = e.getlModel();
                modelSelected=Uri.parse(model);
                arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.ux_sceneform_favorites);
                arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
                    renderModel(hitResult.createAnchor());
                });
            }
        });

    }

    private void renderModel(Anchor anchor) {
        ModelRenderable.builder().setSource(this, modelSelected).build().thenAccept(modelRenderable -> {
            placeModel(modelRenderable,anchor);
        });
    }

    private void placeModel(ModelRenderable modelRenderable, Anchor anchor) {
        AnchorNode anchorNode = new AnchorNode(anchor);

        //Code for resize and move
        TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
        transformableNode.setParent(anchorNode);
        transformableNode.setRenderable(modelRenderable);

        arFragment.getArSceneView().getScene().addChild(anchorNode);
        transformableNode.select();

    }
}
