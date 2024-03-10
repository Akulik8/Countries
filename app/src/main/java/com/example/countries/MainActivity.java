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

        CountryFragment countryFragment =new CountryFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, countryFragment).commit();
//        ListView listView = findViewById(R.id.listView);
//
//        List<Country> countries = new ArrayList<>();
//        countries.add(new Country("Россия", R.drawable.rus, "Москва", 17100000));
//        countries.add(new Country("США", R.drawable.usa, "Вашингтон", 9834000));
//        countries.add(new Country("Германия", R.drawable.germany, "Берлин", 357592));
//        countries.add(new Country("Китай", R.drawable.china, "Пекин", 9597000));
//        countries.add(new Country("Молдова", R.drawable.moldova, "Кишинёв", 33846));
//        countries.add(new Country("Аргентина", R.drawable.argentina, "Буэнос-Айрес", 2780000));
//        countries.add(new Country("Франция", R.drawable.france, "Париж", 643801));
//        countries.add(new Country("Италия", R.drawable.italy, "Рим", 302073));
//        countries.add(new Country("Бразилия", R.drawable.brazil, "Бразилиа", 8510000));
//        countries.add(new Country("Канада", R.drawable.canada, "Оттава", 9985000));
//
//        CountryAdapter countryAdapter = new CountryAdapter(getApplicationContext(), countries);
//        listView.setAdapter(countryAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                Country country = countries.get(position);
//                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
//                intent.putExtra("country", country);
//                startActivity(intent);
//            }
//        });

    }

}