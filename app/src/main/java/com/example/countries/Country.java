package com.example.countries;

import java.io.Serializable;

public class Country implements Serializable {
    private String name;
    private int flagId;
    private String capital;
    private int area;

    public Country(String name, int flagId, String capital, int area) {
        this.name = name;
        this.flagId = flagId;
        this.capital = capital;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public int getFlagId() {
        return flagId;
    }

    public String getCapital() {
        return capital;
    }

    public int getArea() {
        return area;
    }
}