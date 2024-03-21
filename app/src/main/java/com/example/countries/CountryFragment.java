package com.example.countries;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
public class CountryFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        CountriesViewModel viewModel = new ViewModelProvider(this).get(CountriesViewModel.class);
        View view = inflater.inflate(R.layout.fragment_country, container, false);
        ListView listView = view.findViewById(R.id.listView);
        viewModel.getCountries().observe(getViewLifecycleOwner(), new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {
                CountryAdapter adapter = new CountryAdapter(getActivity(), countries);
                listView.setAdapter(adapter);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Country selectedCountry = viewModel.getCountries().getValue().get(position);
                DetailsViewModel detailsViewModel = new ViewModelProvider(requireActivity()).get(DetailsViewModel.class);
                detailsViewModel.selectCountry(selectedCountry);
                DetailsFragment detailsFragment = DetailsFragment.newInstance(selectedCountry.getName(), selectedCountry.getCapital(), selectedCountry.getArea(), selectedCountry.getFlagId());
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, detailsFragment).addToBackStack(null).commit();
            }
        });

        return view;
    }
}
