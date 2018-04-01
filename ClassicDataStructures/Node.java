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
public class Node {
    public int data; 
    public Node left; 
    public Node right; 
    
    public Node(int data){
        this.data = data; 
        this.left = null; 
        this.right = null;
    }
    
    public Node(){
       this.left = null;
       this.right = null; 
    }
    
    int getdata(){
        return data; 
    }
}
