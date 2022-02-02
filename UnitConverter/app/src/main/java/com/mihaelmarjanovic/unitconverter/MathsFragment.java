package com.mihaelmarjanovic.unitconverter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MathsFragment extends Fragment {
    private Button btnFragmentNumbers;
    public static MathsFragment newInstance() {
        MathsFragment fragment = new MathsFragment();
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_maths, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnFragmentNumbers = view.findViewById(R.id.btnFragmentNumbers);
        btnFragmentNumbers.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                System.out.println("Button clicked");

                Intent activityIntent = new Intent(getContext(), NumberConverter.class);
                startActivity(activityIntent);
            }
        });
    }
}
