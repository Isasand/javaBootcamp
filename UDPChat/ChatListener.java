package chatclient2;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author Isa
 */
public class ChatListener implements Runnable{
    
    int port = 55555; 
    JTextArea msgArea = new JTextArea(); 
    MulticastSocket socket; 
    boolean running = true; 
    
    ChatListener(JTextArea textArea) throws IOException{
        msgArea=textArea; 
    }
    
    @Override
    public void run(){
        
        try {
            socket = new MulticastSocket(port);
            socket.joinGroup(InetAddress.getByName("234.235.236.237"));
        } catch (UnknownHostException ex) {
            Logger.getLogger(ChatListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ChatListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] data = new byte[256]; 
        while(running){
            
            DatagramPacket packet = new DatagramPacket(data, data.length); 
            try { 
                socket.receive(packet);
            } catch (IOException ex) {
                Logger.getLogger(ChatListener.class.getName()).log(Level.SEVERE, null, ex);
            } 
            String message = new String(packet.getData(), 0, packet.getLength()); 
            msgArea.append(message);
            
        }
    }
    
    public void stop(){
        running = false; 
        socket.close(); 
    }
    
    public void setState(boolean state){
        running = state; 
    }

}


