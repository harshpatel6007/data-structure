package com.harsh.ds.linkedlist;

public class MoveLastElementToFirstInLinkedList {

	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(10);
		list.add(12);
		list.add(15);
		list.add(89);
		list.add(20);
		list.add(3);
		list.add(90);
		
		System.out.println("List : ");
		list.print();
		
		list.swapFirstandLastElement();
		
		System.out.println("\nList : ");
		list.print();
	}
}
