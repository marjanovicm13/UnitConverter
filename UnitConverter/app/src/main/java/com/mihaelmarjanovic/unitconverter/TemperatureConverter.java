package com.mihaelmarjanovic.unitconverter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TemperatureConverter extends AppCompatActivity {

    EditText etTemperature;
    TextView tvConvertedTemperature;
    Button btnConvertTemperature;

    private String inputTemp;
    private String outputTemp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter_temperature);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerTemperature);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Temperature_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                inputTemp = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Spinner spinner2 = (Spinner) findViewById(R.id.spinnerTemperature2);
        spinner2.setAdapter(adapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                outputTemp = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        etTemperature = findViewById(R.id.etTemperature);
        tvConvertedTemperature = findViewById(R.id.tvConvertedTemperature);
        btnConvertTemperature = findViewById(R.id.btnConvertTemperature);
        btnConvertTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String InputValue = etTemperature.getText().toString();

                if(InputValue.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please enter a value!", Toast.LENGTH_SHORT).show();
                }

                else if(inputTemp.equals(outputTemp)){
                    tvConvertedTemperature.setText(etTemperature.getText().toString());
                }


                else if(inputTemp.equals("Celsius")){
                    if(outputTemp.equals("Fahrenheit")) {
                        double ConvertedValue = CelsiusToFahrenheit(Float.parseFloat(InputValue));
                        String FormattedValue = String.format("%.2f", ConvertedValue);
                        tvConvertedTemperature.setText(FormattedValue);
                    }
                    else if(outputTemp.equals("Kelvin")){
                        double ConvertedValue = CelsiusToKelvin(Float.parseFloat(InputValue));
                        String FormattedValue = String.format("%.2f", ConvertedValue);
                        tvConvertedTemperature.setText(FormattedValue);
                    }
                }


                else if(inputTemp.equals("Fahrenheit")){
                    if(outputTemp.equals("Celsius")) {
                        double ConvertedValue = FahrenheitToCelsius(Float.parseFloat(InputValue));
                        String FormattedValue = String.format("%.2f", ConvertedValue);
                        tvConvertedTemperature.setText(FormattedValue);
                    }
                    else if(outputTemp.equals("Kelvin")){
                        double ConvertedValue = FahrenheitToKelvin(Float.parseFloat(InputValue));
                        String FormattedValue = String.format("%.2f", ConvertedValue);
                        tvConvertedTemperature.setText(FormattedValue);
                    }
                }


                else if(inputTemp.equals("Kelvin")){
                    if(outputTemp.equals("Fahrenheit")) {
                        double ConvertedValue = KelvinToFahrenheit(Float.parseFloat(InputValue));
                        String FormattedValue = String.format("%.2f", ConvertedValue);
                        tvConvertedTemperature.setText(FormattedValue);
                    }
                    else if(outputTemp.equals("Celsius")){
                        double ConvertedValue = KelvinToCelsius(Float.parseFloat(InputValue));
                        String FormattedValue = String.format("%.2f", ConvertedValue);
                        tvConvertedTemperature.setText(FormattedValue);
                    }
                }

            }
        });
    }

    public double CelsiusToFahrenheit(double celsius){
        double result;
        result = (celsius * 1.8) + 32;
        return result;
    }

    public double CelsiusToKelvin(double celsius){
        double result;
        result = celsius + 273.15;
        return result;
    }

    public double FahrenheitToCelsius(double fahrenheit){
        double result;
        result = (fahrenheit - 32) * 0.555555556;
        return result;
    }

    public double FahrenheitToKelvin(double fahrenheit){
        double result;
        result = ((fahrenheit - 32) * 0.555555556)+273.15;
        return result;
    }

    public double KelvinToFahrenheit(double kelvin){
        double result;
        result = ((kelvin - 273.15) * 1.8)+32;
        return result;
    }

    public double KelvinToCelsius(double kelvin){
        double result;
        result = kelvin - 273.15;
        return result;
    }


}
