package com.example.countries;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        Country country = (Country) intent.getSerializableExtra("country");

        if (country != null) {
            TextView nameTextView = findViewById(R.id.nameTextView);
            TextView capitalTextView = findViewById(R.id.capitalTextView);
            TextView areaTextView = findViewById(R.id.areaTextView);
            ImageView flagImageView = findViewById(R.id.flagImageView);

            nameTextView.setText(country.getName());
            capitalTextView.setText(country.getCapital());
            areaTextView.setText("Площадь: " + country.getArea() + " кв. км");
            flagImageView.setImageResource(country.getFlagId());
        }
    }
}
