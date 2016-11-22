package com.example.root.portalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InputBerita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_berita);
        Intent data = getIntent();
        String Status = data.getStringExtra("login");
        if(data.equals("success")){

        } else {
            Intent Pindah = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(Pindah);
        }
    }
}
