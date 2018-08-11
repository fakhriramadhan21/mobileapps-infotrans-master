package id.ceolabs.superizqi.infotrans;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void to_daftar(View v){
        Intent i = new Intent(login.this,daftar.class);
        startActivity(i);
        finish();
    }

    public void to_pilih_kota(View v){
        Intent i = new Intent(login.this,pilih_kota.class);
        startActivity(i);
        finish();
    }




}
