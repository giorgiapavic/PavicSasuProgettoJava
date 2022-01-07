/**
 * Giorgia Pavic
 * Riccardo Sasu
 */
package it.univpm.progettoPavicSasu.model;

import java.sql.Timestamp;
import java.util.Date;

import org.json.JSONObject;

/**
 * @author Riccardo Sasu
 * @author Giorgia Pavic
 */
public class City {
	
	private String cityName;
	private Date date;
	private double temperature;
	private double pressure;
	private double visibility; 
	private double humidity;
	private double cloud;
	
	/*
	 * Costruttore vuoto della classe
	 */
	public City() {
		
	}
	
	public City(String cityName, long dt, double temperature, double pressure, double visibility, double humidity, double cloud) {
		this.cityName = cityName;
		this.setDate(dt);
		this.temperature = temperature;
		this.pressure = pressure;
		this.visibility = visibility;
		this.humidity = humidity;
		this.cloud = cloud;
	}
	
	public JSONObject exportJson() {
		JSONObject data = new JSONObject();
		data.put("date",this.date);
		data.put("temperature", this.temperature);
		data.put("pressure", this.pressure);
		data.put("visibility", this.visibility);
		data.put("humidity", this.humidity);
		data.put("cloud", this.cloud);
		return data;
	}
	
	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(long dt) {
		this.date = new Date(dt * 1000);
	}

	/**
	 * @return the temperature
	 */
	public double getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	/**
	 * @return the pressure
	 */
	public double getPressure() {
		return pressure;
	}

	/**
	 * @param pressure the pressure to set
	 */
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	/**
	 * @return the visibility
	 */
	public double getVisibility() {
		return visibility;
	}

	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(double visibility) {
		this.visibility = visibility;
	}

	/**
	 * @return the humidity
	 */
	public double getHumidity() {
		return humidity;
	}

	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	/**
	 * @return the cloud
	 */
	public double getCloud() {
		return cloud;
	}

	/**
	 * @param cloud the cloud to set
	 */
	public void setCloud(double cloud) {
		this.cloud = cloud;
	}
	
	
	
	

}
