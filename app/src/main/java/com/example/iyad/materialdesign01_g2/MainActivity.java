package com.example.iyad.materialdesign01_g2;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity implements NavigationDrawerFragment.NavigationDrawerListener {

    ArrayList<Employee> list = new ArrayList<Employee>();

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    LinearLayout mainContentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //

        final Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolBar);
        this.setSupportActionBar(toolbar);

        mainContentLayout = (LinearLayout) this.findViewById(R.id.mainContentLayout);

        drawerLayout = (DrawerLayout) this.findViewById(R.id.drawerLayout);


        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Toast.makeText(getApplicationContext(), "closed",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Toast.makeText(getApplicationContext(), "open",Toast.LENGTH_LONG).show();


            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                //toolbar.setAlpha(1- slideOffset);
                mainContentLayout.setTranslationX(drawerView.getWidth()* slideOffset);
            }
        };
        drawerLayout.setDrawerListener(toggle);
        drawerLayout.post(new Runnable(){

            @Override
            public void run() {
                toggle.syncState();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        RecyclerViewFragment rvf = new RecyclerViewFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.mainContentFrame, rvf, "rvf").commit();
        drawerLayout.closeDrawer(GravityCompat.START);

        FloatingActionButton fb1 = (FloatingActionButton) this.findViewById(R.id.menu_item1);
        fb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Hello World",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if(id == R.id.nextActivity){
            Intent intent = new Intent(this, SecondActivity.class);
            this.startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void rvButtonPressed() {
        //RecyclerViewFragment rvf = new RecyclerViewFragment();
        TabFragment rvf = new TabFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.mainContentFrame, rvf, "rvf").commit();
        drawerLayout.closeDrawer(GravityCompat.START);
    }
}
