package com.example.countries;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailsFragment extends Fragment {
    public DetailsFragment() {
        // Required empty public constructor
    }
    public static DetailsFragment newInstance(Country country) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable("country", country);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        Bundle args = getArguments();
        if (args != null) {
            Country country = (Country) args.getSerializable("country");
            if (country != null) {
                TextView nameTextView = view.findViewById(R.id.nameTextView);
                TextView capitalTextView = view.findViewById(R.id.capitalTextView);
                TextView areaTextView = view.findViewById(R.id.areaTextView);
                ImageView flagImageView = view.findViewById(R.id.flagImageView);

                nameTextView.setText(country.getName());
                capitalTextView.setText(country.getCapital());
                areaTextView.setText("Площадь: " + country.getArea() + " кв. км");
                flagImageView.setImageResource(country.getFlagId());
            }
        }
        return view;
    }
}

