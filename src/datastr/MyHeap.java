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
	
	
	
	
	public void enqueue(Ttype element) {
		if(isFull())
		{
			resize();
		}
		
		
		heap[counter] = element;
		counter++;
		
		//reheapUp funcijas izsaukums
	}
	
	
	private void reheapUp(int currentIndex) {
		//kreisā bērna index =  vecāka index * 2 + 1
		//labā bērna index = vecāka index * 2 + 2
		
		//vecāka index = (kreisā bērna index -1 )/2
		//vecāka index = (labā bērna index -2 )/2
		
		
		
		int parentIndex = (int)(currentIndex -1 )/2; //mākslīgi labajam bērnam nogriežam .5
		
		if(parentIndex >= 0)
		{
			if( ((Comparable)heap[currentIndex]).compareTo(heap[parentIndex]) == 1)
			{
				swap(currentIndex, parentIndex);
				reheapUp(parentIndex);
			}
		}
		
		
		
		
	}
	private void swap(int index1, int index2) {
		Ttype temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
	//remove - dequeue
	
	//reheapUp
	//reheapDown
	
	//print
	//makeempty
	
	

}
