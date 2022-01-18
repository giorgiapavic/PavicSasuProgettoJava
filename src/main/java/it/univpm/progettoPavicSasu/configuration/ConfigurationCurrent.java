package it.univpm.progettoPavicSasu.configuration;

/**
 * Classe che definisce gli indirizzi e le metodologie di richiesta nel API
 * @author Riccardo Sasu
 * @author Giorgia Pavic
 */
public class ConfigurationCurrent {
	public final static String url = "http://api.openweathermap.org/data/2.5/weather";
	public final static String unit = "metric";
	public final static String token = "b199b911358fad3dbf6f4522253a09e9";
 
	/**
	 * Metodo che restituisce l'URL
	 * @return URL
	 */
	public static String getUri() {
		return url + "?units=" + unit + "&appid=" + token;
	}
	
}
