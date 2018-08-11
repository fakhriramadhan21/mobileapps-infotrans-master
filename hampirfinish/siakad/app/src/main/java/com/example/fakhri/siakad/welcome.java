package com.example.fakhri.siakad;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class welcome extends NavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_welcome, null, false);

        drawerLayout.addView(contentView,0);
    }
    public void beranda(View view) {
        startActivity(new Intent(getApplicationContext(),beranda.class));
    }
}
