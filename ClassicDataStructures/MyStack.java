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
import java.util.*; 


public class MyStack<T>{
    private T[] datastore; 
    private int size; 
    
    public MyStack(Integer size){
        datastore = (T[]) new Object[size]; 
    }
    
    public void pop(){
        datastore[this.size-1] = null;
        --this.size;
    }
    
    public T peek(){
        return datastore[this.size-1];
    }
    
    public void push(T object){
        datastore[this.size] = object;
        ++this.size;
     }
    
    public boolean isEmpty(){
        return (size == 0);
    }
    
    public void Print(){
        for (T object : datastore){
            System.out.println(object);
        }
    }
}
