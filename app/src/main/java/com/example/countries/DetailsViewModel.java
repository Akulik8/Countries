package com.example.countries;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DetailsViewModel extends ViewModel {
    public MutableLiveData <Country> selectedCountry = new MutableLiveData<>();
    public void selectCountry(Country country) {
        selectedCountry.setValue(country);
    }

    public LiveData<Country> getSelectedCountry() {
        return selectedCountry;
    }
}
