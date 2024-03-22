package com.example.countries;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String urlFlag = getIntent().getStringExtra("urlFlag");
        String countryName = getIntent().getStringExtra("countryName");
        String capitalName = getIntent().getStringExtra("capitalName");
        int area = getIntent().getIntExtra("area", 0);

        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView capitalTextView = findViewById(R.id.capitalTextView);
        TextView areaTextView = findViewById(R.id.areaTextView);
        ImageView flagImageView = findViewById(R.id.flagImageView);

        nameTextView.setText(countryName);
        capitalTextView.setText(capitalName);
        areaTextView.setText("Площадь: " + area + " кв. км");

        Glide.with(this)
                .load(urlFlag)
                .into(flagImageView);
    }
}
