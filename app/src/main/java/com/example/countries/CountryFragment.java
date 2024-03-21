package com.example.countries;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        CountriesViewModel viewModel = new ViewModelProvider(requireActivity()).get(CountriesViewModel.class);
        View view = inflater.inflate(R.layout.fragment_country, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));

        viewModel.getCountries().observe(getViewLifecycleOwner(), countries -> {
            CountryAdapter adapter = new CountryAdapter(getActivity(), countries);
            adapter.setOnItemClickListener(new CountryAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(Country country) {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    DetailsFragment detailsFragment = DetailsFragment.newInstance(country.getName(), country.getCapital(), country.getArea(), country.getFlagId());
                    fragmentTransaction.replace(R.id.fragment_container, detailsFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            });
            recyclerView.setAdapter(adapter);
        });

        return view;
    }
}
