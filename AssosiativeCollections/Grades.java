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
import java.util.HashMap; 

public class Grades {
    public static void main(String[] args){
        HashMap<String, Integer> grades = new HashMap<String, Integer>(); 
        grades.put("Isa", 88); 
        grades.put("Philip", 90);
        grades.put("David", 100); 
        grades.put("Willy", 50); 
        System.out.println("Isas grade: " + grades.get("Isa")); 
        System.out.println("Size of hashmap: " + grades.size()); 
        if(grades.containsKey("David")){
            grades.remove("David");
            System.out.println("Record succesfully removed");
        }
        System.out.println("size of grades: "+ grades.size());
        
    }
}
