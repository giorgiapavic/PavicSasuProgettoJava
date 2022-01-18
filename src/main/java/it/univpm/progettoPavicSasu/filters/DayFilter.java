package it.univpm.progettoPavicSasu.filters;

import it.univpm.progettoPavicSasu.model.CityForecast;
import it.univpm.progettoPavicSasu.model.Forecast;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
/**
 * 
 * @author Giorgia Pavic
 * @author Riccardo Sasu 
 */
public class DayFilter implements Filter {
 
    @Override
    public Forecast filter(JSONObject requestBody, Forecast forecast) {
        if (requestBody.has("days")) {
            Forecast f = new Forecast(); // creo oggetto forecast
            int days = requestBody.getInt("days");
            for(int j = 0; j < forecast.size(); j++) {
                CityForecast c = forecast.get(j);
                CityForecast res = new CityForecast(c.getCityName());
                LocalDate localdate = LocalDate.parse(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString()).plusDays(days);
                for (int i = 0; i < c.size(); i++) {
                    if(localdate.isAfter(c.getMeasurement(i).getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())){
                        res.addMeasurement(c.getMeasurement(i));
                    }

                }
                f.add(res);
            }

            return f;
        }else{
            return forecast;
        }
    }

}
