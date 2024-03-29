package com.example.countries;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CountryApi {
    @GET("all?fields=cca2,name,flags,capiatal,area,population")
    Call<List<Country>> getAllCountry();

    @GET("alpha/{code}?fields=cca2,name,flags,capital,area,population")
    Call<Country> getCountry(@Path("code") String code);
}
