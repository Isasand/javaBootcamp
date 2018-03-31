/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isasPackage;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.util.Random;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author Isa
 */
public class WeatherStationClient {
    private static ClientConfig config = new DefaultClientConfig();
    private static Client client = Client.create(config);
    private static WebResource service = client.resource(UriBuilder.fromUri("http://localhost:8080/isasRestTest").build());
    
    public String getUrl(String url){
        String result = service.path(url).get(String.class); 
        return result;
    }
    
    public ClientResponse PostNewReport(WeatherStationReport rep){
        ClientResponse response = service.path("rest/WeatherStation/update").accept(MediaType.APPLICATION_XML).post(ClientResponse.class, rep);
        return response; 
    }
    
    public WeatherStationReport CreateWeatherStationReport(String key, double val){
        Random r = new Random();
        double rangeMin = 22.5; 
        double rangeMax = 27.8; 
        double randomHum = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        double randomTemp = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        int lights = ("off".equals(getUrl("/rest/WeatherStation/lights"))) ? 1 : 0; 
        double kwh = Double.parseDouble(getUrl("/rest/WeatherStation/kwh")) + 2;
        
        switch(key){
            case "none": break; 
            case "hum" : randomHum = val; 
            break; 
            case "temp": randomTemp = val; 
            break; 
            case "lights": lights = ("off".equals(getUrl("rest/WeatherStation/lights"))) ? 1 : 0; 
            break;     
        }
        WeatherStationReport report = new WeatherStationReport("date", randomHum, randomTemp, lights, kwh, "man");
        return report;
    }
}
