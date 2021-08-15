
package com.example.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FoodFragment extends Fragment {

    public FoodFragment() {
        // OBAVEZNO IMATI
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.info_list, container, false);

        final ArrayList<Info> infos = new ArrayList<>();
        infos.add(new Info(getString(R.string.restaurants_1),R.drawable.poachedegg_food_4561643,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.restaurants_1),R.drawable.taco_155812_1280,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.restaurants_1),R.drawable.pizza_23477_1280,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.restaurants_1),R.drawable.pizza_155771_1280,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.restaurants_1),R.drawable.hamburger_31775_640,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.restaurants_1),R.drawable.sandwich_311262_1280,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.restaurants_1),R.drawable.hamburgers_576307_1280,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.restaurants_1),R.drawable.hamburger_31775_640,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.restaurants_1),R.drawable.bread_1296280_1280,getString(R.string.info_description)));


        // create an Adapter and populate data from ArrayList with rules created on InfoAdapter
        InfoAdapter adapter = new InfoAdapter(getActivity(),infos);

        // find listview and bind listview and adapter to show data from list
        final ListView listView = rootView.findViewById(R.id.info_listView);
        listView.setAdapter(adapter);

        // set onClickListener that can be clicked on items and show data in new activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = listView.getContext();
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("name", infos.get(position).getName());
                intent.putExtra("image",infos.get(position).getImageResourceID());
                intent.putExtra("description", infos.get(position).getDescription());
                context.startActivity(intent);
            }
        });

        return rootView;
    }
}