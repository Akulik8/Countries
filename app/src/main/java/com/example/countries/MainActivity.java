package com.example.countries;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bitmap[] flags = {getResizedBitmap(R.drawable.rus), getResizedBitmap(R.drawable.usa), getResizedBitmap(R.drawable.germany), getResizedBitmap(R.drawable.china), getResizedBitmap(R.drawable.moldova), getResizedBitmap(R.drawable.argentina), getResizedBitmap(R.drawable.france), getResizedBitmap(R.drawable.italy), getResizedBitmap(R.drawable.brazil), getResizedBitmap(R.drawable.canada)};


        ListView listView = findViewById(R.id.listView);

        String[] countries = getResources().getStringArray(R.array.countries);

        // используем адаптер данных
        CountryAdapter countryAdapter = new CountryAdapter(getApplicationContext(), countries, flags);
        listView.setAdapter(countryAdapter);

    }
    private Bitmap getResizedBitmap(int resourceId) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resourceId);
        int width = (int) getResources().getDimension(R.dimen.flag_width);
        int height = (int) getResources().getDimension(R.dimen.flag_height);
        return Bitmap.createScaledBitmap(bitmap, width, height, false);
    }

}