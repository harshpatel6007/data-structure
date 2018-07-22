package com.harsh.ds.linkedlist;

public class ReverseLinkedList {

	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<>();
		list.add(17);
		list.add(15);
		list.add(8);
		list.add(12);
		list.add(10);
		list.add(5);
		list.add(4);
		list.add(1);
		list.add(7);
		list.add(6);
		
		System.out.print("List : ");
		list.print();
		list.reverse();
		System.out.print("\nReverse List : ");
		list.print();
	}
}
