/**
 * 
 */
package it.univpm.progettoPavicSasu.service;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import it.univpm.progettoPavicSasu.configuration.Config;
import it.univpm.progettoPavicSasu.model.City;

/**
 * @author Riccardo
 *
 */
public class OpenWeatherMap {
	 
			
	
	/**
	 * 
	 * @param s
	 * @return json 
	 * il metodo riceve una stringa contenente un json con i nomi delle città di cui confrontare le informazioni del tempo
	 */
	public static JSONObject getCitiesWeather(String s) {
		JSONObject json = new JSONObject(s);	// converto la stringa in json
		// controllo se esiste la key
		if(json.has("cities")) {
			HTTPService http = new HTTPService();
			JSONArray array = new JSONArray(json.get("cities").toString());
			JSONObject res = new JSONObject();
			// scorro tutte le città contenute nel JSONArray
			for(int i = 0; i < array.length(); i++) {
				String uri = Config.getUri() + "&q=" + array.getString(i);
				JSONObject tmp = http.request(uri);
				
				//JSONObject j 
				//City c = new City(tmp.getString("name"), tmp.getLong("dt"), );
				
				res.append(array.getString(i), tmp);
			}
			return res;
		}
		return new JSONObject();
	}
	
}
