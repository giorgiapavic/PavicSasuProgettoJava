/**
 * 
 */
package it.univpm.progettoPavicSasu.Controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * @author Giorgia Pavic
 * @author Riccardo Sasu
 */
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.progettoPavicSasu.service.OpenWeatherMap;

import java.text.ParseException;
import java.util.Map;
@RestController
public class APIController {

    /**
     *
     * @param json
     * @return
     */
    @PostMapping("/citiesWeather")
    public Map<String,Object> citiesWeather(@RequestBody String json) {
    	return OpenWeatherMap.getCitiesWeather(json).toMap();
    }

    /**
     *
     * @param json
     * @return
     * @throws ParseException
     */
    @PostMapping("/citiesForecast")
    public Map<String,Object> citiesForecast(@RequestBody String json) throws ParseException {
        return OpenWeatherMap.getCitiesForecast(json).toMap();
    }

}