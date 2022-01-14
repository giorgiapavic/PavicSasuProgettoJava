package it.univpm.progettoPavicSasu.filters;

import it.univpm.progettoPavicSasu.model.CityForecast;
import it.univpm.progettoPavicSasu.model.Forecast;
import org.json.JSONObject;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class HourFilter implements Filter{

    @Override
    public Forecast filter(JSONObject requestBody, Forecast forecast) {
        if (requestBody.has("interval")) {
            String interval = requestBody.getString("interval");
            String [] time;
            try {
                time = interval.split("->");
            } catch (Exception e) {
                time = null;
            }
            if(time != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H");
                LocalTime start, end;

                if (time != null && time.length > 1) {
                    start = LocalTime.parse(time[0]);
                    end = LocalTime.parse(time[1]);
                } else {
                    start = LocalTime.parse(requestBody.getString("interval"));
                    end = null;
                }

                Forecast f = new Forecast(); // creo oggetto forecast
                for (int j = 0; j < forecast.size(); j++) {
                    CityForecast c = forecast.get(j);
                    CityForecast res = new CityForecast(c.getCityName());
                    for (int i = 0; i < c.getMeasurementNumber(); i++) {
                        int hour = c.getMeasurement(i).getDate().getHours();
                        LocalTime formatted = LocalTime.parse(String.valueOf(hour),formatter);
                        end = end.plusNanos(1);
                        start= start.minusNanos(1);
                        boolean check = start.isBefore(formatted) && end.isAfter(formatted);
                        if(check){
                            res.addMeasurement(c.getMeasurement(i));
                        }
                    }
                    f.add(res);
                }
                return f;
            }else{
                return forecast;
            }
        }else{
            return forecast;
        }
    }
}
