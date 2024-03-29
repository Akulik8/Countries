package com.example.countries;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CountryAdapter extends BaseAdapter {
    private Context context;
    private List<Country> countries;
    private LayoutInflater inflater;

    public CountryAdapter(Context context, List<Country> countries) {
        this.context = context;
        this.countries = countries;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public Object getItem(int position) {
        return countries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Country country = countries.get(position);
        if (view == null) {
            view = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView countryName = view.findViewById(R.id.textView);
        ImageView flagImage = view.findViewById(R.id.icon);

        Glide.with(context)
                .load(country.getFlags().png)
                .into(flagImage);

        countryName.setText(country.getName());
        return view;
    }
}