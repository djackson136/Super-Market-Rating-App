package com.example.supermarketrating;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

import javax.sql.DataSource;

public class MainActivity extends AppCompatActivity {

    private SuperMarket currentMarket = new SuperMarket();
    private String currentTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextChangedEvents();
        initRateButton();
    }

    private void initRateButton() {
        Button button = findViewById(R.id.buttonRate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean wasSuccessful = false;
                MarketDataSource ds = new MarketDataSource(MainActivity.this);
                try {
                    ds.open();
                    wasSuccessful = ds.insertData(currentMarket);
                    ds.close();
                } catch (Exception e) {
                    wasSuccessful = false;
                }

                Intent intent = new Intent(MainActivity.this, RatingActivity.class);
                intent.putExtra("keytitle", currentTitle);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }


    private void initTextChangedEvents() {
        final EditText etMarketName = findViewById(R.id.editName);
        etMarketName.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                currentMarket.setName(etMarketName.getText().toString());
                currentTitle = currentMarket.getName();
            }
            //currentTitle = currentMarket.getName();

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

        final EditText etAddress = findViewById(R.id.editAddress);
        etAddress.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                currentMarket.setStreetAddress(etAddress.getText().toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

        final EditText etCity = findViewById(R.id.editCity);
        etCity.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                currentMarket.setCity(etCity.getText().toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

        final EditText etState = findViewById(R.id.editState);
        etState.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                currentMarket.setState(etState.getText().toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

        final EditText etZipcode = findViewById(R.id.editZipcode);
        etZipcode.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                currentMarket.setZipCode(etZipcode.getText().toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });
    }
}