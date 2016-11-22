package com.example.root.portalproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.root.portalproject.MainActivity.status;

public class InputBerita extends AppCompatActivity {
    DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference();
    String result;
    Button btnTambah;
    EditText TxtTitle,TxtIsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_berita);
        SharedPreferences data = getSharedPreferences("Data", Context.MODE_PRIVATE);
        status = data.getString("status","");
        if(status.isEmpty()){
            Intent Pindah = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(Pindah);
        }

        btnTambah = (Button) findViewById(R.id.tambah);
        TxtTitle  = (EditText) findViewById(R.id.TitleText);
        TxtIsi    = (EditText) findViewById(R.id.IsiText);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TextTitles = TxtTitle.getText().toString();
                String TextIsiw   = TxtIsi.getText().toString();
                if(TextIsiw.isEmpty() || TextTitles.isEmpty()){
                    Toast.makeText(InputBerita.this, "Masukan Data Dengan Benar", Toast.LENGTH_SHORT).show();
                } else {
                    mRoot.child("Berita").child(TextTitles).child("content").setValue(TextIsiw);
                        Toast.makeText(InputBerita.this, "Suksess gans", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
