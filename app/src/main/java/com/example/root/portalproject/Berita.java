package com.example.root.portalproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class Berita extends AppCompatActivity {
    DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference();
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);
        text  = (TextView) findViewById(R.id.Berita);
        SharedPreferences data = getSharedPreferences("Data", Context.MODE_PRIVATE);
        String id = data.getString("id","");
        if(id.isEmpty()){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
        setTitle(id);
        mRoot.child("Berita").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String Berita = dataSnapshot.child("content").getValue().toString();
                text.setText(Berita);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
