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
public class Queue<T> {
    private T[] datastore; 
    int size; 
    
    public Queue(int size){
        datastore = (T[]) new Object[size]; 
    }
    
    public T Dequeue(){
        T ret = datastore[size-1];
        datastore[size-1] = null; 
        --size;
        return ret; 
    }
    
    public void Enqueue(T object){
        datastore[size] = object; 
        ++size;
    }
    
    public void Print(){
        for (T object : datastore){
            System.out.println(object);
        }
    }
}
