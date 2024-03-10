package com.example.countries;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
public class CountryFragment extends Fragment {

    List<Country> countries = new ArrayList<>();
    public static CountryFragment newInstance(String param1, String param2) {
        CountryFragment fragment = new CountryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        countries.add(new Country("Россия", R.drawable.rus, "Москва", 17100000));
        countries.add(new Country("США", R.drawable.usa, "Вашингтон", 9834000));
        countries.add(new Country("Германия", R.drawable.germany, "Берлин", 357592));
        countries.add(new Country("Китай", R.drawable.china, "Пекин", 9597000));
        countries.add(new Country("Молдова", R.drawable.moldova, "Кишинёв", 33846));
        countries.add(new Country("Аргентина", R.drawable.argentina, "Буэнос-Айрес", 2780000));
        countries.add(new Country("Франция", R.drawable.france, "Париж", 643801));
        countries.add(new Country("Италия", R.drawable.italy, "Рим", 302073));
        countries.add(new Country("Бразилия", R.drawable.brazil, "Бразилиа", 8510000));
        countries.add(new Country("Канада", R.drawable.canada, "Оттава", 9985000));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listView);
        CountryAdapter countryAdapter = new CountryAdapter(getActivity(), countries);
        listView.setAdapter(countryAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Country country = countries.get(position);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, DetailsFragment.newInstance(country));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}