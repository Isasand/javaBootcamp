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

import java.util.ArrayList;

//Advantage for using arralist rather than array: 
//1. we can take advantage of the foreach for-loop to make 
//safer and easer access of elements
//and we can use the fact that arrayist is dynamic and not worry about the declared size of the array 
public class AList {
    
    public static void main(String[] args){
        //arraylist is dynamic sized arrays that implements List interface
       ArrayList<Integer> grades = new ArrayList<Integer>(); 
       grades.add(100); 
       grades.add(90); 
       grades.add(40); 
       grades.add(80); 
       grades.add(60);
       
       int total = 0;
       //this is how you would do it with an array and not the collection interface
       /*for(int i = 0; i< grades.size(); ++i){
           total += grades.get(i);
       }
       */
       
       //for each grade in the arraylist grades, add it to the total
       for (Integer grade : grades){
           total+=grade;
       }
       double average = total /grades.size(); 
       System.out.println("Size of grades: " + grades.size());
       System.out.println("Average: " + average);
       
       grades.remove(4); 
       
       System.out.println("New size: " + grades.size());
       grades.add(60); 
       grades.add(50); 
       
       System.out.println("New size: " + grades.size());
      
    }
    
    
}
