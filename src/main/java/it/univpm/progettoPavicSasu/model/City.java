/**
 * Giorgia Pavic
 * Riccardo Sasu
 */
package it.univpm.progettoPavicSasu.model;

import java.sql.Timestamp;
import java.util.Date;

import org.json.JSONObject;

/**
 * @author Riccardo Sasu
 * @author Giorgia Pavic
 */
public abstract class City {

    protected String cityName;


    /*
     * Costruttore vuoto della classe
     */
    public City() {

    }

    public City(String cityName) {
        this.cityName = cityName;
    }


    public abstract JSONObject exportJson();

    /**
     * @return the cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName the cityName to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


}
