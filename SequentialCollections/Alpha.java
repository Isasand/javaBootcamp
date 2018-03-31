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

import java.util.TreeSet; 

public class Alpha {
    public static void main(String[] args){
        TreeSet<String> names = new TreeSet<String>(); 
        names.add("Isa"); 
        names.add("Philip"); 
        names.add("Willy"); 
        names.add("David"); 
        
        System.out.println("Size of treeset: " + names.size()); 
        
        for (String name: names){
            System.out.println(name);
        }
        
        System.out.println("Name before Isa: " + names.lower("Isa"));
        System.out.println("Name after Isa: " + names.higher("Isa"));
        System.out.println("First element: " + names.first()); 
        System.out.println("Last element: " + names.last()); 
    }
}
