package com.example.root.portalproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
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
        Intent Intent = getIntent();
        String id = Intent.getStringExtra("id");
        String Berita = Intent.getStringExtra("berita");
        if(id.isEmpty()){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
        setTitle(id);

        final WebView wb = new WebView(getApplicationContext());
        wb.loadDataWithBaseURL(null, Berita, "text/html", "utf-8",null);
        setContentView(wb);
    }
}
