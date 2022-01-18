package it.univpm.progettoPavicSasu.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
 /**
  * Classe con l'array del meteo delle città
  * @author Giorgia Pavic
  * @author Riccardo Sasu
  */
public class Forecast {

    private ArrayList<CityForecast> cityArray = new ArrayList<CityForecast>();
   /**
    * Matodo per aggiungere ...
    * @param a
    */
    public void add(CityForecast a){
        this.cityArray.add(a);
    }
    /**
     * Metodo che restituisce un json con ...
     * @return
     */
    public JSONObject exportJSON(){
        JSONObject finalJson = new JSONObject();
        JSONArray res = new JSONArray();
        for(CityForecast c : this.cityArray){
            res.put(c.exportJson());
        }
        finalJson.put("cities",res.toList());
        return finalJson;
    }
    /**
     * Metodo che restituisce la lunghezza dell'array cityArray
     * 
     */
    public int size(){
        return this.cityArray.size();
    }

    public CityForecast get(int n){
        return this.cityArray.get(n);
    }

}
