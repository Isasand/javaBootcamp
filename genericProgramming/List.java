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
public class List<T> implements IList<T>{
    private T[] datastore; 
    private int size; 
    private int pos; 
    
    public List(int numElements){
        size = numElements; 
        pos = 0; 
        datastore = (T[]) new Object[size]; //create a new object array and cast it to the datatype that is going to be provided later
    }
    
    //add element to datastore and give pos a +1
    public void add(T element){
        datastore[pos] = element; 
        ++pos; 
    }
    
    public T get(int n){
        return datastore[n];
    }
    
    public String toString(){
        String elements = ""; 
        for(int i = 0; i<pos; i++){
            elements+= datastore[i]+" ";
        }
        return elements;
    }
}
