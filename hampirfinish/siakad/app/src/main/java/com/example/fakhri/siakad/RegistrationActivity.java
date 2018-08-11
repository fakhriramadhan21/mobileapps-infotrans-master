package com.example.fakhri.siakad;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class RegistrationActivity extends NavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_registration, null, false);

        drawerLayout.addView(contentView,0);

        //Menerapkan TabLayout dan ViewPager pada Activity
        final TabLayout TAB_LAYOUT = findViewById(R.id.tab_Layout);
        final ViewPager VIEW_PAGER = findViewById(R.id.pager);

        //Memanggil dan memasukkan value pada class RegistrationPagerAdapter(FragmentManager dam Jumlah Tab)
        RegistrationPagerAdapter registrationPagerAdapter = new RegistrationPagerAdapter(getSupportFragmentManager(), TAB_LAYOUT.getTabCount());

        //Memasang Adapter pada ViewPager
        VIEW_PAGER.setAdapter(registrationPagerAdapter);

        /*
        Menambah listener yang akan dipanggil kapan pun halama berubah atau
        bergulir secara bertahap, sehingga tab tetap dinkron
         */
        VIEW_PAGER.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(TAB_LAYOUT));

        //Vallback Interface dipanggil saat status pilihan tab berubah
        TAB_LAYOUT.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //Dipanggil ketika tab memasuki state/keadaan yang dipilih
                VIEW_PAGER.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //Dipanggil saat tab keluar dari keadaan yang dipilih
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //Dipanggil ketika tab yang sudah dipilih, dipilih lagi oleh user
            }
        });
    }
}
