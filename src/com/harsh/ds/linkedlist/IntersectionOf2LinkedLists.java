package com.harsh.ds.linkedlist;

import java.util.HashSet;

public class IntersectionOf2LinkedLists {

	public static void main(String[] args) {
		
		LinkedList<Integer> list1 = new LinkedList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(6);
		list1.add(8);
		
		LinkedList<Integer> list2 = new LinkedList<>();
		list2.add(2);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		list2.add(7);
		
		System.out.print("List1 : ");
		list1.print();
		
		System.out.print("\nList2 : ");
		list2.print();
		
		LinkedList<Integer> list =  printIntersectionList(list1, list2);
		System.out.print("\nIntersection List : ");
		list.print();
	}

	private static <E> LinkedList<E>  printIntersectionList(LinkedList<E> list1, LinkedList<E> list2) {
		LinkedList<E> list = new LinkedList<>();
		
		HashSet<E> set = new HashSet<>();
		Node<E> head1 = list1.getHead();
		while(head1 != null) {
			set.add(head1.value);
			head1 = head1.next;
		}
		
		Node<E> head2 = list2.getHead();
		while(head2 != null) {
			if(set.contains(head2.value)) {
				list.add(head2.value);
			}
			head2 = head2.next;
		}
		return list;
	}
}
