package com.example.iyad.materialdesign01_g2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by iyad on 8/11/2015.
 */
public class PhotoFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.photo_fragment_layout, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageView im = (ImageView) this.getView().findViewById(R.id.pagerPhoto);
        if(this.getArguments() != null){
            int imageResource = this.getArguments().getInt("ImageResource");
            im.setImageResource(imageResource);
        }
    }
}
