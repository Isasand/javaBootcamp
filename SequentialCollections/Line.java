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
import java.util.PriorityQueue;

public class Line {
    public static void main(String[] args){
        PriorityQueue<String> line = new PriorityQueue<String>(); 
        
        line.add("Isa"); 
        line.add("David"); 
        line.add("Philip"); 
        line.add("Willy"); 
        System.out.println("The line: ");
        for (String name: line){
            System.out.println(name);
        }
        line.remove("Philip"); 
        System.out.println("The line: ");
        for (String name: line){
            System.out.println(name);
        }
        line.poll();//removes the head element
        System.out.println("The line: ");
        for (String name: line){
            System.out.println(name);
        }
        System.out.println("The head: " + line.peek());
    }
}
