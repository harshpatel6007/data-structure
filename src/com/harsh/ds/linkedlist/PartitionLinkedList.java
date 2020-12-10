package com.harsh.ds.linkedlist;

public class PartitionLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(3);
		linkedList.add(5);
		linkedList.add(8);
		linkedList.add(5);
		linkedList.add(10);
		linkedList.add(2);
		linkedList.add(1);
		
		partitionList(linkedList.getHead(), 5);
	}

	private static void partitionList(Node<Integer> head, int i) {
		LinkedList<Integer> smaller = new LinkedList<>();
		LinkedList<Integer> larger = new LinkedList<>();
		while(head != null) {
			if(head.value < i) {
				smaller.add(head.value);
			} else {
				larger.add(head.value);
			}
			head = head.next;
		}
		
		Node<Integer> current = larger.getHead();
		while(current != null) {
			smaller.add(current.value);
			current = current.next;
		}
		
		System.out.println(smaller);
	}
}
