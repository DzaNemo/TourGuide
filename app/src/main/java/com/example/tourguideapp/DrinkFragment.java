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
public class DrinkFragment extends Fragment {


    public DrinkFragment() {
        // OBAVEZNO IMATI
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.info_list, container, false);

        final ArrayList<Info> infos = new ArrayList<>();
        infos.add(new Info(getString(R.string.coffee_shop_1),R.drawable.coffee_shop_2,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.coffee_shop_1),R.drawable.coffee_shop_1,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.coffee_shop_1),R.drawable.coffee_cafe_fast_food,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.coffee_shop_1),R.drawable.coffee_cafe_fast_food,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.coffee_shop_1),R.drawable.cafe_3,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.coffee_shop_1),R.drawable.cafe_4,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.coffee_shop_1),R.drawable.cafe_5,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.coffee_shop_1),R.drawable.cafe_6,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.coffee_shop_1),R.drawable.cafe_7,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.coffee_shop_1),R.drawable.cafe_8,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.coffee_shop_1),R.drawable.cafe_9,getString(R.string.info_description)));

        // create an Adapter and populate data from ArrayList with rules created on InfoAdapter
        InfoAdapter adapter = new InfoAdapter(getActivity(), infos);

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