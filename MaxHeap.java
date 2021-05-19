package project4package;
import java.util.Arrays;
import java.io.IOException;



public class MaxHeap<T extends Comparable<? super T>>
		implements MaxHeapInterface<T>
	
{
	private T[] heap;
	private int lastIndex;
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	private int swaps = 0;
	private int seqSwaps = 0;

	public MaxHeap ()
	{
		this(DEFAULT_CAPACITY); // Call next constructor
	} // end default constructor
	
	
	public MaxHeap(int initialCapacity)
	{
		if(initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;
		else // Is initialCapacity too big?
			checkCapacity(initialCapacity);

		@SuppressWarnings("unchecked")
		T[] tempHeap = (T[]) new Comparable[initialCapacity + 1];
		heap = tempHeap;
		lastIndex = 0;
		integrityOK = true;
	} // end constructor
	
	private void checkCapacity(int capacity) {
		  if (capacity > MAX_CAPACITY)
	            throw new IllegalStateException("Attempt to create a MaxHeap whose " +
	                    "capacity exeeds allowed " +
	                    "maximum of " + MAX_CAPACITY);
		
	}

	public MaxHeap(T[] entries) throws IOException
    {
        this(entries.length); // Call other constructor
        lastIndex = entries.length;
        // Assertion: integrityOK == true
        // Copy given array to data field
        for (int index = 0; index < entries.length; index++)
            heap[index + 1] = entries[index];
        // Create heap
        for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
        reheap(rootIndex);
    } 
	
	public T[] getHeap() 
	{
    	return heap;
    }

	public void add(T newEntry)
	{
		checkIntegrity(); // Ensure initialization of data fields
		int newIndex = lastIndex + 1;
		int parentIndex = newIndex / 2;
		while ( (parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0) 
		{
		heap[newIndex] = heap[parentIndex]; newIndex = parentIndex;
		parentIndex = newIndex / 2;
		seqSwaps++;
		} // end while
	heap[newIndex] = newEntry;
	lastIndex++;
	ensureCapacity();
	
	} // end add
	
	public int getSeqSwaps()
	{
		return seqSwaps;
	}
	
	public T removeMax()
	{
		checkIntegrity(); T root = null;
		if (!isEmpty())
		{
			root = heap[1];
			heap[1] = heap[lastIndex]; 
			lastIndex--;
			reheap(1);
		} // end if
		return root;
	} // end removeMax
	
	public T getMax() 
	{
		checkIntegrity(); T root = null;
		if (!isEmpty())
		root = heap[1]; return root;
	} // end getMax
		
	public boolean isEmpty() 
	{
		return lastIndex < 1; 
	}// end isEmpty
	
	public int getSize() 
	{
		return lastIndex; 
	}// end getSize
		
	public void clear() 
	{
		checkIntegrity(); 
		while (lastIndex > -1) 
		{
			heap[lastIndex] = null;
			lastIndex--; 
		} // end while 
		lastIndex = 0;
		
	} // end MaxHeap
	
	public int getSwaps()
	{
		return swaps;
	}
	
	
	private void checkIntegrity() {
		if (!integrityOK)
            throw new SecurityException("MaxHeap object is corrupt.");
	}

	private void ensureCapacity()
	{
		if (lastIndex >= heap.length)
		{
			int newCapacity = 2 * (heap.length - 1);
			checkCapacity(newCapacity);
			heap = Arrays.copyOf(heap, newCapacity);
		}
	}
	
	private void reheap(int rootIndex) {
		boolean done = false;
		T orphan = heap[rootIndex];
		int leftChildIndex = 2 * rootIndex;
		while (!done && (leftChildIndex <= lastIndex) )
		{
			int largerChildIndex = leftChildIndex; // Assume larger
			int rightChildIndex = leftChildIndex + 1;
			if ( (rightChildIndex <= lastIndex) && heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)
			{
				largerChildIndex = rightChildIndex;
			}
			if (orphan.compareTo(heap[largerChildIndex]) < 0)
			{
				heap[rootIndex] = heap[largerChildIndex];
				rootIndex = largerChildIndex;
				leftChildIndex = 2 * rootIndex;
				swaps++;
			}
			else
				done = true;
		}
		heap[rootIndex] = orphan;
	}
	
}
	
	
	

