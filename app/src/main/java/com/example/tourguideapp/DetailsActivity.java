package com.example.tourguideapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;

/*
    this activity displaying the details of each item from the list of Info objects
 */
public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_info);

        // set up the toolbar to prepare for collapsing effect
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // receive intents send from selected items (clicked items)
        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");
        int image = intent.getExtras().getInt("image");
        String description = intent.getExtras().getString("description");
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        // show name of item when collapse
        collapsingToolbar.setTitle(name);

        // set image for the selected item
        ImageView imageView = findViewById(R.id.backdrop);
        Glide.with(this).load(image).apply(RequestOptions.centerCropTransform()).into(imageView);

        // set the description for selected item
        TextView descriptionTextView = findViewById(R.id.tv_description);
        descriptionTextView.setText(description);
    }

}