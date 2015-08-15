package com.example.iyad.materialdesign01_g2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by iyad on 8/1/2015.
 */
public class NavigationDrawerFragment extends Fragment{

    NavigationDrawerListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nav_drawer_layout, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof NavigationDrawerListener){
            listener = (NavigationDrawerListener) activity;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button btn = (Button) this.getView().findViewById(R.id.navButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null)
                    listener.rvButtonPressed();
            }
        });


    }

    public interface NavigationDrawerListener{
        public void rvButtonPressed();
    }
}
