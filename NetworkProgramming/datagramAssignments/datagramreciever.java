package javaapplication10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

/**
 *
 * @author Isa
 */
public class DatagramReciever {
    
    public static void main(String[] args) throws SocketException, IOException{
       RecieveMulticast(); 
    }
    
    public static void Recieve()throws SocketException, IOException{
        int minPort = 55555; 
        DatagramSocket socket = new DatagramSocket(minPort);
        byte[] data = new byte[256]; 
        while(true){
            DatagramPacket packet = new DatagramPacket(data, data.length); 
            socket.receive(packet); 
            System.out.println("Message from " + packet.getAddress().getHostAddress()); 
            String message = new String(packet.getData(), 0, packet.getLength()); 
            System.out.println(message); 
        }
    }
    
    public static void RecieveMulticast() throws IOException{
        int minPort = 55555; 
        MulticastSocket socket = new MulticastSocket(minPort);
        socket.joinGroup(InetAddress.getByName("234.235.236.237"));
        byte[] data = new byte[256]; 
        while(true){
            DatagramPacket packet = new DatagramPacket(data, data.length); 
            socket.receive(packet); 
            System.out.println("Message from " + packet.getAddress().getHostAddress()); 
            String message = new String(packet.getData(), 0, packet.getLength()); 
            System.out.println(message); 
        }
    }
}
