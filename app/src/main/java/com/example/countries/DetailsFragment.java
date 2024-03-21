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
        DetailsViewModel detailsViewModel = new ViewModelProvider(requireActivity()).get(DetailsViewModel.class);
        detailsViewModel.getSelectedCountry().observe(getViewLifecycleOwner(), new Observer<Country>() {

            @Override
            public void onChanged(Country country) {
                if (country != null) {
                    displayCountry(view, country);
                }
            }
        });

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