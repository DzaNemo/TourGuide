package com.example.tourguideapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    // context of the app
    private Context mContext;

    /*
    constructor , create a new object
    context is context of the app, fm is the fragment manager that will keep each fragment's state int the adapter across swipes
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /* return fragment that should be displayed for the given page number

    0 = accommodation
    1 = food
    2 = drink
    3 = fun

    */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new AccommodationFragment();
        }else if (position == 1){
            return new FoodFragment();
        }else if(position == 2){
            return new DrinkFragment();
        }else {
            return new FunFragment();
        }
    }

    // return total number of pages (number of fragments - 0,1,2,3)
    @Override
    public int getCount() {
        return 4;
    }

    // Get the title of the fragment
    public CharSequence getPageTitle(int position){
        if (position == 0){
            return mContext.getString(R.string.accommodation);
        }else if (position == 1){
           return mContext.getString(R.string.food);
        }else if (position == 2){
            return mContext.getString(R.string.drink);
        }else {
            return mContext.getString(R.string.fun);
        }
    }
}
