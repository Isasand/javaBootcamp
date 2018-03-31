/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isasPackage;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author Isa
 */
@XmlRootElement(name = "weatherstationreport")
public class WeatherStationReport implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String timeStamp;
    private double temp;
    private double hum; 
    private int lights;
    private double kwh; 
    private String logType; 
   
    public WeatherStationReport(){
    }
    
    public WeatherStationReport(String timeStamp, double humidity, double temperature, int lights, double kwh, String logType){
        this.timeStamp =timeStamp;
        this.hum= humidity;
        this.temp = temperature;
        this.lights = lights; 
        this.kwh = kwh;
        this.logType = logType;
    }

    /**
     * @return the timeStamp
     */
    public String getTimeStamp() {
        return timeStamp;
    }
    @XmlElement
    /**
     * @param timeStamp the timeStamp to set
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * @return the temp
     */
    public double getTemp() {
        return temp;
    }
    @XmlElement
    /**
     * @param temp the temp to set
     */
    public void setTemp(double temp) {
        this.temp = temp;
    }

    /**
     * @return the hum
     */
    public double getHum() {
        return hum;
    }
    @XmlElement
    /**
     * @param hum the hum to set
     */
    public void setHum(double hum) {
        this.hum = hum;
    }

    /**
     * @return the lights
     */
    public int getLights() {
        return lights;
    }
    @XmlElement
    /**
     * @param lights the lights to set
     */
    public void setLights(int lights) {
        this.lights = lights;
    }

    /**
     * @return the kwh
     */
    public double getKwh() {
        return kwh;
    }
    @XmlElement
    /**
     * @param kwh the kwh to set
     */
    public void setKwh(double kwh) {
        this.kwh = kwh;
    }

    /**
     * @return the logType
     */
    public String getLogType() {
        return logType;
    }
    @XmlElement
    /**
     * @param logType the logType to set
     */
    public void setLogType(String logType) {
        this.logType = logType;
    }
}

  
    
