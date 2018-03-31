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
public class Main {
    
    
    public static void main(String[] args){
        ListDriver(); 
        GenericMethods test = new GenericMethods(); 
        test.test(); 
        PairProg();
        PrimitiveLinkedList primLL = new PrimitiveLinkedList();
        primLL.Create(); 
                
    }
    public static void ListDriver(){
        List<String> glist = new List<String>(10);
        glist.add("milk"); 
        glist.add("eggs"); 
        System.out.println("Grocery list: " + glist.toString());
        
        //use the object type and not the primitive type
        List<Integer> numbers = new List<Integer>(5); 
        numbers.add(1); 
        numbers.add(2); 
        numbers.add(6); 
        System.out.println("Numbers: " + numbers.toString());
    }
    
    public static void PairProg(){
        Pair<String, Integer> grade1 = new Pair<String, Integer> 
                ("isa", 100); 
        Pair<String, Integer> grade2 = new Pair<String, Integer>
                ("Philip", 90); 
        System.out.println(grade1.first()); 
        System.out.println(grade1.second());
        System.out.println(grade2.first()); 
        System.out.println(grade2.second()); 
    }
    
    
}
