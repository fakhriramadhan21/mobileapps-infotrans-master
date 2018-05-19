package com.a4nesia.whatsappclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.a4nesia.whatsappclone.models.Data;
import com.a4nesia.whatsappclone.models.User;
import com.a4nesia.whatsappclone.services.APIService;
import com.a4nesia.whatsappclone.tools.Preferences;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView textNama, textStatus, textNomor;
    CircleImageView imgFoto;
    String TAG = "WA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNama = (TextView)findViewById(R.id.txt_nama);
        textStatus = (TextView)findViewById(R.id.txt_status);
        textNomor = (TextView) findViewById(R.id.txt_telpon);
        imgFoto = (CircleImageView)findViewById(R.id.foto);

        String nama = Preferences.getStringPreference("nama",getApplicationContext());
        String status = Preferences.getStringPreference("status",getApplicationContext());
        String no_telp = Preferences.getStringPreference("no_telp",getApplicationContext());
        textNama.setText(nama);
        textStatus.setText(status);
        textNomor.setText(no_telp);
        String username = Preferences.getStringPreference("username",getApplicationContext());
        final Call<User> userCall = APIService.service.getUser(username);
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    Log.d("WA","Berhasil");
                    User userResponse = response.body();
                    if(userResponse.getStatus().equals("success")){
                        Data user = userResponse.getData();
                        textNama.setText(user.getNama());
                        textStatus.setText(user.getStatus());
                        textNomor.setText(user.getNoTelp());

                        Preferences.setStringPreference("nama",user.getNama(),getApplicationContext());
                        Preferences.setStringPreference("status",user.getStatus(),getApplicationContext());
                        Preferences.setStringPreference("no_telp",user.getNoTelp(),getApplicationContext());
                        Picasso.get()
                                .load(user.getImg())
                                .into(imgFoto);
                    }
                }
                else{
                    Log.e("WA",response.message());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("WA",t.getMessage());
            }
        });



//        Call<User> userCall = APIService.service.getUser("baso");
//        userCall.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                if(response.isSuccessful()){
//                    User user= response.body();
//                    Toast.makeText(MainActivity.this, user.getMessage(), Toast.LENGTH_SHORT).show();
//                    if(user.getStatus().equals("success")){
//                        txtNama.setText(user.getData().getNama());
//                        txtStatus.setText(user.getData().getStatus());
//                        txtPhone.setText(user.getData().getNoTelp());
//                        Picasso.get()
//                                .load(user.getData().getImg())
//                                .into(img);
//                    }
//                    Log.e(TAG,"success");
//                }else{
//                    Log.e(TAG,"failed");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                Log.e(TAG,"ERROR");
//                Log.e(TAG,call.toString());
//                Log.e(TAG,t.getMessage());
//            }
//        });
    }
}
