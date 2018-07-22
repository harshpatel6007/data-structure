package com.harsh.ds.linkedlist;

public class OddEvenLinkedList {

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
		
		System.out.println("List : ");
		list.print();
		
		System.out.println();
		seggregateEvenOdd(list);
		
	}

	private static <E> void seggregateEvenOdd(LinkedList<E> list) {
		LinkedList<E> oddList = new LinkedList<>();
		LinkedList<E> evenList = new LinkedList<>();
		Node<E> node = list.getHead();
		
		while(node != null) {
			if((Integer)node.value % 2 == 0) {
				evenList.add(node.value);
			} else {
				oddList.add(node.value);
			}
			node = node.next;
		}
		
		evenList.getTail().next = oddList.getHead();
		
		evenList.print();
	}
}
