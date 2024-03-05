package com.example.countries;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CountryAdapter extends BaseAdapter {
    Context context;
    String countries[];
    Bitmap flags[];
    LayoutInflater inflter;

    public CountryAdapter(Context context, String[] countries, Bitmap[] flags) {
        this.context = context;
        this.countries = countries;
        this.flags = flags;
        inflter = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return countries.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.list_item, null);
        TextView country = (TextView) view.findViewById(R.id.textView);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        country.setText(countries[i]);
        icon.setImageBitmap(flags[i]);
        return view;
    }
}