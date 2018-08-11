package id.ceolabs.superizqi.infotrans;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class pilih_kota extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_kota);
    }

    public void to_pilih_transportasi(View v){
        Intent i = new Intent(pilih_kota.this,pilih_transportasi.class);
        startActivity(i);
    }
}
