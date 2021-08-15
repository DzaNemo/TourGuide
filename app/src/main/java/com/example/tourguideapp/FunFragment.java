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

/*
    this fragment displays a list of sport, fun activities that someone could enjoy
 */
public class FunFragment extends Fragment {


    public FunFragment() {
        // Required empty public constructor -OBAVEZNO-
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.info_list, container, false);

        // Create list of fun fragment
        final ArrayList<Info> infos = new ArrayList<>();
        infos.add(new Info(getString(R.string.fun),R.drawable.fishing,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.fun),R.drawable.cycling,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.fun),R.drawable.foto,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.fun),R.drawable.horseriding,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.fun),R.drawable.iceskating,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.fun),R.drawable.yoga,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.fun),R.drawable.motocross,getString(R.string.info_description)));
        infos.add(new Info(getString(R.string.fun),R.drawable.skateboard,getString(R.string.info_description)));

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