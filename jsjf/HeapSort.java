package jsjf;

/**
 * HeapSort sorts a given array inplace using an array that follows the maxheap structure. 
 * Does NOT use the ArrayHeap class - uses the existing array structure for efficiency.
 * 
 * @author Braighton Polack
 * @date July 29, 2018
 */
public class HeapSort<T>
{
	
	/**
     * Sorts the specified array using existing array as maxheap. -- More Memory Efficient Implementation
	 * 
	 * @param data the data to be sorted using a maxheap array structure
	 */
	public static <T extends Comparable<T>> void HeapSort(T[] data) 
	{
		//Rearrange the elements in the array so that it follows a maxheap structure
		for (int i = getParentIndex(data.length - 1); i >= 0; i--) 
            shiftIndex(data, data.length, i);
		
		//From the end of array to the second element
        for (int i = data.length - 1; i > 0; i--)
        {
	        //Swap the first element with the current element
            swap(data, 0, i);
            //Perform sift to restore the maxheap structure
            shiftIndex(data, i, 0);
        }

	}
	
	/**
     * Helper function used to convert the array to a maxheap array structure 
	 * 
	 * @param data the data to be sorted using a maxheap array structure
	 * @param heapSize the total length of the array (size of the heap)
	 * @param index the index of the value that will be shifted in the array
	 */
	private static <T extends Comparable<T>> void shiftIndex(T[] data, int heapSize, int index) 
	{
        
        int length = heapSize - 1;
		
        while (true)
        {
            int maxIndex = index;
            int leftChildIndex = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);

            if (leftChildIndex <= length && data[maxIndex].compareTo(data[leftChildIndex]) < 0) 
            	maxIndex = leftChildIndex;
            if (rightChildIndex <= length && data[maxIndex].compareTo(data[rightChildIndex]) < 0) 
            	maxIndex = rightChildIndex;

            if (index != maxIndex) 
            {
                swap(data, index, maxIndex);
                index = maxIndex;
            }
            else
                return;
        }
    }
    
    /**
     * Helper function used swap the location of two values in an array
	 * 
	 * @param data the data to be sorted using a maxheap array structure
	 * @param i the first index to be swapped
	 * @param j the second index to be swapped
	 */
    private static <T> void swap(T[] data, int i, int j)
    {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
	
	/**
     * Returns the parent index of an array index in a maxheap structure
	 * 
	 * @return int parent index
	 */
    private static int getParentIndex(int index)
    {
        return (index - 1) / 2;
    }
	
	/**
     * Returns the left child index of an array index in a maxheap structure
	 * 
	 * @return int left child index
	 */
    private static int getLeftChildIndex(int index)
    {
        return index * 2 + 1;
    }
	
	/**
     * Returns the right child index of an array index in a maxheap structure
	 * 
	 * @return int right child index
	 */
    private static int getRightChildIndex(int index)
    {
        return index * 2 + 2;
    }
	
}


