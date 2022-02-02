package com.mihaelmarjanovic.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.net.MalformedURLException;

public class MainActivity extends AppCompatActivity {

        private ViewPager mViewPager;
        private TabLayout mTabLayout;


        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            initViews();
            setUpPager();
        }

        private void setUpPager () {
            PagerAdapter pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
            mViewPager.setAdapter(pagerAdapter);
            mTabLayout.setupWithViewPager(mViewPager);
        }

        private void initViews () {
            mViewPager = findViewById(R.id.viewPager);
            mTabLayout = findViewById(R.id.tab);

        }
    }

