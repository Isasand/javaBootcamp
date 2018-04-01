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
public class DataStructuresTests {
    public static void main(String[] args){
      TestBTree();
    }
    
    public static void TestBTree(){
        BinarySearchTree bst = new BinarySearchTree(); 
        bst.insert(10); 
        bst.insert(5); 
        bst.insert(9); 
    }
    
    public static void TestQueue(){
      Queue<String> queue = new Queue<String>(5);
      System.out.println("Enqueued five objects");
      queue.Enqueue("Philip"); 
      queue.Enqueue("David"); 
      queue.Enqueue("Walter"); 
      queue.Enqueue("Isa"); 
      queue.Enqueue("Name");
      System.out.println("Our queue: ");
      queue.Print(); 
      System.out.println("Dequeued object: " + queue.Dequeue());
      System.out.println("Our queue: ");
      queue.Print(); 
    }

    public static void TestMyStack(){
        MyStack<String> stack = new MyStack(4); 
        stack.push("ett");
        stack.push("två");
        stack.push("tre");
        stack.Print();
        System.out.println("Peek: " + stack.peek());
        stack.pop();
        System.out.println("Pop! Peek: " + stack.peek());
        stack.Print();
        System.out.println("Is empty: " + stack.isEmpty());
        stack.pop();
        System.out.println("Pop! Peek: " + stack.peek());
        stack.Print();
        System.out.println("Is empty: " + stack.isEmpty());
        stack.pop();
        System.out.println("Pop! Is empty: " + stack.isEmpty());
        
        stack.Print();
    }
}
