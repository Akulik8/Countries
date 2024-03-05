package com.example.countries;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Россия", R.drawable.rus));
        countries.add(new Country("США", R.drawable.usa));
        countries.add(new Country("Германия", R.drawable.germany));
        countries.add(new Country("Китай", R.drawable.china));
        countries.add(new Country("Молдова", R.drawable.moldova));
        countries.add(new Country("Аргентина", R.drawable.argentina));
        countries.add(new Country("Франция", R.drawable.france));
        countries.add(new Country("Италия", R.drawable.italy));
        countries.add(new Country("Бразилия", R.drawable.brazil));
        countries.add(new Country("Канада", R.drawable.canada));

        CountryAdapter countryAdapter = new CountryAdapter(getApplicationContext(), countries);
        listView.setAdapter(countryAdapter);
    }
}