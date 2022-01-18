package it.univpm.progettoPavicSasu.model;

import org.json.JSONObject;

/**
 * la classe definisce la struttura base delle previsioni attuali
 * @author Riccardo Sasu
 * @author Giorgia Pavic
 */
public class CityWeather extends City{

	private Measurement measurement = new Measurement();
	
	/**
	 * Costruttore vuoto della classe
	 */
	public CityWeather() {
		
	}
	/**
	 * Costruttore della classe
	 * @param cityName
	 * @param dt
	 * @param temperature
	 * @param pressure
	 * @param visibility
	 * @param humidity
	 * @param cloud
	 */
	public CityWeather(String cityName, long dt, double temperature, double pressure, double visibility, double humidity, double cloud) {
		this.cityName = cityName;
		this.measurement.setDate(dt);
		this.measurement.temperature = temperature;
		this.measurement.pressure = pressure;
		this.measurement.visibility = visibility;
		this.measurement.humidity = humidity;
		this.measurement.cloud = cloud;
	}
	
    /**
     * Metodo per creare un json object dall'oggetto CityWeather
     * @return data json con le informazioni delle previsioni attuali 
     */
	@Override
	public JSONObject exportJson() {
		JSONObject data = new JSONObject();
		data.put("date",this.measurement.date);
		data.put("temperature", this.measurement.temperature);
		data.put("pressure", this.measurement.pressure);
		data.put("visibility", this.measurement.visibility);
		data.put("humidity", this.measurement.humidity);
		data.put("cloud", this.measurement.cloud);
		return data;
	}

	/**
	 * Metodo che restituisce la temperatura
	 * @return temperatura
	 */
	public double getTemperature() {
		return this.measurement.temperature;
	}

	/**
	 * Metodo che imposta la temperatura 
	 * @param temperature
	 */
	public void setTemperature(double temperature) {
		this.measurement.temperature = temperature;
	}

	/**
	 * Metodo che restituisce la pressione
	 * @return pressione
	 */
	public double getPressure() {
		return this.measurement.pressure;
	}

	/**
	 * Metodo che imposta la pressione
	 * @param pressure
	 */
	public void setPressure(double pressure) {
		this.measurement.pressure = pressure;
	}

	/**
	 * Metodo che restituisce la visibilità
	 * @return visibilità
	 */
	public double getVisibility() {
		return this.measurement.visibility;
	}

	/**
	 * Metodo che imposta la visibilità
	 * @param visibility
	 */
	public void setVisibility(double visibility) {
		this.measurement.visibility = visibility;
	}

	/**
	 * Metodo che restituisce l'umidità
	 * @return umidità
	 */
	public double getHumidity() {
		return this.measurement.humidity;
	}

	/**
	 * Metodo che imposta l'umidità
	 * @param humidity
	 */
	public void setHumidity(double humidity) {
		this.measurement.humidity = humidity;
	}

	/**
	 * Metodo che restituisce la nuvolosità
	 * @return nuvolosità
	 */
	public double getCloud() {
		return this.measurement.cloud;
	}

	/**
	 * Metodo che imposta la nuvolosità
	 * @param cloud
	 */
	public void setCloud(double cloud) {
		this.measurement.cloud = cloud;
	}

    /**
     * Metodo che imposta la data
     * @param dt
     */
	public void setDate(long dt){
		this.measurement.setDate(dt);
	}
	
	
	

}
