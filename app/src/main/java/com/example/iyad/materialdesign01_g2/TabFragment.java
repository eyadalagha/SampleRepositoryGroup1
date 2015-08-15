package com.example.iyad.materialdesign01_g2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by iyad on 8/11/2015.
 */
public class TabFragment extends Fragment {

    SlidingTabLayout tabLayout;
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tabLayout = (SlidingTabLayout) this.getView().findViewById(R.id.tabLayout);
        viewPager = (ViewPager) this.getView().findViewById(R.id.viewPager);

        List<Fragment> fragments = new ArrayList<Fragment>();

        PhotoFragment f1 = new PhotoFragment();
        Bundle b1 = new Bundle();
        b1.putInt("ImageResource", R.drawable.f1);
        f1.setArguments(b1);
        fragments.add(f1);

        PhotoFragment f2 = new PhotoFragment();
        Bundle b2 = new Bundle();
        b2.putInt("ImageResource", R.drawable.f2);
        f2.setArguments(b2);
        fragments.add(f2);

        PhotoFragment f3 = new PhotoFragment();
        Bundle b3 = new Bundle();
        b3.putInt("ImageResource", R.drawable.f3);
        f3.setArguments(b3);
        fragments.add(f3);

        List<String> titles = Arrays.asList("Tab 1", "Tab 2", "Tab 3");
        List<Drawable> icons = new ArrayList<Drawable>();
        icons.add(this.getResources().getDrawable(R.drawable.f1));
        icons.add(this.getResources().getDrawable(R.drawable.f2));
        icons.add(this.getResources().getDrawable(R.drawable.f3));

        MyViewPagerAdapter adapter = new MyViewPagerAdapter(fragments, titles, icons, this.getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setDistributeEvenly(true);
        tabLayout.setBackgroundColor(this.getResources().getColor(R.color.primary_light));
        tabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.primary_dark);
            }
        });
        tabLayout.setCustomTabView(R.layout.custom_tab_layout, R.id.tabText);
        tabLayout.setViewPager(viewPager);
    }
}
