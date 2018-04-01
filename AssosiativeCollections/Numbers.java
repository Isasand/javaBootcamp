/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssosiativeCollections;

/**
 *
 * @author Isa
 */
import java.util.TreeMap; 

public class Numbers {
    public static void main(String[] args){
        TreeMap<String, String> numbers = new TreeMap<String, String>(); 
        numbers.put("David", "2333"); 
        numbers.put("Isa", "3444"); 
        numbers.put("Philip", "6877"); 
        System.out.println("Isa: "+ numbers.get("Isa")); 
        System.out.println("Size of numbers: " + numbers.size()); 
        numbers.remove("David"); 
        System.out.println("Size of numbers: " + numbers.size()); 
    }
}
