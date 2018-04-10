
package chatclient2;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Isa
 */

public class ChatClient extends JFrame implements ActionListener{
    
    
    JButton connect = new JButton("KOPPLA UPP" ); 
    JTextArea outputArea = new JTextArea("", 10, 30);
    JTextField inputField  = new JTextField("");
    JPanel panel = new JPanel(); 
    String user; 
    boolean connected = false; 
    int toPort = 55555; 
    MulticastSocket socket; 
    ChatListener listener = new ChatListener(outputArea); 
    Thread t1;
    
    ChatClient() throws IOException{
        user = JOptionPane.showInputDialog(null, "user");
        setLocation(1000, 500); 
        setVisible(true); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        panel.setLayout(new BorderLayout()); 
        panel.add(connect, NORTH);
        
        JScrollPane scroll = new JScrollPane(outputArea); 
        panel.add(scroll, CENTER);
        panel.add(inputField, SOUTH); 
        add(panel);
        setTitle("Chat " + user);
        connect.addActionListener(this);
        pack(); 
        
        inputField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    if(connected)
                        SendMessage(inputField.getText());
            } catch (IOException ex) {
                Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
            }
                 inputField.setText(""); 
            }
        });
    }
    
    
    public static void main(String[] args) throws IOException{
        ChatClient client = new ChatClient(); 
    }
    
    
    public void actionPerformed(ActionEvent evt){
        if (evt.getSource() == connect){
            switch(connect.getText()){   
            case "KOPPLA UPP": connect.setText("KOPPLA NER"); 
            {
                connected = true; 
                
                listener.setState(true);
                t1  = new Thread(listener);
                t1.start();  
               
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    SendMessage("CONNECTED");
                } catch (IOException ex) {
                    Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;  
            case "KOPPLA NER": connect.setText("KOPPLA UPP"); 
            {
                
                try {
                    SendMessage("DISCONNECTED");
                } catch (IOException ex) {
                    Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println(ex.getMessage());
                }
                //repaint();
                connected = false; 
                listener.stop(); 
                try { 
                    t1.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }
        }
        if(evt.getSource() == inputField){
           
        }
    }
    
    public void SendMessage(String msg) throws UnknownHostException, IOException{
        socket = new MulticastSocket(); 
        InetAddress toAdr = InetAddress.getByName("234.235.236.237");
        socket.joinGroup(toAdr); 
        String message = user + ": " + msg + "\n"; 
        byte[] data = message.getBytes(); 
        DatagramPacket packet = new DatagramPacket(data, data.length, toAdr, toPort); 
        socket.send(packet); 
    }
}
    


