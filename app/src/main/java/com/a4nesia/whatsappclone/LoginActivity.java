package com.a4nesia.whatsappclone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.a4nesia.whatsappclone.models.User;
import com.a4nesia.whatsappclone.services.APIService;
import com.a4nesia.whatsappclone.tools.Preferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText editUsername, editPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean cekLogin = Preferences.getBooleanPreference("login",getApplicationContext());
        if(cekLogin){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_login);
        editUsername = (EditText)findViewById(R.id.username);
        editPassword = (EditText)findViewById(R.id.password);
    }
    public void login(View view){
        final String username = editUsername.getText().toString();
        String password = editPassword.getText().toString();
        if(username.equals("") || password.equals("")){
            Toast.makeText(this, "Username dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }else{
            Call<User> loginCall = APIService.service.login(username,password);
            loginCall.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if(response.isSuccessful()){
                        User userResponse = response.body();
                        if(userResponse.getStatus().equals("success")){
                            Preferences.setBooleanPreference("login",true,getApplicationContext());
                            Preferences.setStringPreference("username",userResponse.getData().getUsername(),getApplicationContext());
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                            finish();
                        }else {
                            Toast.makeText(LoginActivity.this, userResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Log.e("WA",t.getMessage());
                }
            });
        }
    }
}
