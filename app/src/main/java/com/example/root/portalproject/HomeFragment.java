package com.example.root.portalproject;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    DatabaseReference mRoot   = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mBerita = mRoot.child("Berita");
    ListView          Home;
    ArrayList<String> Isinya = new ArrayList<>();

    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View Default = inflater.inflate(R.layout.fragment_main, container, false);
        Home = (ListView) Default.findViewById(R.id.home_list);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getActivity(),android.R.layout.activity_list_item, android.R.id.text1,Isinya);
        Home.setAdapter(adapter);
        Home.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = adapter.getItem(position);
                final SharedPreferences sharedPreferences = getContext().getSharedPreferences("Data", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit       = sharedPreferences.edit();
                edit.putString("id",value);
                edit.commit();
                Intent intent = new Intent(getActivity(),Berita.class);
                startActivity(intent);

            }
        });
        mBerita.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String Dataa = dataSnapshot.getKey();

                Isinya.add(Dataa);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return Default;
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
}
