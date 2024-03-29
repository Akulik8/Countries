package com.example.countries;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Country implements Serializable {
    @SerializedName("cca2")
    public String code;
    public Flags flags;
    public Names name;
    private List<String> capital;
    private double area;
    private Integer population;

    public Country(String code, Flags flags, Names name, double area, List<String> capital, Integer population) {
        this.code = code;
        this.flags = flags;
        this.name = name;
        this.area = area;
        this.capital = capital;
        this.population = population;
    }

    public static class Flags implements Serializable{
        public String png;
        public String svg;
        public String alt;
    }

    public static class Names implements Serializable {
        public String common;
        public String official;
    }

    public String getName() {
        return name.common;
    }

    public  Flags getFlags() {
        return flags;
    }

    public String getCapital() {
        return capital.get(0);
    }

    public double getArea() {
        return area;
    }

    public Integer getPopulation() {
        return population;
    }
}