# Weatherstation REST-system
Description: 
  A service and client for a simulated weatherstation with data stored in mysql.
  Using JDBC, javax.ws.rs and glassfish. 
  The client GUI is written in swing, i will try to re-do it in JAVA FX asap..
 
Available methods: 
* GET /reports/latest
* GET /reports/latest.xml
* GET /reports 
* GET /reports.xml
* GET reports.json
* GET /{value}
* GET /{kwh}/weeklyusage
* GET /{value}/{weeklyreport}
* POST(weatherstationreport object)

![ScreenShot](https://raw.github.com/Isasand/javaBootcamp/master/WeatherstationREST-system/client.png)

In the client GUI you can get reports about temperature, humidity, lights and kwh. 
Reports from latest updated data in mysql or for the latest week. 
You can also add a new value for lights, temp or hum and the rest of the values will be random in a range or you could add new values to all of them with the log current values-button. 
And you can calculate price for kwh for the last week. 

