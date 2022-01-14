package it.univpm.progettoPavicSasu.model;

import org.json.JSONObject;

import java.util.ArrayList;

public class Forecast {

    private ArrayList<CityForecast> cityArray = new ArrayList<CityForecast>();

    public void add(CityForecast a){
        this.cityArray.add(a);
    }

    public JSONObject exportJSON(){
        JSONObject res = new JSONObject();
        for(CityForecast c : this.cityArray){
            res.put(c.getCityName(), c.exportJson());
        }
        return res;
    }

    public int size(){
        return this.cityArray.size();
    }

    public CityForecast get(int n){
        return this.cityArray.get(n);
    }

}
