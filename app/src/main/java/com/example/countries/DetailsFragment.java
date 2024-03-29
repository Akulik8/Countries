package com.example.countries;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailsFragment extends Fragment {
    public DetailsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        TextView countryText = view.findViewById(R.id.nameTextView);
        TextView capitalText = view.findViewById(R.id.capitalTextView);
        TextView squareText = view.findViewById(R.id.areaTextView);
        ImageView flag = view.findViewById(R.id.flagImageView);
        Bundle args = getArguments();
        if (args != null) {
            String countryName = args.getString("countryName");
            String capitalName = args.getString("capitalName");
            int area = args.getInt("area");
            int flagId = args.getInt("flagId");

            countryText.setText(countryName);
            capitalText.setText("Столица: " + capitalName);
            squareText.setText("Площадь: " + area);
            flag.setImageResource(flagId);
        }

        return view;
    }
    private void displayCountry(View view, Country country) {
        TextView nameTextView = view.findViewById(R.id.nameTextView);
        TextView capitalTextView = view.findViewById(R.id.capitalTextView);
        TextView areaTextView = view.findViewById(R.id.areaTextView);
        ImageView flagImageView = view.findViewById(R.id.flagImageView);

        nameTextView.setText(country.getName());
        capitalTextView.setText("Столица: " + country.getCapital());
        areaTextView.setText("Площадь: " + country.getArea() + " кв. км");
        flagImageView.setImageResource(country.getFlagId());
    }
    public static DetailsFragment newInstance(String countryName, String capitalName, int area, int flagId) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putString("countryName", countryName);
        args.putString("capitalName", capitalName);
        args.putInt("area", area);
        args.putInt("flagId", flagId);
        fragment.setArguments(args);
        return fragment;
    }
}