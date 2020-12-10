package com.harsh.ds.linkedlist;

import java.util.Stack;

class LinkedList<E> {
	Node<E> head = null;
	Node<E> tail = null;
	/**
	 * add given element in linked list
	 * 
	 * @param e
	 */
	public void add(E e) {
		if(head == null) {
			head = new Node<E>(e, null);
			tail = head;
		} else {
			tail.next = new Node<E>(e, null);
			tail = tail.next;
		}
	}
	
	/**
	 * Iterate up to middle element and push each element in stack
	 * once reach middle element start comparing next value with stack value
	 * if all entries match its palindrome
	 * 
	 * @return
	 */
	public boolean isPalindrome() {
		
		Stack<E> stack = new Stack<>();
		Node<E> slow = head;
		Node<E> fast = head;
		while(fast.next != null && fast.next.next != null) {
			stack.push(slow.value);
			fast = fast.next.next;
			slow = slow.next;
		}
		boolean isPalindrome = true;
		while(slow.next != null) {
			if(slow.next.getValue() != stack.pop()) {
				isPalindrome = false;
				break;
			}
			slow = slow.next; 
		}
		
		return isPalindrome;
	}

	/**
	 * print linked list
	 */
	public void print() {
		Node<E> node = head;
		while(node.next != null) {
			System.out.print(node.getValue() + ", ");
			node = node.next;
		}
		System.out.print(node.getValue());
	}
	
	/**
	 *  print reverse linked list
	 */
	public void printReverse() {
		Node<E> node = head;
		printReverseInternal(node);
	}

	/**
	 * using recursion
	 * can be done by stack
	 * 
	 * @param node
	 */
	private void printReverseInternal(Node<E> node) {
		if(node.next == null) {
			System.out.print(node.getValue());
		} else {
			printReverseInternal(node.next);
			System.out.print(", " + node.getValue());
		}
	}
	
	/**
	 * Take 2 pointers, one with single speed, one with double speed
	 * iterate until fast pointer reach end of linked list
	 * when it reached last element slow represent middle element 
	 */
	public void printMiddleElement() {
		Node<E> slow = head;
		Node<E> fast = head;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		System.out.println(slow.getValue());
	}
	
	/**
	 * delete element with given value
	 * 
	 * @param value
	 * @return
	 */
	public boolean deleteElement(E value) {
		Node<E> node = head;
		while(node != null && node.next != null) {
			if(node.next.value == value) {
				node.next = node.next.next;
				return true;
			}
			node = node.next;
		}
		return false;
	}
	
	/**
	 * @return size of linked list
	 */
	public int size() {
		int size = 0;
		Node<E> node = head;
		while(node != null) {
			size++;
			node = node.next;
		}
		return size;
	}
	
	/**
	 * check given element exists in linked list
	 * 
	 * @param value
	 * @return
	 */
	public boolean contains(E value) {
		Node<E> node  = head;
		while(node != null) {
			if(node.value.equals(value)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}
	
	/**
	 * find and return node at given position
	 * 
	 * @param position
	 * @return
	 */
	public E getNodeAtPosition(int position) {
		insureCapacity(position);
		int count = 0;
		Node<E> node = head;
		while(node != null) {
			if(count == position) {
				return node.value;
			}
			count++;
			node = node.next;
		}
		return null;
	}
	
	/**
	 * Get element at given position from end of linked list
	 * 
	 * Algo : 2 Pointers
	 * 	Initialize 2 pointers with head
	 * 	increase 1 of them to n position
	 * 	now increment both, once faster reach end slower will reach at desired position
	 * 
	 * @param position
	 * @return
	 */
	public E getNodeAtPositionFromEnd(int position) {
		insureCapacity(position);
		Node<E> fast = head;
		Node<E> slow = head;
		int count = 0;
		while(count < position) {
			count++;
			fast = fast.next;
		}
		
		//reach to end
		while(fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow.value;
	}

	/**
	 * Ensure position is appropriate to size 
	 * 
	 * @param position
	 */
	private void insureCapacity(int position) {
		if(position < 0 || position > size() - 1) {
			throw new IllegalArgumentException(position + " greater than actual size or negative");
		}
	}
	
	/**
	 * return head, so external operation can be performed on list.
	 * @see RemoveDuplicateFromSortedLinkedList#removeDuplicateFromSorted(LinkedList)
	 * 
	 * @return
	 */
	public Node<E> getHead() {
		return head;
	}
	
	/**
	 * return tail, so external operation can be performed on list.
	 * @see OddEvenLinkedList#OddEvenLinkedList()
	 * 
	 * @return
	 */
	public Node<E> getTail() {
		return tail;
	}
	
	/**
	 * set head, so external operation can be performed on list.
	 * @see SwapNodeInLinkedList#swapNodeWithValues(int, int, LinkedList)
	 * 
	 * @return
	 */
	public void setHead(Node<E> head) {
		this.head = head;
	}
	
	/**
	 * swap nodes with value x and y
	 * 
	 * @param x
	 * @param y
	 */
	public void swapNodeWithValues(E x, E y) {
		Node<E> prevX = null, currX = null;
		Node<E> prevY = null, currY = null;
		
		//both are same value, no need to swap
		if(x == y) {
			return;
		}
		
		//find previous and current pointer of values
		Node<E> current = head;
		Node<E> prev = null;
		while(current != null) {
			if(current.value.equals(x)) {
				prevX = prev;
				currX = current;
			}
			if(current.value.equals(y)) {
				prevY = prev;
				currY = current;
			}
			prev = current;
			current = current.next;
		}
		
		//either x or y not exists in list
		if(currX == null || currY == null) {
			return;
		}
		
		//x is head, so place y as head
		if(prevX == null) {
			head = currY;
		} else {
			prevX.next = currY;
		}
		
		//Y is head, so place x as head
		if(prevY == null) {
			head = currX;
		} else {
			prevY.next = currX;
		}
		
		//swap next pointers of both currX and currY
		Node<E> temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;
	}
	
	/**
	 * Swap pairs using changing reference of nodes
	 */
	public void swapPairsUsingRefernce() {
		Node<E> current = head;
		Node<E> prev = null;
		
		while(current.next != null) {
			
			Node<E> temp = current.next;

			current.next = temp.next;
			temp.next = current;
			
			if(prev == null) {
				head = temp;
			} else {
				prev.next = temp;
			}

			prev = current;
			current = current.next;
		}
	}
	
	/**
	 * swap pairs by changing value of nodes
	 */
	public void swapPairsUsingValue() {
		Node<E> current = head;
		while(current.next != null) {
			E temp = current.next.value;
			current.next.value = current.value;
			current.value = temp;
			
			current = current.next.next;
		}
	}

	/**
	 * Swap first and last element 
	 */
	public void swapFirstandLastElement() {
		if(head == null) {
			return;
		}
		Node<E> node = head;
		//reach up to second last node
		while(node.next != null && node.next.next != null) {
			node = node.next;
		}
		
		Node<E> temp = node.next;//last element
		temp.next = head.next;
		node.next = head;
		node.next.next = null;
		head = temp;
	}
	
	/**
	 * Check linked list it circular or not
	 * 
	 * @return
	 */
	public boolean isCircular() {
		Node<E> slow = head;
		Node<E> fast = head;
		
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				return true;
			}
		}
		return false;
	}
	
	public void reverse() {
		Node<E> prev = null;
		Node<E> current = head;
		Node<E> next = null;
		
		while(current != null) {		
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		head = prev;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Node<E> node = head;
		while(node.next != null) {
			builder.append(node.getValue());
			builder.append(", ");
			node = node.next;
		}
		builder.append(node.getValue());
		return builder.toString();
	}
}