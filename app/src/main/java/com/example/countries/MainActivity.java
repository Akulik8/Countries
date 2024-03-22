package com.example.countries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        countries.add(new Country("Россия", "https://flagsapi.com/RU/shiny/64.png", "Москва", 17100000));
        countries.add(new Country("США", "https://flagsapi.com/US/shiny/64.png", "Вашингтон", 9834000));
        countries.add(new Country("Германия", "https://flagsapi.com/DE/flat/64.png", "Берлин", 357592));
        countries.add(new Country("Китай", "https://flagsapi.com/CN/flat/64.png", "Пекин", 9597000));
        countries.add(new Country("Молдова", "https://flagsapi.com/MD/shiny/64.png", "Кишинёв", 33846));
        countries.add(new Country("Аргентина", "https://flagsapi.com/AR/shiny/64.png", "Буэнос-Айрес", 2780000));
        countries.add(new Country("Франция", "https://flagsapi.com/FR/shiny/64.png", "Париж", 643801));
        countries.add(new Country("Италия", "https://flagsapi.com/IT/shiny/64.png", "Рим", 302073));
        countries.add(new Country("Бразилия", "https://flagsapi.com/BR/shiny/64.png", "Бразилиа", 8510000));
        countries.add(new Country("Канада", "https://flagsapi.com/CA/shiny/64.png", "Оттава", 9985000));

        CountryAdapter countryAdapter = new CountryAdapter(this, countries);
        listView.setAdapter(countryAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Country country = countries.get(position);
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("country", country);
                intent.putExtra("urlFlag", country.geturlFlag());
                intent.putExtra("capitalName", country.getCapital());
                intent.putExtra("area", country.getArea());
                startActivity(intent);
            }
        });

    }

}