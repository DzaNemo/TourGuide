package com.example.tourguideapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        // ViewPager allows the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.viewPager);


        // create an adapter that knows which fragment should be shown on each page , than set adapter to to view pager
        CategoryAdapter categoryAdapter = new CategoryAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(categoryAdapter);

        // set a tab to a viewpager
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }
}
