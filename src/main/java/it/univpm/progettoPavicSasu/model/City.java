/**
 * Giorgia Pavic
 * Riccardo Sasu
 */
package it.univpm.progettoPavicSasu.model;

import java.sql.Timestamp;
import java.util.Date;

import org.json.JSONObject;

/**
 * @author Riccardo
 *
 */
public class City {
	
	private String cityName;
	private Date date;
	private double temperature;
	private double pressure;
	private double visibility; 
	private double humidity;
	private double cloud;
	
	public City(String cityName, long dt, double temperature, double pressure, double visibility, double humidity, double cloud) {
		this.cityName = cityName;
		this.date = new Date(new Timestamp(dt).getTime());
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
		JSONObject res = new JSONObject();
		res.put(this.cityName, data);
		return res;
	}
	
	
	
	

}
