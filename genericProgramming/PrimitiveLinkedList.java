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
public class PrimitiveLinkedList {
    
    public static void Create(){
        Node<String> node1 = new Node("node 1"); 
        Node<String> node2 = new Node("node 2"); 
        Node<String> node3 = new Node("node 3"); 
        node1.next = node2; 
        node2.next = node3; 
        Node<String> footer = new Node("Footer"); 
        node3.next = footer; 
        Node<String> dummy; 
        dummy = node1; 
        while(dummy.next != null){
            System.out.println(dummy.getData());
            dummy = dummy.next; 
        }
    }
}
