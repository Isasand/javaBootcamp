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
public class Pair<T1, T2> {
    private T1 firstItem; 
    private T2 secondItem; 
    
    public Pair(T1 first, T2 second){
        firstItem = first; 
        secondItem = second;
    }
    
    public T1 first(){
        return firstItem; 
    }
    
    public T2 second(){
        return secondItem; 
    }
    
    
}

