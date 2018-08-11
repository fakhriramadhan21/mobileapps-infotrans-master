package com.example.fakhri.siakad;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

public class RegistrationPagerAdapter extends FragmentStatePagerAdapter {

    private int number_tabs;

    public RegistrationPagerAdapter(FragmentManager fm, int number_tabs){
        super(fm);
        this.number_tabs = number_tabs;
    }

    //Mengembalikan Fragment yang terkait dengan posisi tertentu
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Employee();
            case 1:
                return new Student();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return number_tabs;
    }
}
