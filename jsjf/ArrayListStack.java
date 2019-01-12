package jsjf;

import jsjf.exceptions.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * An Array List implementation of a stack. 
 * Uses java.util.ArrayList 
 * 
 * @author Braighton Polack
 * @date July 16, 2018
 */
public class ArrayListStack<T> implements StackADT<T>
{
	
	private ArrayList<T> stack;
	
	/**
     * Initialize an empty stack using an ArrayList
     */
	public ArrayListStack() 
	{
        stack = new ArrayList();
    }
	
	/**
     * Adds the specified element to the end of the ArrayList (top of the stack).
     * @param element generic element to be pushed onto stack
     */
	public void push(T element) 
	{
        stack.add(element);
    }
    
    /**
     * Removes the element at the end of the ArrayList and returns a
     * reference to it. 
     * @return element removed from top of stack
     * @throws EmptyCollectionException if stack is empty 
     */
    public T pop() throws EmptyCollectionException
    {

        if (isEmpty()) 
            throw new EmptyCollectionException("ArrayListStack");
        
        return stack.remove(size() - 1);
    }
    
    /**
     * Returns a reference to the element at the end of the ArrayList.
     * The element is not removed from the stack.  
     * @return element on top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    public T peek() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("ArrayListStack");

        return stack.get(size() - 1);
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
            throw new EmptyCollectionException("ArrayListStack");
            
        String result = "";
        Iterator iterate = stack.iterator();
		
		//Iterate over the entire ArrayList, adding each element to the result string.
	    while(iterate.hasNext()) {
			Object element = iterate.next();
			result = result + element.toString() + "\n";
	    }
	
	    return result;
    }
	
}