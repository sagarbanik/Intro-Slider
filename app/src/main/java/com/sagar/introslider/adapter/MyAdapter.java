package com.sagar.introslider.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.sagar.introslider.Fragment1;
import com.sagar.introslider.Fragment2;
import com.sagar.introslider.Fragment3;


public class MyAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;
    FragmentManager fragmentManager;

    public MyAdapter(Context context, FragmentManager fragmentManager, int totalTabs) {
        super(fragmentManager);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                Fragment1 fragment1 = new Fragment1();
                return fragment1;

            case 1:
                Fragment2 fragment2 = new Fragment2();
                return fragment2;

            case 2:
                Fragment3 fragment3 = new Fragment3();
                return fragment3;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
