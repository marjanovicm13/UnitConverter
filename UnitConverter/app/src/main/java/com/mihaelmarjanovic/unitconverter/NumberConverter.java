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

public class NumberConverter extends AppCompatActivity {

    EditText etNumbers;
    TextView tvConvertedNumbers;
    Button btnConvertNumbers;

    private String inputNumber;
    private String outputNumber;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter_numbers);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerNumbers);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Number_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                inputNumber = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Spinner spinner2 = (Spinner) findViewById(R.id.spinnerNumbers2);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                outputNumber = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        etNumbers = findViewById(R.id.etNumbers);
        tvConvertedNumbers = findViewById(R.id.tvConvertedNumbers);
        btnConvertNumbers = findViewById(R.id.btnConvertNumbers);
        btnConvertNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String InputValue = etNumbers.getText().toString();

                if (InputValue.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a value!", Toast.LENGTH_SHORT).show();
                }

                else if(inputNumber.equals("Decimal")){
                    if(hasLetters(InputValue)){
                        Toast.makeText(getApplicationContext(), "Please enter a decimal value", Toast.LENGTH_SHORT).show();
                    }
                    else if (outputNumber.equals("Binary")){
                        int ConvertedValue = Integer.parseInt(InputValue);
                        tvConvertedNumbers.setText(Integer.toBinaryString(ConvertedValue));
                    }
                    else if(outputNumber.equals("Octal")){
                        int ConvertedValue = Integer.parseInt(InputValue);
                        tvConvertedNumbers.setText(Integer.toOctalString(ConvertedValue));
                    }
                    else if(outputNumber.equals("Hexadecimal")){
                        int ConvertedValue = Integer.parseInt(InputValue);
                        tvConvertedNumbers.setText(Integer.toHexString(ConvertedValue));
                    }
                    else if (outputNumber.equals("Decimal")) {
                        tvConvertedNumbers.setText(etNumbers.getText().toString());
                    }
                }


                else if(inputNumber.equals("Binary")){
                    if(hasLetters(InputValue) || !isBinary(Integer.parseInt(InputValue))){
                        Toast.makeText(getApplicationContext(), "Please enter a binary value", Toast.LENGTH_SHORT).show();
                    }
                    else if (outputNumber.equals("Binary")){
                        tvConvertedNumbers.setText(etNumbers.getText().toString());
                    }
                    else if(outputNumber.equals("Octal")){
                        int ConvertedValue = Integer.parseInt(InputValue);
                        ConvertedValue = BinaryToDecimal(ConvertedValue);
                        tvConvertedNumbers.setText(Integer.toOctalString(ConvertedValue));
                    }
                    else if(outputNumber.equals("Hexadecimal")){
                        int ConvertedValue = Integer.parseInt(InputValue);
                        ConvertedValue = BinaryToDecimal(ConvertedValue);
                        tvConvertedNumbers.setText(Integer.toHexString(ConvertedValue));
                    }
                    else if (outputNumber.equals("Decimal")) {
                        int ConvertedValue = Integer.parseInt(InputValue);
                        ConvertedValue = BinaryToDecimal(ConvertedValue);
                        String output = String.valueOf(ConvertedValue);
                        tvConvertedNumbers.setText(output);
                    }
                }


                else if(inputNumber.equals("Octal")){
                    if(hasLetters(InputValue) || InputValue.contains("8") || InputValue.contains("9")){
                        Toast.makeText(getApplicationContext(), "Please enter an octal value", Toast.LENGTH_SHORT).show();
                    }
                    else if (outputNumber.equals("Binary")){
                        int ConvertedValue = Integer.parseInt(InputValue);
                        ConvertedValue = OctalToDecimal(ConvertedValue);
                        tvConvertedNumbers.setText(Integer.toBinaryString(ConvertedValue));
                    }
                    else if(outputNumber.equals("Octal")){
                        tvConvertedNumbers.setText(etNumbers.getText().toString());
                    }
                    else if(outputNumber.equals("Hexadecimal")){
                        int ConvertedValue = Integer.parseInt(InputValue);
                        ConvertedValue = OctalToDecimal(ConvertedValue);
                        tvConvertedNumbers.setText(Integer.toHexString(ConvertedValue));
                    }
                    else if (outputNumber.equals("Decimal")) {
                        int ConvertedValue = Integer.parseInt(InputValue);
                        ConvertedValue = OctalToDecimal(ConvertedValue);
                        String output = String.valueOf(ConvertedValue);
                        tvConvertedNumbers.setText(output);
                    }
                }


                else if(inputNumber.equals("Hexadecimal")){
                    if (outputNumber.equals("Binary")){
                        int ConvertedValue = Integer.parseInt(InputValue, 16);
                        tvConvertedNumbers.setText(Integer.toBinaryString(ConvertedValue));
                    }
                    else if(outputNumber.equals("Octal")){
                        int ConvertedValue = Integer.parseInt(InputValue, 16);
                        tvConvertedNumbers.setText(Integer.toOctalString(ConvertedValue));
                    }
                    else if(outputNumber.equals("Hexadecimal")){
                        tvConvertedNumbers.setText(etNumbers.getText().toString());
                    }
                    else if (outputNumber.equals("Decimal")) {
                        int ConvertedValue = Integer.parseInt(InputValue, 16);
                        String output = String.valueOf(ConvertedValue);
                        tvConvertedNumbers.setText(output);
                    }
                }

            }
        });
    }

    public static boolean isBinary(int number) {
        int copyOfInput = number;

        while (copyOfInput != 0) {
            if (copyOfInput % 10 > 1) {
                return false;
            }
            copyOfInput = copyOfInput / 10;
        }
        return true;
    }

    public int BinaryToDecimal(int number){
        int copyOfInput = number;
        int result = 0;
        int digits = String.valueOf(copyOfInput).length();
        for(int i = 0; i<digits; i++){
            result += (int) ((copyOfInput%10) * Math.pow(2, i));
            copyOfInput/=10;
        }
        return result;
    }

    public int OctalToDecimal(int number){
        int copyOfInput = number;
        int result = 0;
        int digits = String.valueOf(copyOfInput).length();
        for(int i = 0; i<digits; i++){
            result += (int) ((copyOfInput%10) * Math.pow(8, i));
            copyOfInput/=10;
        }
        return result;
    }


    public static boolean hasLetters(String Value){
        if(Value.contains("A") || Value.contains("B") || Value.contains("C") || Value.contains("D")
                || Value.contains("E") || Value.contains("F") || Value.contains("a") || Value.contains("b") || Value.contains("c") || Value.contains("d") || Value.contains("e")
                || Value.contains("f")){
            return true;
        }
        return false;
    }

}
