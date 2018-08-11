package com.example.fakhri.siakad;

import android.content.Intent;
import android.renderscript.Sampler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NavigationActivity extends AppCompatActivity {

    private Toolbar toolbar;
    protected DrawerLayout drawerLayout;
    private NavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);


        //Menginisiasi Navigation View
        navigationView = (NavigationView)findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //Memeriksa apakah item tersebut dalam keadaan click atau tidak
                if (menuItem.isChecked())menuItem.setChecked(false);
                else menuItem.setChecked(true);
                //Menutup drawer item click
                drawerLayout.closeDrawers();
                //Memeriksa untuk melihat item yang akan di klik dan melakukan aksu
                switch (menuItem.getItemId()){
                    //pilihan utem menu navigasi akan menampilkan pesan Toast klik, kita bisa menggantinya dengan Intent activity
                    case R.id.info:
                        Toast.makeText(getApplicationContext(), "Information telah dipilih", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),beranda.class));
                        return true;
                    case R.id.forum:
                        Toast.makeText(getApplicationContext(), "Forum telah dipilih", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),Forum.class));
                        return true;
                    case R.id.score:
                        Toast.makeText(getApplicationContext(), "Score telah dipilih", Toast.LENGTH_SHORT).show();

                        return true;
                    case R.id.pract_work:
                        Toast.makeText(getApplicationContext(), "Practical Work telah dipilih", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.presence:
                        Toast.makeText(getApplicationContext(), "Presence telah dipilih", Toast.LENGTH_SHORT).show();

                        return true;

                    case R.id.setting:
                        Toast.makeText(getApplicationContext(), "Setting telah dipilih", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        Toast.makeText(getApplicationContext(), "Kesalahan", Toast.LENGTH_SHORT).show();
                        return true;
                }
             }
        });

        //Menginisiasi Drawer Layout
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,
                R.string.openDrawer, R.string.closeDrawer){
            @Override
            public void onDrawerClosed(View drawerView){
                //Kode disini aka merespon setelah drawer menutup, disini kita biarkan kosong
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView){
                //Kode disini akan merespon setelah drawer terbuka, disini kita biarkan kosong
                super.onDrawerOpened(drawerView);


            }
        };
        //Mensettng actionBarToggle untuk drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        //Memanggil syntState
        actionBarDrawerToggle.syncState();
    }


}
