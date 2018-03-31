/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mypackage;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.POST;
import java.util.List;
import javax.ws.rs.PathParam;

@Path ("/WeatherStation")
/**
 *
 * @author Isa
 */
public class MyService {
    private static SqlClient client = new SqlClient(); 
    static List<WeatherStationReport> list = client.getAllReports();
    
    @GET 
    @Path("/reports/latest")
    @Produces(MediaType.TEXT_PLAIN)
    public String getLatestReportPlain(){
        String rep = ""; 
        WeatherStationReport report = client.getLatestReport(); 
        rep += "date: " + report.getTimeStamp() + "\n";
        rep += "temperature: " + report.getTemp() + "\n"; 
        rep += "humidity: "+ report.getHum() + "\n"; 
        rep += "lights: " + report.getLights() + "\n"; 
        rep += "kwh: " + report.getKwh() + "\n";
        rep += "log type: " + report.getLogType();
        return rep;
    }
    
    @GET 
    @Path("/reports/latest.xml")
    @Produces(MediaType.APPLICATION_XML)
    public WeatherStationReport getLatestReportXml(){
        return client.getLatestReport();
    }
    
    @GET
    @Path("/reports.xml")
    @Produces(MediaType.APPLICATION_XML)
    public List<WeatherStationReport> getReportXml(){
       return list;
    }
    
      
    @GET
    @Path("/reports.json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<WeatherStationReport> getReportJson(){
        return list;
    }
    
    @GET
    @Path("/{value}/weeklyreport")
    @Produces(MediaType.TEXT_PLAIN)
    public String getValueWeeklyReport(@PathParam("value") String value){
        String rep = client.getWeeklyReport(value);
        return rep;
    }
    
    @GET 
    @Path("/kwh/weeklyusage")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTotalKwh() throws SQLException{
        double total = client.getTotalKwh();
        return Double.toString(total);
    }
   
    @GET
    @Path("/{value}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getValue(@PathParam("value") String value){
        String val = client.getLastValue(value);
        return val; 
    }
    
    @POST
    @Path("/update")
    public Response updateValues(WeatherStationReport report)throws SQLException{
        Response res = new Response("Everything went well", client.UpdateValues(report)); 
        return res;
    }
    
    
}
