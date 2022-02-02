package com.mihaelmarjanovic.unitconverter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.Locale;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        private static final int NUM_PAGES = 3;
        private static final String BASE_NAME = "Converter";

        public ScreenSlidePagerAdapter(FragmentManager fm){
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:return CommonFragment.newInstance();
                case 1:return EngineeringFragment.newInstance();
                default:return MathsFragment.newInstance();
            }
        }

        @Nullable
        public CharSequence getPageTitle(int position){
            if (position == 0) {
                return String.format(Locale.getDefault(), "Common " + BASE_NAME );
            }
            else if(position == 1) {
                return String.format(Locale.getDefault(), "Enginnering  " + BASE_NAME );
            }
            else{
                return String.format(Locale.getDefault(), "Maths  " + BASE_NAME );
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }


