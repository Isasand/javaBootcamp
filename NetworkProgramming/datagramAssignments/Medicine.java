package javaapplication10;

/**
 *
 * @author Isa
 */
public class Medicine extends Thread{
    String type; 
    double interval; 
    
    public Medicine(String medType, String times){
        type = medType;
        interval = (60/Integer.parseInt(times)) * 1000; 
    }
    
    @Override
    public void run(){
        while(!Thread.interrupted()){
            try{
                Thread.sleep(Math.round(interval)); 
                System.out.println("Its time to take " + type);
                
            }
            catch(InterruptedException e){
                break;
            }
        }
    }
    
}
