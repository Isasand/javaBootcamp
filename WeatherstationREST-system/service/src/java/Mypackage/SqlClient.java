/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Isa
 */
public final class SqlClient {
    Connection con; 
    Statement stmt;
    
    public SqlClient(){
        connectToDB();
    }
    
    public void connectToDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weatherstation", username, password);
            stmt = con.createStatement();
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
    
    public String getLastValue(String value){
        
        try {
            String query = "select * from javatable ORDER BY timeStamp DESC";
            //con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                
              String temp = rs.getString("temperature");
              String hum = rs.getString("humidity"); 
              String timeStamp = rs.getString("timeStamp"); 
              int lights = rs.getInt("lights"); 
              String kwh = rs.getString("kwh"); 
              String logType = rs.getString("logType");
			  //will fix this so the query depends on the value rather than having a switch-case 
			  //after taking out the whole row from db
               switch(value){
                    case "temp": return temp;
                    case "hum": return hum;
                    case "lights": return (lights==1) ? "on" : "off";
                    case "time" : return timeStamp; 
                    case "kwh" : return kwh;
                    case "logType" : return logType;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlClient.class.getName()).log(Level.SEVERE, null, ex);
            return(ex.getMessage());
        }
        return null;
    }
   
    public WeatherStationReport getLatestReport(){
        WeatherStationReport report = new WeatherStationReport();
        try {
            String query = "select * from javatable ORDER BY timeStamp DESC";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                
              report.setTemp(rs.getDouble("temperature"));
              report.setHum(rs.getDouble("humidity")); 
              report.setTimeStamp(rs.getString("timeStamp")); 
              report.setLights(rs.getInt("lights")); 
              report.setKwh(rs.getDouble("kwh")); 
              report.setLogType(rs.getString("logType"));
              return report;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlClient.class.getName()).log(Level.SEVERE, null, ex);
            return(report);
        }
        return report;
    }
    
    public boolean UpdateValues(WeatherStationReport report){
        String timeStamp = DateHandler.getDateString(new Date());
        
        try{
            String query = "INSERT INTO `weatherstation`.`javatable` (`timeStamp`, `humidity`, `temperature`, `lights`, `kwh`, `logType`) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement satmt = con.prepareStatement(query); 
            
            satmt.setString(1, timeStamp);
            satmt.setString(2, String.valueOf(report.getHum()));
            satmt.setString(3,String.valueOf(report.getTemp()));
            satmt.setInt(4, report.getLights());
            satmt.setString(5, String.valueOf(report.getKwh()));
            satmt.setString(6,report.getLogType());
            satmt.executeUpdate();
            return true;
            
        }
        catch(SQLException ex){
            return false;
        }
    }
    
    public List<WeatherStationReport> getAllReports(){
        List<WeatherStationReport> ws_Report = new ArrayList<>();
        
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weatherstation", username, password);
                Statement stmt = con.createStatement(); 
                ResultSet rs = stmt.executeQuery("SELECT * FROM javatable")){
            while(rs.next()){
                String time = rs.getString("timeStamp");
                double temp = rs.getDouble("temperature");
                double hum = rs.getDouble("humidity");
                int lights = rs.getInt("lights"); 
                double kwh = rs.getDouble("kwh");
                String logType = rs.getString("logType");
                ws_Report.add(new WeatherStationReport(time, temp, hum, lights, kwh, logType));
            }
        }
        catch(Exception e){
            WeatherStationReport rep = new WeatherStationReport();
            ws_Report.add(rep);
        }
        
        return ws_Report;
    }
    
    public String getWeeklyReport(String value){
        String date = DateHandler.getDateString(new Date());
        long DAY_IN_MS = 1000 * 60 * 60 * 24;
        Date today = new Date();
        String aWeekAgo = DateHandler.getDateString(new Date(today.getTime() - (7 * DAY_IN_MS)));
        String report = ""; 
        double total = 0; 
        int sz = 0; 
        
        try {
            String query = "SELECT * FROM javatable WHERE timeStamp BETWEEN ? AND ?";
            
            PreparedStatement satmt = con.prepareStatement(query); 
            
            satmt.setString(1, aWeekAgo);
            satmt.setString(2, date);
            ResultSet rs = satmt.executeQuery();
            while(rs.next()){
              sz+=1; 
              report+="date: " + rs.getString("timeStamp");
              switch(value){
                  case "temp": report+=", temperature: " + rs.getString("temperature")+ "\n";
                  total +=rs.getDouble("temperature");
                  continue;
                  case "hum" : report+=", humidity: " + rs.getString("humidity") + "\n";
                  total +=rs.getDouble("humidity");
                  continue;
                  case "lights" : report+=", lights: "+ ((rs.getInt("lights")==1) ? "on" : "off")+ "\n";
                  total +=rs.getInt("lights");
                  continue;
                  case "kwh" : report += ", kwh: " + rs.getString("kwh")+ "\n"; 
                  total +=rs.getDouble("kwh");
                  continue; 
              }  
            }
            switch(value){
                case "lights" : report += "\nLights has been on " + total + " of 7 days";
                break;
                case "hum":
                case "kwh":
                case "temp" : report+= "\nAverage: " + Double.toString(total/sz);
                break;
            }  
        } catch (SQLException ex) {
            Logger.getLogger(SqlClient.class.getName()).log(Level.SEVERE, null, ex);
            
            report += ex.getMessage();
            return report;
        }
        
        return report;
    }
    
    public double getTotalKwh(){
        double total = 0 ;
        String date = DateHandler.getDateString(new Date());
        long DAY_IN_MS = 1000 * 60 * 60 * 24;
        Date today = new Date();
        String aWeekAgo = DateHandler.getDateString(new Date(today.getTime() - (7 * DAY_IN_MS))); 
        
        try {
            String query = "SELECT * FROM javatable WHERE timeStamp BETWEEN ? AND ?";
            
            PreparedStatement satmt = con.prepareStatement(query); 
            
            satmt.setString(1, aWeekAgo);
            satmt.setString(2, date);
            ResultSet rs = satmt.executeQuery();
            while(rs.next()){
               total +=rs.getDouble("kwh");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlClient.class.getName()).log(Level.SEVERE, null, ex);
            return total;
        }
        
        return total;
    }
    
}
