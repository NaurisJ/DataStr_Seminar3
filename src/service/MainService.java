package service;

import datastr.MyHeap;

public class MainService {

	public static void main(String[] args) {
		MyHeap<Integer> heapForIntegers = new MyHeap<Integer>(2);
		
		heapForIntegers.enqueue(2);
		heapForIntegers.enqueue(32);
		heapForIntegers.enqueue(33);
		heapForIntegers.enqueue(5);
		heapForIntegers.enqueue(41);
		
		try {
			heapForIntegers.print();
			System.out.println(heapForIntegers.dequeue()); // 41
			System.out.println(heapForIntegers.dequeue()); // 31
			System.out.println("---------------------------After dequeue -------------------------------------");
			
			heapForIntegers.makeEmpty();
			heapForIntegers.enqueue(100);
			heapForIntegers.enqueue(1000);
			heapForIntegers.print();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}