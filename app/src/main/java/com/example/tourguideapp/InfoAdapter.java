package com.example.tourguideapp;

import android.content.Context;
import android.support.v4.app.INotificationSideChannel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


/*
    InfoAdapter is an ArrayAdapter that can provide the layout for each list item based on a data source, which is a list of Info object
 */

public class InfoAdapter extends ArrayAdapter<Info> {

    /*
        Create a new InfoAdapter object
     */
    public InfoAdapter(Context context, ArrayList<Info> infoArrayList) {
        super(context, 0, infoArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if an existing view is being reused , otherwise inflate view
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.info_item,parent,false);
        }

        // Get the object position
        Info currentInfo = getItem(position);

        // Find a TextView for name and set a name for current object
        TextView nameTextView = listItemView.findViewById(R.id.textView_name);
        nameTextView.setText(currentInfo.getName());

        // Find a TextView for description and set a description for current object
        TextView descriptionTextView = listItemView.findViewById(R.id.textView_description);
        descriptionTextView.setText(currentInfo.getDescription());

        // Find a ImageView and set an image for current object
        ImageView imageView = listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentInfo.getImageResourceID());

        // Return the whole info_item , so it can be shown in a ListView
        return listItemView;
    }
}
