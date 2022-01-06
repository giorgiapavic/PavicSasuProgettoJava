/**
 * Giorgia Pavic
 * Riccardo Sasu
 */
package it.univpm.progettoPavicSasu.service;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Riccardo
 * @author Giorgia
 *
 */
@Service
public class HTTPService {
	private RestTemplate restTemplate;
	
	public HTTPService() {
		this.restTemplate = new RestTemplate();
	}
	
	public JSONObject request(String url){
		JSONObject json = new JSONObject(this.restTemplate.getForObject(url, String.class));
		return json;
	}
	
}
