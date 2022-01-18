package statistiche;

import it.univpm.progettoPavicSasu.model.CityForecast;
import it.univpm.progettoPavicSasu.model.Forecast;
import it.univpm.progettoPavicSasu.model.Measurement;
import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.DoubleStream;
/**
 * La classe contiene un metodo statico che permette di effettuare le statistiche sulle diverse rilevazioni del forecast
 * 
 * @author Giorgia Pavic
 * @author Riccardo Sasu
 * 
 * Composizione del Json per ottenere le statistiche:
 * {@code
 *   "cities" : ["Rome,IT" , "Berlin,DE"] ,
 *   "stats" : true
 * }
 */
public class Statistica {
   
	/**
	 * Metodo statico che restituisce le statistiche 
	 *
	 * @param json
	 * @return json con la statistica
	 * @throws ParseException
	 */
	
	
	public static JSONObject getStatistica(JSONObject json) throws ParseException {
        JSONArray cities = json.getJSONArray("cities");
        Forecast f = new Forecast();

        // popolo vettori
        for (int j = 0; j < cities.length(); j++) {
            JSONObject jsonObj = cities.getJSONObject(j);
            JSONObject stat = new JSONObject();
            JSONObject tmp = new JSONObject();
            double[] temperature;
            double[] pressure;
            double[] humidity;
            double[] cloud;
            JSONArray list = jsonObj.getJSONArray("list");
            // creo array per fare i calcoli
            temperature = new double[list.length()];
            pressure = new double[list.length()];
            humidity = new double[list.length()];
            cloud = new double[list.length()];
            for (int i = 0; i < list.length(); i++) {
                JSONObject m = list.getJSONObject(i);
                temperature[i] = m.getDouble("temperature");
                pressure[i] = m.getDouble("pressure");
                humidity[i] = m.getDouble("humidity");
                cloud[i] = m.getDouble("cloud");
            }
            for (double y : temperature)
                System.err.println(y);
            System.err.println("_____________________");
            // medie
            tmp.put("temperature", calcolaMedia(temperature));
            tmp.put("humidity", calcolaMedia(humidity));
            tmp.put("pressure", calcolaMedia(pressure));
            tmp.put("cloud", calcolaMedia(cloud));
            stat.put("medie", tmp);
            tmp = new JSONObject();
            // massimo
            tmp.put("temperature", calcolaMax(temperature));
            tmp.put("humidity", calcolaMax(humidity));
            tmp.put("pressure", calcolaMax(pressure));
            tmp.put("cloud", calcolaMax(cloud));
            stat.put("max", tmp);
            tmp = new JSONObject();
            // minimo
            tmp.put("temperature", calcolaMin(temperature));
            tmp.put("humidity", calcolaMin(humidity));
            tmp.put("pressure", calcolaMin(pressure));
            tmp.put("cloud", calcolaMin(cloud));
            stat.put("min", tmp);
            tmp = new JSONObject();
            // varianza
            tmp.put("temperature", calcolaVarianza(temperature));
            tmp.put("humidity", calcolaVarianza(humidity));
            tmp.put("pressure", calcolaVarianza(pressure));
            tmp.put("cloud", calcolaVarianza(cloud));
            stat.put("var", tmp);
            tmp = new JSONObject();
            json.getJSONArray("cities").getJSONObject(j).append("stats",stat);

        }


        return json;
    }
 
	/**
	 * Questo metodo statico serve per calcolare la media e utilizza la classe stream
	 * @param array
	 * @return valore della media
	 */
    private static double calcolaMedia(double[] array) {
        DoubleStream stream = Arrays.stream(array);
        Double max = stream.average().getAsDouble();

        return max;
    }

    /**
     *Questo metodo statico serve per calcolare il massimo e utilizza la classe stream
     * @param array
     * @return valore del massimo
     */
    private static double calcolaMax(double[] array) {
        DoubleStream stream = Arrays.stream(array);
        Double max = stream.max().getAsDouble();
        return max;
    }
 
    /**
     * Questo metodo statico serve per calcolare il minimo e utilizza la classe stream
     * @param array
     * @return valore del minimo
     */
    private static double calcolaMin(double[] array) {
        DoubleStream stream = Arrays.stream(array);
        Double min = stream.min().getAsDouble();
        return min;
    }

    /**
     * Questo metodo statico serve per calcolare la varianza e utilizza la classe stream
     * @param array
     * @return valore della varianza
     */
    private static double calcolaVarianza(double[] array) {
        Double m = calcolaMedia(array);
        double sommaScartiQuad = 0;
        for (int i = 0; i < array.length; i++)
            sommaScartiQuad += (array[i] - m) * (array[i] - m);
        return sommaScartiQuad / array.length;
    }

}
