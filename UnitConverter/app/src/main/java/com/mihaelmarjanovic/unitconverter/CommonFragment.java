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

public class CommonFragment extends Fragment {
    private Button btnFragmentCurrency;
    private Button btnFragmentLength;
    public static CommonFragment newInstance() {
        CommonFragment fragment = new CommonFragment();
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_common, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnFragmentCurrency = view.findViewById(R.id.btnFragmentCurrency);
        btnFragmentLength = view.findViewById(R.id.btnFragmentLength);
        btnFragmentCurrency.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                System.out.println("Button clicked");

                Intent activityIntent = new Intent(getContext(), CurrencyConverter.class);
                startActivity(activityIntent);
            }
        });
        btnFragmentLength.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                System.out.println("Button clicked");

                Intent activityIntent = new Intent(getContext(), LengthConverter.class);
                startActivity(activityIntent);
            }
        });
    }
}
