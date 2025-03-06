package datastr;

public class MyHeap <Ttype> {
	private Ttype[] heap;
	private final int DEFAULT_SIZE = 7;
	private int size = DEFAULT_SIZE;
	private int counter = 0;
	
	public MyHeap() {
		heap = (Ttype[]) new Object[size];
	}
	
	//argumenta konstruktors
	public MyHeap(int inputSize) {
		if(inputSize > 0) {
			size = inputSize;
		}
		heap = (Ttype[])new Object[size];		
	}
	
	private boolean isFull() {
		return (size == counter);
	}
	
	private boolean isEmpty()
	{
		return (counter == 0);
	}
	
	public int lenght()
	{
		return counter;
	}
	
	
	private void resize() {
		if(size < 100)
		{
			size = size * 2;
		}
		else
		{
			size = (int)(size * 1.5); //135.7 -> 135
		}
		
		Ttype[] heapNew = (Ttype[])new Object[size];
		
		for(int i = 0 ; i < counter; i++) {
			heapNew[i] = heap[i];	
		}
		
		heap = heapNew;
		
		System.gc();
			
	}
	
	
	
	
	//add - enqueue
	
	//remove - dequeue
	
	//reheapUp
	//reheapDown
	
	//print
	//makeempty
	
	

}
