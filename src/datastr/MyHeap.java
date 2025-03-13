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
	
	// TODO
	// dequeue funkcijas deklaracija
	// parbaudes
	// saglabat elementu pedeja rinda no kreisas puses ieliekam 0 suna
	// izsaucam reheapdown
	// counter samazinam
	// athriezam dzesamo elementu
	
	
	public Ttype dequeue() throws Exception{
		if(isEmpty())
		{
			throw new Exception("Heap is empty and it is not possible to retrieve max element");
		}
		
		Ttype maxElement = heap[0];
		
		heap[0] = heap[counter-1];
		counter--;
		reheapDown(0);
	
		return maxElement;
	
	}
	
	//reheapDown
	
	private void reheapDown(int currentParentIndex)
	{
		int indexLeftChild = currentParentIndex * 2 + 1;
		int indexRightChild = currentParentIndex * 2 + 2;
		
		//  ja eksistē abi bērni:
		if(indexLeftChild < counter && indexRightChild < counter)
		{
			//    ja kreisai bērns ir lielāks par labo -> kreiso bērnu salīdzinam
			
			if(((Comparable)(heap[indexLeftChild])).compareTo(heap[indexRightChild]) == 1)
			{
				//      ar pasu elementu 
				
			if(((Comparable)(heap[indexLeftChild])).compareTo(heap[currentParentIndex]) ==1)
			{
				//un pēc nepieciesamības mainām vietām
				swap(indexLeftChild, currentParentIndex);
				//un izsaucam rekursīvi reheapDown
				reheapDown(indexLeftChild);
			
			}
				
			}
			else //labais bērns ir lielāks par kreiso
			{
				if(((Comparable)(heap[indexRightChild])).compareTo(heap[currentParentIndex]) ==1)
				{
					//un pēc nepieciesamības mainām vietām
					swap(indexRightChild, currentParentIndex);
					//un izsaucam rekursīvi reheapDown
					reheapDown(indexRightChild);
				
				}
			}		
		}
	}
	
	
	public void print() throws Exception{
		if (isEmpty()) {
			throw new Exception("Heap is empty and can't print");
		}
		
		printHelp(0);
	}
	
	private void printHelp(int currentParentIndex) {
		System.out.println("P -> " + heap[currentParentIndex]);
		
		int indexLeftChild = currentParentIndex * 2 + 1;
		int indexRightChild = currentParentIndex * 2 + 2;
		
		if (currentParentIndex * 2 + 1 < counter) {
			System.out.println("Left ch _> " + heap[indexLeftChild]);
			printHelp(indexLeftChild);
		}
		
		// ja eksiste labais berns
	}
	
	
	
	public void makeEmpty()
	{
		counter=0;
		size = DEFAULT_SIZE;
		heap = (Ttype[])new Object[size];
		System.gc();
	}

	
	// reheapdown funckcijas deklaracija
	// aprekinat kreisa un laba berna ideksus
	// izmantot counter noskaidrojam vai berni eskiste
	// ja eksiste abi berni 
		//ja kreisais berns ir lielaks par labo -> kreiso bernu salidzinam ar pasu elementu un pec nepieciesamibas
		// mainam ar vietam un izsaucam rekursivi reheapdown
		// ja labais ir lielaks par kreiso -> labo bernu saldzinam ar pasu elementu un pec nepieciesamibas mainam
		// vietam un izsaucam reheapdown.
	
	// ja eksiste tikai kreisais berns
	// ja nav bernu vispar (varbut var neapstradat)
	
	//print
	//makeempty
	
	

}
