package com.example.firoonet.test;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewBagerAdapter extends FragmentPagerAdapter{


    protected final List<Fragment> fragmentList = new ArrayList<>();
    protected final List<String> fragmentTittleList = new ArrayList<>();


    public ViewBagerAdapter(FragmentManager fm) {

        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return fragmentList.get(position);

    }

    @Override
    public int getCount() {

        return fragmentTittleList.size();

    }

    @Override
    public CharSequence getPageTitle(int position) {

        return fragmentTittleList.get(position);

    }

    public void addFragment(Fragment fragment, String tittle){

        fragmentList.add(fragment);
        fragmentTittleList.add(tittle);

    }
}
