
package it.univpm.progettoPavicSasu.Controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.progettoPavicSasu.service.OpenWeatherMap;

import java.text.ParseException;
import java.util.Map;

/**
 * Questa classe gestisce le chiamate al server che il client può fare
 * @author Giorgia Pavic
 * @author Riccardo Sasu
 */

@RestController
public class APIController {

    /**
     *Rotta di tipo POST che mostra le previsioni del giorno corrente delle città scelte
     * @param json 
     * @return previsioni attuali della città scelta
     */
    @PostMapping("/citiesWeather")
    public Map<String,Object> citiesWeather(@RequestBody String json) {
    	return OpenWeatherMap.getCitiesWeather(json).toMap();
    }

    /**
     *Rotta di tipo POST che mostra il forecast
     * @param json
     * @return forecast ogni tre ore con possibilità di inserire vari filtri
     * @throws ParseException 
     */
    @PostMapping("/citiesForecast")
    public Map<String,Object> citiesForecast(@RequestBody String json) throws ParseException {
        return OpenWeatherMap.getCitiesForecast(json).toMap();
    } 

}