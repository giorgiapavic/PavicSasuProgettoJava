/**
 *
 */
package it.univpm.progettoPavicSasu.service;

import it.univpm.progettoPavicSasu.configuration.ConfigurationForecast;
import it.univpm.progettoPavicSasu.filters.DayFilter;
import it.univpm.progettoPavicSasu.filters.HourFilter;
import it.univpm.progettoPavicSasu.model.CityForecast;
import it.univpm.progettoPavicSasu.model.Forecast;
import it.univpm.progettoPavicSasu.model.Measurement;
import org.json.JSONArray;
import org.json.JSONObject;

import it.univpm.progettoPavicSasu.configuration.ConfigurationCurrent;
import it.univpm.progettoPavicSasu.model.CityWeather;

/**
 * @author Giorgia Pavic
 * @author Riccardo Sasu
 */
public class OpenWeatherMap {


    /**
     *
     * @param s
     * @return json
     * il metodo riceve una stringa contenente un json con i nomi delle città di cui confrontare le informazioni del tempo
     */
    public static JSONObject getCitiesWeather(String s) {
        JSONObject json = new JSONObject(s);    // converto la stringa in json
        // controllo se esiste la key
        if (json.has("cities")) {
            HTTPService http = new HTTPService();
            JSONArray array = new JSONArray(json.get("cities").toString());
            JSONObject res = new JSONObject();
            // scorro tutte le città contenute nel JSONArray
            for (int i = 0; i < array.length(); i++) {
                String uri = ConfigurationCurrent.getUri() + "&q=" + array.getString(i);
                JSONObject tmp = http.request(uri);

                CityWeather c = new CityWeather();
                c.setCityName(tmp.getString("name"));
                c.setDate(Long.parseLong(String.valueOf(tmp.get("dt"))));
                JSONObject main = tmp.getJSONObject("main");
                c.setTemperature(main.getDouble("temp"));
                c.setHumidity(main.getDouble("humidity"));
                c.setPressure(main.getDouble("pressure"));
                c.setVisibility(tmp.getDouble("visibility"));
                c.setCloud(tmp.getJSONObject("clouds").getDouble("all"));

                res.append(array.getString(i), c.exportJson());
            }

            return res;
        }
        return new JSONObject();
    }

    public static JSONObject getCitiesForecast(String s) {
        JSONObject json = new JSONObject(s);    // converto la stringa in json
        // controllo se esiste la key
        if (json.has("cities")) {
            HTTPService http = new HTTPService();
            Forecast forecast = new Forecast();
            JSONArray array = new JSONArray(json.get("cities").toString());
            // scorro tutte le città contenute nel JSONArray
            for (int i = 0; i < array.length(); i++) {
                String uri = ConfigurationForecast.getUri() + "&q=" + array.getString(i);
                JSONObject tmp = http.request(uri);

                JSONArray list = tmp.getJSONArray("list");
                CityForecast c = new CityForecast();    // creo oggetto forecast

                // imposto il nome della città nell'oggetto forecast
                c.setCityName(tmp.getJSONObject("city").getString("name"));

                for (Object o : list){
                    JSONObject Jobject = (JSONObject) o;
                    Measurement m = new Measurement();

                    m.setDate(Long.parseLong(String.valueOf(Jobject.get("dt"))));

                    m.temperature = Jobject.getJSONObject("main").getDouble("temp");

                    m.humidity = Jobject.getJSONObject("main").getDouble("humidity");
                    m.pressure = Jobject.getJSONObject("main").getDouble("pressure");
                    m.visibility = Jobject.getDouble("visibility");
                    m.cloud = Jobject.getJSONObject("clouds").getDouble("all");
                    c.addMeasurement(m);
                }
                forecast.add(c);
            }

            // creo filtri
            DayFilter dayFilter = new DayFilter();
            HourFilter hourFilter = new HourFilter();

            // filtro
            forecast = dayFilter.filter(json,forecast);
            forecast = hourFilter.filter(json,forecast);

            return forecast.exportJSON();
        }
        return new JSONObject();
    }
}
