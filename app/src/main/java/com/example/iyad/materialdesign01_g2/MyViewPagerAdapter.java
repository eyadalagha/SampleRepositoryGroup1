package com.example.iyad.materialdesign01_g2;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import java.util.List;

/**
 * Created by iyad on 8/11/2015.
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter{

    List<Fragment> fragments;
    List<String> titles;
    List<Drawable> icons;

    public MyViewPagerAdapter(List<Fragment> fragments, List<String> titles, List<Drawable> icons, FragmentManager fm) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
        this.icons = icons;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        Drawable d = icons.get(position);
        d.setBounds(0,0,100,100);
        ImageSpan imageSpan = new ImageSpan(d);
        SpannableString s = new SpannableString("    ");
        s.setSpan(imageSpan, 0,3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return s;
        //return titles.get(position);
    }
}
