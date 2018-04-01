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

public class RadixSort {
    
    static void Distribute(int[] arr, LinkedList[] digits, String digitType){
        for (int i = 0; i< arr.length; i++){
            if(digitType.equals("ones")){
                digits[arr[i] % 10].addLast(arr[i]); 
            }
            else{
                digits[arr[i] / 10].addLast(arr[i]);
            }
        }
    }
    
    static void Collect(LinkedList[] digits, int[] arr){
        int i = 0; 
        for (int digit = 0; digit < 10; ++digit){
            while(!digits[digit].isEmpty()){
                arr[i++] = (Integer)digits[digit].removeFirst();
            }
        }
    }
    
    static void display(int[] arr){
        System.out.println("DISPLAY"); 
        int i = 0; 
        while(i <arr.length){
            System.out.print(arr[i] + " "); 
            if(++i % 10 == 0){
                System.out.println(); 
            }
        }
    }
    //we create an array of wueues that will hold numbers, 0-9, 10-19, 20-29 osv 
    //then we are going to take the numbers that we are trying to sort and distribute them along the queues
    //that we created 
    //based on the values 
    //and then we collect them to one array by taking them in order
    
    public static void main(String[] args){
        final int size = 50; 
        final int numQueues = 10; 
        LinkedList<Integer>[] digits = new LinkedList[numQueues];
        for(int i = 0; i < numQueues; i++){
            digits[i] = new LinkedList(); 
        }
        int[] numbers = new int[size]; 
        for(int i = 0; i < size; ++i){
            numbers[i] = (int)(Math.random() * 100); 
            System.out.println(numbers[i]);
        }
        display(numbers); 
        Distribute(numbers, digits, "ones"); 
        Collect(digits, numbers); 
        display(numbers); 
        Distribute(numbers, digits, "tens"); 
        Collect(digits, numbers); 
        display(numbers); 
    }
}
