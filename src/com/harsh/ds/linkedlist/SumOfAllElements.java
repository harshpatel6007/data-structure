package com.harsh.ds.linkedlist;

public class SumOfAllElements {

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
		
		System.out.println(getSumOfAllElements(list.getHead()));
		System.out.println(getOddEvenSumOfAllElements(list.getHead(), true));
	}

	private static int getOddEvenSumOfAllElements(Node<Integer> head, boolean flag) {
		if(head == null) {
			return 0;
		}
		return flag ? (head.getValue() + getOddEvenSumOfAllElements(head.next, !flag)) : 
			(-1 * head.getValue() + getOddEvenSumOfAllElements(head.next, !flag));
	}

	private static int getSumOfAllElements(Node<Integer> head) {
		if(head == null) {
			return 0;
		}
		return head.getValue() + getSumOfAllElements(head.next);
	}
}
