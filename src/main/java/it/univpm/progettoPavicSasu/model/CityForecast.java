package it.univpm.progettoPavicSasu.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class CityForecast extends City{

    private ArrayList<Measurement> measurements = new ArrayList<Measurement>();

    /*
     * Costruttore vuoto della classe
     */
    public CityForecast() {

    }

    public CityForecast(String cityName) {
        super(cityName);
    }

    @Override
    public JSONObject exportJson() {
        JSONObject j = new JSONObject();
        JSONArray arrayJson =  new JSONArray();
        for (Measurement m: this.measurements) {
            JSONObject data = new JSONObject();
            data.put("date",m.date);
            data.put("temperature", m.temperature);
            data.put("pressure", m.pressure);
            data.put("visibility", m.visibility);
            data.put("humidity", m.humidity);
            data.put("cloud", m.cloud);
            arrayJson.put(data);
        }
        j.put("list", arrayJson.toList());
        return j;
    }

    public Measurement getMeasurement(int n) {
        if (n < this.measurements.size()) {
            return this.measurements.get(n);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int size(){
        return this.measurements.size();
    }

    public int getMeasurementNumber(){
        return this.measurements.size();
    }

    public void addMeasurement(Measurement m){
        this.measurements.add(m);
    }
}
