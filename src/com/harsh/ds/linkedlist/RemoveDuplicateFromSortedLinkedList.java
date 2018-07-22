package com.harsh.ds.linkedlist;

public class RemoveDuplicateFromSortedLinkedList {

	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(0);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(5);
		list.add(5);
		list.add(5);
		list.add(5);
		list.add(5);
		list.add(5);
		list.add(6);
		list.add(6);
		list.add(6);
		
		System.out.print("List : ");
		list.print();
		removeDuplicateFromSorted(list);
		System.out.print("\nList : ");
		list.print();
	}
	
	/**
	 * Remove duplicate element from sorted linked list
	 */
	public static <E> void removeDuplicateFromSorted(LinkedList<E> list) {
		Node<E> head = list.getHead();
		if(head == null) {
			return;
		}
		Node<E> node = head;
		while(node.next != null) {
			if(node.value.equals(node.next.value)) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
	}
}
