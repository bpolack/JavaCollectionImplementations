package jsjf;

import jsjf.exceptions.*;
import java.util.Iterator;

/**
 * A linked dropout stack implementation using a linked list. 
 * The bottom of the stack is lost on push in the case of a full stack.
 * 
 * @author Braighton Polack
 * @date July 10, 2018
 */
public class LinkedDropoutStack<T> implements StackADT<T>
{
	private final static int DEFAULT_CAPACITY = 5;
	
    private int count;
    private int maxCapacity; //Defines the maximum size of the dropout stack
    private LinearNode<T> top;
    private LinearNode<T> bottom;
	
	
	/**
     * Creates an empty stack using the default capacity.
     */
    public LinkedDropoutStack()
    {
        this(DEFAULT_CAPACITY);
    }
	
    /**
     * Creates an empty stack.
     * @param maxCapacity the maximum size of the dropout stack 
     */
    public LinkedDropoutStack(int capacity)
    {
        count = 0;
        maxCapacity = capacity;
        top = null;
		bottom = null;
    }
    
    
    /**
     * Private method to pop the bottom of the stack in the case of a full stack
     */
    private void popBottom() 
    {
		bottom = bottom.getPrev();
		bottom.getNext().setPrev(null);
		bottom.getNext().setNext(null);
		bottom.setNext(null);
		count--;
	}
	
    /**
     * Adds the specified element to the top of this stack.
     * @param element element to be pushed on stack
     */
    public void push(T element)
    {   
		
		LinearNode<T> temp = new LinearNode<T>(element);
		temp.setNext(top);
		
		if (isEmpty())
	        bottom = temp;
	    else if (count == 1)
	        bottom.setPrev(temp);
	    else if (count > 0) 
	        top.setPrev(temp);
		
		top = temp;
		count++;
		
		if (count > maxCapacity) {
			popBottom();
		}
    }

    /**
     * Removes the element at the top of this stack and returns a
     * reference to it. 
     * @return element from top of stack
     * @throws EmptyCollectionException if the stack is empty
     */
    public T pop() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        T result = top.getElement();
        top = top.getNext();
        top.setPrev(null);
        count--;
 
        return result;
    }
   
    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.  
     * @return element on top of stack
     * @throws EmptyCollectionException if the stack is empty  
     */
    public T peek() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");
        
        return top.getElement();
        
    }

    /**
     * Returns true if this stack is empty and false otherwise. 
     * @return true if stack is empty
     */
    public boolean isEmpty()
    {
        if (count == 0)
        	return true;
        else
        	return false;
    }
 
    /**
     * Returns the number of elements in this stack.
     * @return number of elements in the stack
     */
    public int size()
    {
        return count;
    }

    /**
     * Returns a string representation of this stack. 
     * @return string representation of the stack
     */
    public String toString()
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");
        
        //Start a new stringbuilder with the first stack element from top    
        StringBuilder result = new StringBuilder(top.getElement().toString());
        
	    LinearNode<T> next = top.getNext();
	    
	    //Iterate over the remaining elements using getNext()  
	    while(next != null) 
	    {
	        result.append("\n").append(next.getElement());
	        next = next.getNext();
	    }
	    
	    return result.toString();
    }
}
