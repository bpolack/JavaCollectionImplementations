package jsjf;

import jsjf.exceptions.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * An Array List implementation of a queue. 
 * Uses the java.util.ArrayList implementation
 * 
 * @author Braighton Polack
 * @date July 16, 2018
 */
public class ArrayListQueue<T> implements QueueADT<T>
{
	
	private ArrayList<T> queue;
	
	/**
     * Initialize an empty queue using an ArrayList
     */
	public ArrayListQueue() 
	{
        queue = new ArrayList();
    }
	
	/**
     * Adds the specified element to the end of the list.
     * @param element generic element to be added into queue
     */
	public void enqueue(T element) 
	{
        queue.add(element);
    }
    
    /**
     * Removes the element at the start of the list and returns a
     * reference to it. 
     * @return element removed from front of queue
     * @throws EmptyCollectionException if queue is empty 
     */
    public T dequeue() throws EmptyCollectionException
    {

        if (isEmpty()) 
            throw new EmptyCollectionException("ArrayListQueue");
        
        // index 0 is always the front of the queue
        T element = queue.get(0);
		queue.remove(0);
        
        return element;
    }
    
    /**
     * Returns a reference to the element at the start of the list.
     * The element is not removed from the queue.  
     * @return element on top of queue
     * @throws EmptyCollectionException if queue is empty
     */
    public T first() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("ArrayListQueue");

        return queue.get(0);
    }
    
    /**
     * Returns true if this queue is empty and false otherwise. 
     * @return true if this queue is empty
     */
    public boolean isEmpty() 
    {
        if (queue.size() == 0)
            return true;
        else
        	return false;
    }
    
    /**
     * Returns the number of elements in this queue.
     * @return the number of elements in the queue
     */
    public int size() {
        return queue.size();
    }
    
    /**
     * Returns a string representation of this queue. 
     * @return a string representation of the queue
     */
    public String toString()
    {
	    if (isEmpty())
            throw new EmptyCollectionException("ArrayListQueue");
            
        String result = "";
        Iterator iterate = queue.iterator();
		
		//Iterate over the entire list, adding each element to the result string.
	    while(iterate.hasNext()) {
			Object element = iterate.next();
			result = result + element.toString() + "\n";
	    }
	
	    return result;
    }
	
}