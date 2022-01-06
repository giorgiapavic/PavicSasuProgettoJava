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
    
    @PostMapping("/weather")
    public Map<String,Object> weather(@RequestBody String json) {
    	return OpenWeatherMap.getCitiesWeather(json).toMap();
    }

}