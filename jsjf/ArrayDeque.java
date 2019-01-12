package jsjf;

import jsjf.exceptions.*;

/**
 * ArrayDeque represents an array implementation of a deque
 * 
 * @author Braighton Polack
 * @date July 10, 2018
 */
public class ArrayDeque<T> implements DequeADT<T>
{
    private final static int DEFAULT_CAPACITY = 100;
    private int capacity;
    private int front, rear, count;
    private T[] deque; 
  
    /**
     * Creates an empty deque using the specified capacity.
     * @param initialCapacity the initial size of the circular array deque
     */
    public ArrayDeque (int initialCapacity)
    {
        front = 1;
        rear = 0;
        count = 0;
        capacity = initialCapacity;
        deque = (T[]) (new Object[initialCapacity]);
    }
  
    /**
     * Creates an empty deque using the default capacity.
     */
    public ArrayDeque()
    {
        this(DEFAULT_CAPACITY);
    }    
    
    /**
     * Returns the corresponding value within mod (capacity)
     * @param value the value to adjust
     * @param mod the range to adjust values within (between 0 and mod)
     */
    private static int positiveMod(int value, int mod)
	{
	    return (value % mod + mod) % mod;
	}
	
	/**
     * Adds the specified element to the front of this deque, expanding
     * the capacity of the deque array if necessary.
     * @param element the element to add to the front of the deque
     */
    public void addFirst(T element) throws FullCollectionException 
    {
        if (count == capacity)
	        throw new FullCollectionException("deque");
      
		System.out.println(front);
		deque[front] = element;
	    front = positiveMod(front + 1, capacity);
	
	    count++;
		
    }
    
    /**
     * Adds the specified element to the rear of this deque, expanding
     * the capacity of the deque array if necessary.
     * @param element the element to add to the rear of the deque
     */
    public void addLast(T element) throws FullCollectionException 
    {
		if (count == capacity)
			throw new FullCollectionException("deque");
			
		System.out.println(rear);
		deque[rear] = element;
	    rear = positiveMod(rear - 1, capacity);
	
	    count++;
	
	}
	
    /**
     * Removes the element at the front of this deque and returns a
     * reference to it. 
	 * @return the element removed from the front of the deque
     * @throws EmptyCollectionException  if the deque is empty
     */
    public T removeFirst() throws EmptyCollectionException 
    {
		if (isEmpty())
			throw new EmptyCollectionException("deque");
		
		front = positiveMod(front - 1, capacity);
	    count--; 
	    
	    return deque[front];
	}
	
	/**
     * Removes the element at the end of this deque and returns a
     * reference to it. 
	 * @return the element removed from the end of the deque
     * @throws EmptyCollectionException  if the deque is empty
     */
	public T removeLast() throws EmptyCollectionException 
	{
		if (isEmpty())
			throw new EmptyCollectionException("deque");
		
		rear = positiveMod(rear + 1, capacity);
	    count--; 
	    
	    return deque[rear];
	}
  
    /** 
     * Returns a reference to the element at the front of this deque.
     * The element is not removed from the deque.  
     * @return the first element in the deque
     * @throws EmptyCollectionException if the deque is empty
     */
    public T first() throws EmptyCollectionException
    {
        if(isEmpty())
        	throw new EmptyCollectionException("deque");
        	
        return deque[positiveMod(front - 1, capacity)];
    }
    
    /** 
     * Returns a reference to the element at the end of this deque.
     * The element is not removed from the deque.  
     * @return the last element in the deque
     * @throws EmptyCollectionException if the deque is empty
     */
    public T last() throws EmptyCollectionException
    {
        if(isEmpty())
        	throw new EmptyCollectionException("deque");
        	
        return deque[positiveMod(rear + 1, capacity)];
    }
  
    /**
     * Returns true if this deque is empty and false otherwise.
     * @return true if this deque is empty 
     */
    public boolean isEmpty()
    {
        if (count == 0)
        	return true;
        else
        	return false;
    }
  
    /**
     * Returns the number of elements currently in this deque.
     * @return the size of the deque
     */
    public int size()
    {
        return count;
    }
  
    /**
     * Returns a string representation of this deque. 
     * @return the string representation of the deque
     */
    public String toString()
    {
        if (isEmpty())
            throw new EmptyCollectionException("deque");
            
        String result = "";
		
		int step = rear + 1;
	    for (int i = 0; i < count; i++)
	    {
		    result = result + deque[positiveMod(step, capacity)].toString() + "\n";
		    step++;
	    }
	
	    return result;
    }
}
