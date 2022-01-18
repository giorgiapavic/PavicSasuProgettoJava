package it.univpm.progettoPavicSasu.filters;

import it.univpm.progettoPavicSasu.model.CityForecast;
import it.univpm.progettoPavicSasu.model.Forecast;
import org.json.JSONObject;
/**
 * Interfaccia per realizzare filtri
 * @author Giorgia Pavic
 * @author Riccardo Sasu
 */
public interface Filter {

    public Forecast filter(JSONObject requestBody, Forecast forecast);

}
