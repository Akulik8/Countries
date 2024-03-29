package com.example.countries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private CountryApi api;
    private ListView listView;
    private CountryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String baseUrl = "https://restcountries.com/v3.1/";

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(CountryApi.class);

        listView = findViewById(R.id.listView);

        Call<List<Country>> call = api.getAllCountry();
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Ошибка: " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Country> countries = response.body();
                adapter = new CountryAdapter(MainActivity.this, countries);
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ошибка: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Country country = countries.get(position);
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("country", country);
                startActivity(intent);
            }
        });*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Country country = (Country) adapter.getItem(position);

                Call<Country> call = api.getCountry(country.code);
                call.enqueue(new Callback<Country>() {
                    @Override
                    public void onResponse(Call<Country> call, Response<Country> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Ошибка: " + response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }

                        Country detailedCountry = response.body();
                        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                        intent.putExtra("country", detailedCountry);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Country> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Ошибка: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }

}