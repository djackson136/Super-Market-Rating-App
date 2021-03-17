package com.example.supermarketrating;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

public class RatingActivity extends AppCompatActivity {

    private Rating currentRating = new Rating();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        displayTitle();
        initSaveButton();
    }

    private void initSaveButton() {
        Button saveButton = findViewById(R.id.buttonSave);
        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                boolean wasSuccessful = false;

                MarketDataSource ds = new MarketDataSource(RatingActivity.this);
                try {
                    ds.open();
                    displayRating();
                    wasSuccessful = ds.insertRating(currentRating);
                    ds.close();
                } catch (Exception e) {
                    wasSuccessful = false;
                }
            }
        });
    }

    private void displayTitle() {
        String currentTitle = getIntent().getStringExtra("keytitle");
        TextView title = findViewById(R.id.textTitle);
        title.setText(currentTitle);
    }

    private void displayRating() {
        RatingBar produceRating = findViewById(R.id.ratingProduce);
        RatingBar meatRating = findViewById(R.id.ratingMeat);

        double firstRating = (double) produceRating.getRating();
        double secondRating = (double) meatRating.getRating();
        currentRating.setProduceRating(firstRating);
        currentRating.setMeatRating(secondRating);
        String averageRating = String.valueOf((firstRating + secondRating) / 2);
        TextView result = findViewById(R.id.textResult);
        result.setText(averageRating);
    }
}
