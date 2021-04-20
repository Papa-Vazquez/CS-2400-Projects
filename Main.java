package project4package;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;




public class Main2 extends Maxheap<String>
{
	public static void main(String[] args) throws IOException
	{
		Scanner scannerRandom = new Scanner(new File("data_random.txt"));
		Integer[] randomArray =new Integer[100];
		while(scannerRandom.hasNextInt())
		{
			for (int i=0; i < 100; i++)
			randomArray[i] = scannerRandom.nextInt();	
		}
		
		Scanner scannerSorted = new Scanner(new File("data_sorted.txt"));
		Integer[] sortedArray =new Integer[100];
		while(scannerSorted.hasNextInt())
		{
			for (int i=0; i < 100; i++)
			sortedArray[i] = scannerSorted.nextInt();	
		}
		
		MaxHeapInterface randomHeap = new Maxheap<Integer>(100);
		MaxHeapInterface sortedSeqHeap = new Maxheap<Integer>(100);
		MaxHeapInterface randomOptimalHeap = new Maxheap<Integer>(randomArray);
		MaxHeapInterface sortedOptimalHeap = (MaxHeapInterface) new Maxheap<Integer>(sortedArray);
		
		for(int currentNum: randomArray)
		{
			randomHeap.add(currentNum);
		}
		for(int currentNum: sortedArray)
		{
			sortedSeqHeap.add(currentNum);
		}
		
		writeData(randomHeap, (MaxHeapInterface) randomOptimalHeap, "outputRandom.txt");
		writeData(sortedSeqHeap, sortedOptimalHeap, "outputSorted.txt");
	}
	
		
	

	public static void writeData(MaxHeapInterface SeqHeap, MaxHeapInterface sortedOptimalHeap, String fileName) throws IOException
	{
		Object[] sequentialOutput = SeqHeap.getHeap();
		Object[] optimalOutput = sortedOptimalHeap.getHeap ();
		
			BufferedWriter outputWriter = null;
			outputWriter = new BufferedWriter(new FileWriter(fileName));
			
			outputWriter.append("Heap build using sequential insertions: ");
			for (int i = 1; i < 11; i++)
			{
				outputWriter.append(String.valueOf(sequentialOutput[i]));
				if (i<10)
				{
					outputWriter.append(",");
				}
			}								
			outputWriter.append("\nSequential swap number: " + SeqHeap.getSeqSwaps() + "\n");
			
			for(int i =1; i<11; i++)
			{
				SeqHeap.removeMax();
			}
			outputWriter.append("Heap after 10 removals: ");
			sequentialOutput = SeqHeap.getHeap();
			
			for (int i=1; i<11; i++) {
				outputWriter.append(String.valueOf(sequentialOutput[i]) +"");
				if (i < 10)
				{
					outputWriter.append(",");
				}
			}
			
			outputWriter.append("\nHeap Optimal insertion: ");
			for (int i = 1; i < 11; i++)
			{
				outputWriter.append(String.valueOf(optimalOutput[i]));
				if (i<10)
				{
					outputWriter.append(",");
				}
			}
			
			outputWriter.append("\nSwaps in optimal heaps:" + sortedOptimalHeap.getSwaps() + "\n");
			
			for(int i = 1; i < 11; i++)
			{
				sortedOptimalHeap.removeMax();
			}
			outputWriter.append("Heap after 10 removals: ");
			optimalOutput = sortedOptimalHeap.getHeap();
			
			for (int i=1; i<11; i++)
			{
				outputWriter.append(String.valueOf(optimalOutput[i]));
				if (i<10)
				{
					outputWriter.append(",");
				}
			}
			
		
			outputWriter.flush();
			outputWriter.close();
	}
	
	
}
