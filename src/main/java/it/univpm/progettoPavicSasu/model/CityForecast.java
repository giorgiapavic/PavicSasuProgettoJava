package it.univpm.progettoPavicSasu.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * La classe definisce la struttura base del forecast
 * @author Giorgia Pavic
 * @author Riccardo Sasu
 *
 */
public class CityForecast extends City{

    private ArrayList<Measurement> measurements = new ArrayList<Measurement>();


    /**
     * Costruttore vuoto della classe
     */
    public CityForecast() {

    }
    
    /**
     * Costruttore della classe
     * @param cityName
     */
    public CityForecast(String cityName) {
        super(cityName);
    }

    /**
     * Metodo per creare un json object dall'oggetto CityForecast
     * @return j  json con le informazioni del forecast
     */
    @Override
    public JSONObject exportJson() {
        JSONObject j = new JSONObject();
        j.put("city",this.cityName);
        JSONArray arrayJson =  new JSONArray();
        for (Measurement m: this.measurements) {    // foreach
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
    
    /**
     * Metodo che restituisce le misurazioni
     * @param n  
     * @return  valori delle misurazioni
     */
    public Measurement getMeasurement(int n) {
        if (n < this.measurements.size()) {
            return this.measurements.get(n);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    /**
     * Metodo che restituisce la lunghezza dell'array measurements
     * 
     */
    public int size(){
        return this.measurements.size();
    }
    /**
     * Metodo che restituisce la lunghezza dell'array measurements
     * 
     */
    public int getMeasurementNumber(){
        return this.measurements.size();
    }
    /**
     * Metodo che aggiunge all'array una misurazione
     * @param m
     */
    public void addMeasurement(Measurement m){
        this.measurements.add(m);
    }


}
