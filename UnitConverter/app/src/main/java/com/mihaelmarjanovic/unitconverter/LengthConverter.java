package com.mihaelmarjanovic.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LengthConverter extends AppCompatActivity {

    EditText etLength;
    TextView tvConvertedLength;
    Button btnConvertLength;

    private String formatter;
    private String inputLength;
    private String outputLength;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter_length);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerLength);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Length_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                inputLength = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Spinner spinner2 = (Spinner) findViewById(R.id.spinnerLength2);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                outputLength = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        etLength = findViewById(R.id.etLength);
        tvConvertedLength = findViewById(R.id.tvConvertedLength);
        btnConvertLength = findViewById(R.id.btnConvertLength);

        btnConvertLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String InputValue = etLength.getText().toString();

                if (InputValue.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a value!", Toast.LENGTH_SHORT).show();
                }

                else if(inputLength.equals(outputLength)){
                    tvConvertedLength.setText(etLength.getText().toString());
                }

                else if(inputLength.equals("Kilometer")){

                    if(outputLength.equals("Meter")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 1000;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.01)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Centimeter")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 100000;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Milimetre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 1e+06;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Micrometre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 1e+09;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Nanometre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 1e+12;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Mile")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 1.609;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Yard")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 1094;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Foot")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 3281;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Inch")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 39370;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }
                }

                else if(inputLength.equals("Meter")){

                    if(outputLength.equals("Kilometer")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 1000;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Centimeter")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 100;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Milimetre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 1000;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Micrometre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 1e+06;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Nanometre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 1e+09;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Mile")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 1609;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Yard")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 1.094;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Foot")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 3.281;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Inch")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 39.37;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }
                }


                else if(inputLength.equals("Centimeter")){

                    if(outputLength.equals("Meter")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 100;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Kilometer")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 100000;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Milimetre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 10;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Micrometre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 10000;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Nanometre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 1e+07;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Mile")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 160934;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Yard")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 91.44;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Foot")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 30.48;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Inch")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 2.54;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }
                }

                else if(inputLength.equals("Milimetre")){

                    if(outputLength.equals("Meter")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 1000;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Kilometer")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 1E+06;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Centimeter")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 10;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Micrometre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 1000;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Nanometre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 1e+06;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Mile")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 1.609e+06;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Yard")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 914;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Foot")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 305;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Inch")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 25.4;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }
                }

                else if(inputLength.equals("Micrometre")){

                    if(outputLength.equals("Meter")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 1e+06;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Kilometer")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 1e+09;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Centimeter")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 10000;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Milimetre")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 1000;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Nanometre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 1000;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Mile")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 1.609e+09;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Yard")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 914400;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Foot")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 304800;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Inch")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 25400;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }
                }

                else if(inputLength.equals("Nanometre")){

                    if(outputLength.equals("Meter")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 1e+09;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Kilometer")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 1e+12;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Centimeter")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 1e+07;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Milimetre")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 1e+06;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Micrometre")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 1000;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Mile")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 1.609e+12;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Yard")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 9.144e+08;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Foot")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 3.048e+08;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Inch")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 2.54e+07;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }
                }

                else if(inputLength.equals("Mile")){

                    if(outputLength.equals("Meter")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 1609;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Kilometer")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 1.609;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Centimeter")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 160934;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Milimetre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 1.609e+06;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Micrometre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 1.609e+09;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Nanometre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 1.609e+12;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Yard")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 1760;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Foot")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 5280;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Inch")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 63360;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }
                }

                else if(inputLength.equals("Yard")){

                    if(outputLength.equals("Meter")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 1.094;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Kilometer")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 1094;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Centimeter")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 91.44;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Milimetre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 914;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Micrometre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 914400;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Nanometre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 9.144e+8;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Mile")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 1760;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Foot")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 3;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Inch")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 36;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }
                }

                else if(inputLength.equals("Foot")){

                    if(outputLength.equals("Meter")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 3.281;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Kilometer")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 3281;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Centimeter")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 30.48;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Milimetre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 305;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Micrometre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 304800;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Nanometre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 3.048e+08;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Mile")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 5280;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Yard")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 3;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Inch")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 12;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }
                }

                else if(inputLength.equals("Inch")){

                    if(outputLength.equals("Meter")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 39.37;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Kilometer")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 39370;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Centimeter")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 2.54;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Milimetre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 25.4;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Micrometre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 25400;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Nanometre")){
                        double ConvertedValue = Float.parseFloat(InputValue) * 2.54e+07;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Mile")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 63360;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Foot")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 12;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }

                    else if(outputLength.equals("Yard")){
                        double ConvertedValue = Float.parseFloat(InputValue) / 36;
                        if(ConvertedValue>=100000 || ConvertedValue<=0.001)
                            formatter = "%.4E";
                        else
                            formatter = "%.4f";
                        String FormattedValue = String.format(formatter, ConvertedValue);
                        tvConvertedLength.setText(FormattedValue);
                    }
                }

            }
        });
    }
}
