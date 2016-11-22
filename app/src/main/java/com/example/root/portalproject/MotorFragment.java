package com.example.root.portalproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MotorFragment extends Fragment {


    public MotorFragment() {



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Toast.makeText(getActivity(),"Motor",Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_motor, container, false);
    }

    public static MotorFragment newInstance() {
        return new MotorFragment();
    }

}
