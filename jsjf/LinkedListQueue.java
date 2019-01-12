package jsjf;

import jsjf.exceptions.*;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * A Linked List implementation of a queue. 
 * Uses the java.util.LinkedList doubly-linked list implementation
 * 
 * @author Braighton Polack
 * @date July 16, 2018
 */
public class LinkedListQueue<T> implements QueueADT<T>
{
	
	private LinkedList<T> queue;
	
	/**
     * Initialize an empty queue using a LinkedList
     */
	public LinkedListQueue() 
	{
        queue = new LinkedList();
    }
	
	/**
     * Adds the specified element to the end of the list.
     * @param element generic element to be added into queue
     */
	public void enqueue(T element) 
	{
        queue.addLast(element);
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
            throw new EmptyCollectionException("LinkedListQueue");
        
        return queue.removeFirst();
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
            throw new EmptyCollectionException("LinkedListQueue");

        return queue.getFirst();
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
            throw new EmptyCollectionException("LinkedListQueue");
            
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