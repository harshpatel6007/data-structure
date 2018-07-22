package com.harsh.ds.linkedlist;

public class SwapPairsInLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(10);
		list.add(12);
		list.add(15);
		list.add(89);
		list.add(20);
		list.add(3);
		list.add(90);
		
		//swap 10 and 20
		System.out.print("List : ");
		list.print();
		
		list.swapPairsUsingRefernce();
		
		System.out.print("\nList : ");
		list.print();
		
		list.swapPairsUsingValue();
		
		System.out.print("\nList : ");
		list.print();
	}

}
