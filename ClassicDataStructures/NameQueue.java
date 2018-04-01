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

import java.util.LinkedList; 

public class NameQueue {
    public static void main(String[] args){
        LinkedList<String> names = new LinkedList<String>(); 
        names.addLast("isa"); 
        names.addLast("Philip"); 
        names.addLast("David"); 
        System.out.println();
        for (String name : names){
            System.out.println(name);
        }
        
        System.out.println("Size of queue: " + names.size());
        names.removeFirst();
        System.out.println();
        for (String name : names){
            System.out.println(name);
        }
        
        names.addLast("Sten");
        System.out.println();
        for (String name : names){
            System.out.println(name);
        }
        names.removeLast(); 
        System.out.println();
        for (String name : names){
            System.out.println(name);
        }
        System.out.println("Size of queue: " + names.size());
    }
}
