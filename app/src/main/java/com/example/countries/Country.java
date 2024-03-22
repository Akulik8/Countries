package com.example.countries;

import java.io.Serializable;

public class Country implements Serializable {
    private String name;
    private String urlFlag;
    private String capital;
    private Integer area;

    public Country(String name, String urlFlag, String capital, Integer area) {
        this.name = name;
        this.urlFlag = urlFlag;
        this.capital = capital;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public String geturlFlag() {
        return urlFlag;
    }

    public String getCapital() {
        return capital;
    }

    public Integer getArea() {
        return area;
    }
}