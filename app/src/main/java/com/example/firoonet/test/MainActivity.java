package com.example.firoonet.test;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPager viewpagerImageSlide;
    SlideShowAdapter slideShowAdapter;
    CircleIndicator indicator;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Handler handler;
    Runnable runnable;
    Timer timer;
    RecyclerView recyclerView;

    String [] text = {

            "Text1",
            "Text2",
            "Text3",
            "Text4",
            "Text5",
            "Text6",
            "Text7",
            "Text8",
            "Text9",
            "Text10",
            "Text11",

    };

    int [] img = {

            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9,
            R.drawable.image10,
            R.drawable.image11,

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        // to add toolbar tittle
        toolbar = (Toolbar) findViewById(R.id.toolBar_id);
        setSupportActionBar(toolbar);


        // add slideShowImages code

        viewpagerImageSlide = (ViewPager) findViewById(R.id.viewPager_imageSlide_id);

        indicator = (CircleIndicator) findViewById(R.id.circleIndicator);

        slideShowAdapter = new SlideShowAdapter(this);

        viewpagerImageSlide.setAdapter(slideShowAdapter);

        indicator.setViewPager(viewpagerImageSlide);


        // add timer to image slide

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {

                int i = viewPager.getCurrentItem();

                if (i == slideShowAdapter.images.length - 1) {

                    i = 0;
                    viewPager.setCurrentItem(i, true);

                } else {

                    i++;
                    viewPager.setCurrentItem(i, true);
                }
            }
        };

        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                handler.post(runnable);

            }
        }, 4000, 4000);



        //to add item on tablayout

        ViewBagerAdapter adapter = new ViewBagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new OneFragment(), "ONE");
        adapter.addFragment(new TwoFragment(), "TWO");
        adapter.addFragment(new ThreeFragment(), "THREE");

        viewPager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout_id);

        //to content viewPager on tabLayout
        tabLayout.setupWithViewPager(viewPager);


        // Navigation Drawer code

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        // this to open navigationDrawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_navigation, R.string.close_navigation);
        drawerLayout.setDrawerListener(toggle);

        toggle.syncState();

        // to add on_click_listener to navigation drawer
        navigationView.setNavigationItemSelectedListener(this);



        // Recycler View code

        recyclerView = (RecyclerView) findViewById(R.id.recycleView_id);

        List<RecyclerUser> sampleUser = new ArrayList<>();

        for (int i=0; i<text.length; i++){

            RecyclerUser user = new RecyclerUser();

            user.recyclerText = text[i];
            user.recyclerImage = img[i];

            sampleUser.add(user);

        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new RecyclerAdapter(sampleUser, getBaseContext()));




    }

    // method onBack that when I click back if navigation is opened , navigation closed first then close application
    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {

            drawerLayout.closeDrawer(GravityCompat.START);

        } else {

            super.onBackPressed();

        }
    }

    // method on click listener
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id) {

            case R.id.main_id:

                Toast.makeText(getApplicationContext(), "main", Toast.LENGTH_LONG).show();

                break;

            case R.id.policy_id:

                Toast.makeText(getApplicationContext(), "plicy", Toast.LENGTH_LONG).show();

                break;

            case R.id.sport_id:

                Toast.makeText(getApplicationContext(), "sport", Toast.LENGTH_LONG).show();

                break;

        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;

    }

}
