package jsjf;

import jsjf.exceptions.*;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * A Linked List implementation of a stack. 
 * Uses the java.util.LinkedList Doubly-linked list implementation
 * 
 * @author Braighton Polack
 * @date July 16, 2018
 */
public class LinkedListStack<T> implements StackADT<T>
{
	
	private LinkedList<T> stack;
	
	/**
     * Initialize an empty stack using a LinkedList
     */
	public LinkedListStack() 
	{
        stack = new LinkedList();
    }
	
	/**
     * Adds the specified element to the start of the list.
     * @param element generic element to be pushed onto stack
     */
	public void push(T element) 
	{
        stack.addFirst(element);
    }
    
    /**
     * Removes the element at the start of the list and returns a
     * reference to it. 
     * @return element removed from top of stack
     * @throws EmptyCollectionException if stack is empty 
     */
    public T pop() throws EmptyCollectionException
    {

        if (isEmpty()) 
            throw new EmptyCollectionException("LinkedListStack");
        
        return stack.removeFirst();
    }
    
    /**
     * Returns a reference to the element at the start of the list.
     * The element is not removed from the stack.  
     * @return element on top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    public T peek() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("LinkedListStack");

        return stack.getFirst();
    }
    
    /**
     * Returns true if this stack is empty and false otherwise. 
     * @return true if this stack is empty
     */
    public boolean isEmpty() 
    {
        if (stack.size() == 0)
            return true;
        else
        	return false;
    }
    
    /**
     * Returns the number of elements in this stack.
     * @return the number of elements in the stack
     */
    public int size() {
        return stack.size();
    }
    
    /**
     * Returns a string representation of this stack. 
     * @return a string representation of the stack
     */
    public String toString()
    {
	    if (isEmpty())
            throw new EmptyCollectionException("LinkedListStack");
            
        String result = "";
        Iterator iterate = stack.iterator();
		
		//Iterate over the entire list, adding each element to the result string.
	    while(iterate.hasNext()) {
			Object element = iterate.next();
			result = result + element.toString() + "\n";
	    }
	
	    return result;
    }
	
}