package com.mihaelmarjanovic.unitconverter;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchCurrencyRates extends AsyncTask<Void, Void, Void> {
        String data = "";
        double rateParsed;
        URL url;
        String convertedCurrency;
        Double convertedValue = 0.0;
        Double valueToConvert;

    public fetchCurrencyRates(String currencyToConvert, String convertedCurrency, double valueToConvert) throws MalformedURLException {
            url = new URL("https://www.floatrates.com/daily/" + currencyToConvert);
            this.convertedCurrency = convertedCurrency;
            this.valueToConvert = valueToConvert;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while(line!=null){
                    line = bufferedReader.readLine();
                    data = data + line;
                }

                JSONObject jObject = new JSONObject(data);
                JSONObject jObject2 = jObject.getJSONObject(convertedCurrency);
                rateParsed = (double) jObject2.get("rate");


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            convertedValue = valueToConvert * rateParsed;
            String FormattedValue = String.format("%.2f", convertedValue);
            CurrencyConverter.tvConvertedCurrency.setText(FormattedValue);
        }

    }

