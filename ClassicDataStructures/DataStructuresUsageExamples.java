/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassicDataStructures;

/**
 *
 * @author Isa
 */
import java.util.*; 

public class DataStructuresUsageExamples {
    
    
    public static void main(String[] args){
        int num = 5; 
        System.out.println("Binary of " + num +" is: " + binary(num)); 
    }
    
    //convert a number to a binary form with a stack
    public static String binary(int number){
        final int base = 2; 
        Stack digits = new Stack(); 
        
        do{
            digits.push(number % base); //we push the result of number modulus base, it will end up being a bit or a binary digit
            number /= base;//divide the number with the base and store it back in number
        } while(number != 0);
        
        String bits = ""; 
        while(!digits.empty()){
            bits += digits.peek(); 
            digits.pop(); 
        }
        return bits;
    }
}
