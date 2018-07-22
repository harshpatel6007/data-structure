package com.harsh.ds.linkedlist;

public class CircularLinkedListWithLoopLength {

	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		//create loop
		list.getHead().next.next.next.next.next = list.getHead().next;
		
		boolean isCircular = list.isCircular();
		System.out.print("\nIs circular linked list? : " + isCircular);
		
		if(isCircular) {
			int size = getLengthOfLoop(list.getHead());
			System.out.println("loop size : " + size);
		}
	}

	private static <E> int getLengthOfLoop(Node<E> head) {
		Node<E> slow = head;
		Node<E> fast = head;
		
		Node<E> firstElementOfLoop = null;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(slow == fast) {
				firstElementOfLoop = slow;
				break;
			}
		}
		
		System.out.println("\nFirst element : " + firstElementOfLoop.value);
		
		Node<E> node = firstElementOfLoop;
		int size = 1;
		while(node.next != firstElementOfLoop) {
			node = node.next;
			size++;
		}
		return size;
	}
}

