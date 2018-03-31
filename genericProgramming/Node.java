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
public class Node<T> {
    private T data; 
    public Node next; 
    
    public Node(T data){
        this.data = data; 
        next = null; 
    }
    
    T getData(){
        return data; 
    }
}
