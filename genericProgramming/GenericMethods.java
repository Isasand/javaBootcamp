/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericprogramming;

/**
 *
 * @author Isa
 */
public class GenericMethods {
    
    static<T> void Display(T[] arr){
        for (int i= 0; i< arr.length; i++){
            if(arr[i] != null){
                System.out.print(arr[i] + " ");
            }
        }
    }
    
    public static void test(){
        String[] names = new String[10];
        names[0] = "Philip"; 
        names[1] = "David";
        names[2] = "Isa"; 
        Display(names); 
        
        //only works with object data types, not primitive
        Integer[] numbers = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(); 
        Display(numbers);
    }
    
    
}
