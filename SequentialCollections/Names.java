/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SequentialCollections;

/**
 *
 * @author Isa
 */

import java.util.HashSet; 

public class Names {
    public static void main(String[] args){
        HashSet<String> names = new HashSet<String>(); 
        names.add("Isa"); 
        names.add("Philip"); 
        names.add("David"); 
        
        System.out.println("The number of names in the hashset is: " + names.size()); 
        
        for(String name : names){
            System.out.println(name);
        }
        
        names.remove("David"); 
        names.add("Sten");
        String nametofind = "David"; 
        if(names.contains(nametofind)){
            System.out.println(nametofind + " is in the collection"); 
            
        }
        else{
            System.out.println(nametofind + " is not in the collection");
        }
        for(String name: names){
            System.out.println(name);
        }
        
        names.clear(); 
         System.out.println("The number of names in the hashset is: " + names.size()); 
        
    }
}
