package javaapplication10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit; 
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Isa
 */
public class DatagramSender {

    
    public static List<String> quotes = new ArrayList();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
      MultiCast();
    }
    
    public static void sendQuotes()throws UnknownHostException, SocketException, IOException, InterruptedException {
       quotes.add("\"Don\'t cry because it\'s over, smile because it happened.\" ? Dr. Seuss");
       quotes.add("\"Be yourself; everyone else is already taken.\" ? Oscar Wilde");
       quotes.add("\"So many books, so little time.\" ? Frank Zappa");
       quotes.add("\"A room without books is like a body without a soul.\"? Marcus Tullius Cicero");
       quotes.add("\"Be the change that you wish to see in the world.\"? Mahatma Gandhi");
       //BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
       
       InetAddress toAdr = InetAddress.getLocalHost(); 
       int toPort = 55555; 
       DatagramSocket socket = new DatagramSocket(); 
       int i= 0; 
       
       while(true){
           String message = quotes.get(i);
           byte[] data = message.getBytes(); 
           DatagramPacket packet = new DatagramPacket(data, data.length, toAdr, toPort); 
           socket.send(packet); 
           System.out.println("Sending quote: " + message);
           i = (i == 5)? 0 : +1; 
           TimeUnit.MINUTES.sleep(5);
       }
    }
    
    public static void SensorProgram() throws SocketException, UnknownHostException, IOException{
        
        InetAddress toAdr = InetAddress.getLocalHost(); 
        int toPort = 55555; 
        DatagramSocket socket = new DatagramSocket(); 
        
        String temp; 
        String city; 
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("City: ");
            city = sc.next(); 
            System.out.println("Temperature: ");
            temp = sc.next(); 
            String message = "City: " + city + ", Temperature: "+ temp; 
            byte[] data = message.getBytes(); 
            DatagramPacket packet = new DatagramPacket(data, data.length, toAdr, toPort); 
            socket.send(packet); 
            System.out.println("Sending message: " + message);
        } 
    }
    
    public static void MedicinePlanner(){
        Medicine one = new Medicine(JOptionPane.showInputDialog(null, "medicintyp"), JOptionPane.showInputDialog(null, "Gånger per minut"));
        Medicine two = new Medicine(JOptionPane.showInputDialog(null, "medicintyp"), JOptionPane.showInputDialog(null, "Gånger per minut"));
        Medicine three = new Medicine(JOptionPane.showInputDialog(null, "medicintyp"), JOptionPane.showInputDialog(null, "Gånger per minut"));
        
        one.start(); 
        two.start(); 
        three.start(); 
    }
    
    public static void MultiCast() throws UnknownHostException, IOException{
       
        InetAddress toAdr = InetAddress.getByName("234.235.236.237");
        int toPort = 55555; 
        MulticastSocket socket = new MulticastSocket(); 
        socket.joinGroup(toAdr); 
        String temp; 
        String city; 
        Scanner sc = new Scanner(System.in);
          while(true){
            System.out.println("City: ");
            city = sc.next(); 
            System.out.println("Temperature: ");
            temp = sc.next(); 
            String message = "City: " + city + ", Temperature: "+ temp; 
            byte[] data = message.getBytes(); 
            DatagramPacket packet = new DatagramPacket(data, data.length, toAdr, toPort); 
            socket.send(packet); 
            System.out.println("Sending message: " + message);
        }
    }
    
}
