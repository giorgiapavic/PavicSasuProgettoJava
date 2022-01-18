
package it.univpm.progettoPavicSasu.model;

import java.sql.Timestamp;
import java.util.Date;

import org.json.JSONObject;

/**
 * Classe astratta che definisce la città
 * @author Riccardo Sasu
 * @author Giorgia Pavic
 */
public abstract class City {

    protected String cityName;


    /**
     * Costruttore vuoto della classe
     */
    public City() {

    }
    /**
     * Costruttore della classe
     * @param cityName
     */
    public City(String cityName) {
        this.cityName = cityName;
    }

   
    public abstract JSONObject exportJson();

    /**
     * Metodo che restituisce il nome della città
     * @return nome della città
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Metodo che permette di modificare il nome della città
     * @param cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


}
