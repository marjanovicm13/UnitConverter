package com.mihaelmarjanovic.unitconverter;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyConverter extends AppCompatActivity {

    static TextView tvConvertedCurrency;
    EditText etCurrency;
    Button btnConvertCurrency;

    private String inputCurrency;
    private String outputCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter_currency);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerCurrency);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Currency_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                inputCurrency = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Spinner spinner2 = (Spinner) findViewById(R.id.spinnerCurrency2);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                outputCurrency = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        tvConvertedCurrency = findViewById(R.id.tvConvertedCurrency);
        etCurrency = findViewById(R.id.etCurrency);
        btnConvertCurrency = findViewById(R.id.btnConvertCurrency);

        btnConvertCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String InputValue = etCurrency.getText().toString();

                if (InputValue.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a value!", Toast.LENGTH_SHORT).show();
                }
                else if (inputCurrency.equals(outputCurrency)) {
                    tvConvertedCurrency.setText(etCurrency.getText().toString());
                }
                else if (inputCurrency.equals("USD")) {

                    if (outputCurrency.equals("Euro")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("usd.json", "eur", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Croatian Kuna")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("usd.json", "hrk", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Swiss Franc")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("usd.json", "chf", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("British Pound")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("usd.json", "gbp", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Japanese Yen")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("usd.json", "jpy", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Serbian Dinar")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("usd.json", "rsd", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Bosnian Mark")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("usd.json", "bam", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Norwegian Krone")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("usd.json", "nok", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }
                }

                    else if (inputCurrency.equals("Euro")) {

                        if (outputCurrency.equals("USD")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("eur.json", "usd", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }

                        if (outputCurrency.equals("Croatian Kuna")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("eur.json", "hrk", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }

                        if (outputCurrency.equals("Swiss Franc")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("eur.json", "chf", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }

                        if (outputCurrency.equals("British Pound")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("eur.json", "gbp", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }

                        if (outputCurrency.equals("Japanese Yen")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("eur.json", "jpy", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }

                        if (outputCurrency.equals("Serbian Dinar")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("eur.json", "rsd", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }

                        if (outputCurrency.equals("Bosnian Mark")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("eur.json", "bam", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }

                        if (outputCurrency.equals("Norwegian Krone")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("eur.json", "nok", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }
                    }

                    else if (inputCurrency.equals("Croatian Kuna")) {

                        if (outputCurrency.equals("USD")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("hrk.json", "usd", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }

                        if (outputCurrency.equals("Euro")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("hrk.json", "eur", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }

                        if (outputCurrency.equals("Swiss Franc")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("hrk.json", "chf", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }

                        if (outputCurrency.equals("British Pound")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("hrk.json", "gbp", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }

                        if (outputCurrency.equals("Japanese Yen")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("hrk.json", "jpy", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }

                        if (outputCurrency.equals("Serbian Dinar")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("hrk.json", "rsd", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }

                        if (outputCurrency.equals("Bosnian Mark")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("hrk.json", "bam", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }

                        if (outputCurrency.equals("Norwegian Krone")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("hrk.json", "nok", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }
                    }

                    else if (inputCurrency.equals("Swiss Franc")) {

                        if (outputCurrency.equals("USD")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("chf.json", "usd", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }

                        if (outputCurrency.equals("Euro")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("chf.json", "eur", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }

                        if (outputCurrency.equals("Croatian Kuna")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("chf.json", "hrk", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }

                        if (outputCurrency.equals("British Pound")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("chf.json", "gbp", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }

                        if (outputCurrency.equals("Japanese Yen")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("chf.json", "jpy", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }

                        if (outputCurrency.equals("Serbian Dinar")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("chf.json", "rsd", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }

                        if (outputCurrency.equals("Bosnian Mark")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("chf.json", "bam", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }

                        if (outputCurrency.equals("Norwegian Krone")) {
                            fetchCurrencyRates process = null;
                            try {
                                process = new fetchCurrencyRates("chf.json", "nok", Double.valueOf(InputValue));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            process.execute();
                        }
                    }

                else if (inputCurrency.equals("British Pound")) {

                    if (outputCurrency.equals("USD")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("gbp.json", "usd", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Euro")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("gbp.json", "eur", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Croatian Kuna")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("gbp.json", "hrk", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Swiss Franc")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("gbp.json", "chf", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Japanese Yen")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("gbp.json", "jpy", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Serbian Dinar")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("gbp.json", "rsd", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Bosnian Mark")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("gbp.json", "bam", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Norwegian Krone")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("gbp.json", "nok", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }
                }

                else if (inputCurrency.equals("Japanese Yen")) {

                    if (outputCurrency.equals("USD")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("jpy.json", "usd", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Euro")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("jpy.json", "eur", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Croatian Kuna")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("jpy.json", "hrk", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Swiss Franc")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("jpy.json", "chf", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("British Pound")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("jpy.json", "gbp", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Serbian Dinar")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("jpy.json", "rsd", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Bosnian Mark")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("jpy.json", "bam", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Norwegian Krone")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("jpy.json", "nok", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }
                }

                else if (inputCurrency.equals("Serbian Dinar")) {

                    if (outputCurrency.equals("USD")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("rsd.json", "usd", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Euro")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("rsd.json", "eur", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Croatian Kuna")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("rsd.json", "hrk", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Swiss Franc")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("rsd.json", "chf", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("British Pound")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("rsd.json", "gbp", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Japanese Yen")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("rsd.json", "jpy", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Bosnian Mark")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("rsd.json", "bam", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Norwegian Krone")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("rsd.json", "nok", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }
                }


                else if (inputCurrency.equals("Bosnian Mark")) {

                    if (outputCurrency.equals("USD")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("bam.json", "usd", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Euro")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("bam.json", "eur", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Croatian Kuna")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("bam.json", "hrk", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Swiss Franc")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("bam.json", "chf", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("British Pound")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("bam.json", "gbp", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Japanese Yen")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("bam.json", "jpy", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Serbian Dinar")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("bam.json", "rsd", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Norwegian Krone")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("bam.json", "nok", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }
                }


                else if (inputCurrency.equals("Norwegian Krone")) {

                    if (outputCurrency.equals("USD")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("nok.json", "usd", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Euro")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("nok.json", "eur", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Croatian Kuna")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("nok.json", "hrk", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Swiss Franc")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("nok.json", "chf", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("British Pound")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("nok.json", "gbp", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Japanese Yen")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("nok.json", "jpy", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Serbian Dinar")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("nok.json", "rsd", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }

                    if (outputCurrency.equals("Bosnian Mark")) {
                        fetchCurrencyRates process = null;
                        try {
                            process = new fetchCurrencyRates("nok.json", "bam", Double.valueOf(InputValue));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        process.execute();
                    }
                }



            }
        });
    }
}

