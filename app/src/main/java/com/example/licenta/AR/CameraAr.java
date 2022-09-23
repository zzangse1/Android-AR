package com.example.licenta.AR;

import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import com.example.licenta.R;
import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class CameraAr extends AppCompatActivity {

    private ArFragment arFragment;
    public Uri modelSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_camera_single_item);

        getSupportActionBar().setTitle("Camera AR");

        modelS();

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.ux_sceneform);
        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
            renderModel(hitResult.createAnchor());
        });
    }

    private void modelS() {
        Bundle bundle = getIntent().getExtras();
        String uriModel = bundle.getString("ModelForAr");
        modelSelected=Uri.parse(uriModel);
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
