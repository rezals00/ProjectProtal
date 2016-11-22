package com.example.root.portalproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInstaller;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Config;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by root on 21/11/16.
 */

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText Username, Password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_layout);
        setTitle("Login");

        btnLogin = (Button) findViewById(R.id.btn_login);
        Username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTitle("Loggin In ..");
                if(Username.getText().toString().equals("admin") || Username.getText().toString().equals("admin")){
                    SharedPreferences sharedPreferences = LoginActivity.this.getSharedPreferences("Data",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor            = sharedPreferences.edit();
                    editor.putString("status","true");
                    editor.commit();

                    Intent Main = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(Main);
                } else {
                    Toast.makeText(getApplicationContext(),"Invalid Username Or Password",Toast.LENGTH_SHORT).show();
                }
                setTitle("Login");
            }

        });
    }
}
