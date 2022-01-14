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

import java.util.Map;
@RestController
public class APIController {

    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }

    @PostMapping("/citiesWeather")
    public Map<String,Object> citiesWeather(@RequestBody String json) {
    	return OpenWeatherMap.getCitiesWeather(json).toMap();
    }

    @PostMapping("/citiesForecast")
    public Map<String,Object> citiesForecast(@RequestBody String json){
        return OpenWeatherMap.getCitiesForecast(json).toMap();
    }

}