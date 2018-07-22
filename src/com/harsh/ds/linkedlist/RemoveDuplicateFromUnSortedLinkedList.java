package com.harsh.ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromUnSortedLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(2);
		list.add(3);
		list.add(1);
		
		System.out.print("List : ");
		list.print();
		removeDuplicateFromUnsortedList(list);
		System.out.print("\nList : ");
		list.print();
	}
	
	/**
	 * Remove duplicate element from un sorted linked list
	 */
	public static <E> void removeDuplicateFromUnsortedList(LinkedList<E> list) {
		Node<E> head = list.getHead();
		if(head == null) {
			return;
		}
		Set<E> set = new HashSet<E>();
		Node<E> node = head;
		while(node.next != null) {
			set.add(node.value);
			if(set.contains(node.next.value)) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
	}
}
