/**
 * Giorgia Pavic
 * Riccardo Sasu
 */
package it.univpm.progettoPavicSasu.model;

import org.json.JSONObject;

/**
 * @author Riccardo Sasu
 * @author Giorgia Pavic
 */
public class CityWeather extends City{

	private Measurement measurement = new Measurement();
	
	/*
	 * Costruttore vuoto della classe
	 */
	public CityWeather() {
		
	}
	
	public CityWeather(String cityName, long dt, double temperature, double pressure, double visibility, double humidity, double cloud) {
		this.cityName = cityName;
		this.measurement.setDate(dt);
		this.measurement.temperature = temperature;
		this.measurement.pressure = pressure;
		this.measurement.visibility = visibility;
		this.measurement.humidity = humidity;
		this.measurement.cloud = cloud;
	}

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
	 * @return the temperature
	 */
	public double getTemperature() {
		return this.measurement.temperature;
	}

	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(double temperature) {
		this.measurement.temperature = temperature;
	}

	/**
	 * @return the pressure
	 */
	public double getPressure() {
		return this.measurement.pressure;
	}

	/**
	 * @param pressure the pressure to set
	 */
	public void setPressure(double pressure) {
		this.measurement.pressure = pressure;
	}

	/**
	 * @return the visibility
	 */
	public double getVisibility() {
		return this.measurement.visibility;
	}

	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(double visibility) {
		this.measurement.visibility = visibility;
	}

	/**
	 * @return the humidity
	 */
	public double getHumidity() {
		return this.measurement.humidity;
	}

	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(double humidity) {
		this.measurement.humidity = humidity;
	}

	/**
	 * @return the cloud
	 */
	public double getCloud() {
		return this.measurement.cloud;
	}

	/**
	 * @param cloud the cloud to set
	 */
	public void setCloud(double cloud) {
		this.measurement.cloud = cloud;
	}


	public void setDate(long dt){
		this.measurement.setDate(dt);
	}
	
	
	

}
