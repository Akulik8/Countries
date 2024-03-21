package com.example.countries;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class CountriesViewModel extends ViewModel {
    public MutableLiveData<List<Country>> countries = new MutableLiveData<>();
    private MutableLiveData<Country> selectedCountry = new MutableLiveData<>();
    public CountriesViewModel() {
        List<Country> countriesList = new ArrayList<>();
        countriesList.add(new Country("Россия", R.drawable.rus, "Москва", 17100000));
        countriesList.add(new Country("США", R.drawable.usa, "Вашингтон", 9834000));
        countriesList.add(new Country("Германия", R.drawable.germany, "Берлин", 357592));
        countriesList.add(new Country("Китай", R.drawable.china, "Пекин", 9597000));
        countriesList.add(new Country("Молдова", R.drawable.moldova, "Кишинёв", 33846));
        countriesList.add(new Country("Аргентина", R.drawable.argentina, "Буэнос-Айрес", 2780000));
        countriesList.add(new Country("Франция", R.drawable.france, "Париж", 643801));
        countriesList.add(new Country("Италия", R.drawable.italy, "Рим", 302073));
        countriesList.add(new Country("Бразилия", R.drawable.brazil, "Бразилиа", 8510000));
        countriesList.add(new Country("Канада", R.drawable.canada, "Оттава", 9985000));
        countries.setValue(countriesList);
    }
    public LiveData<List<Country>> getCountries() {
        return countries;
    }
    public LiveData<Country> getSelectedCountry() { return selectedCountry; }
    public void setSelectedCountry(Country country) {
        selectedCountry.setValue(country);
    }
}
