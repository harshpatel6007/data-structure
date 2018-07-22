package com.harsh.ds.linkedlist;

class Node<E> {
	
	E value;
	Node<E> next;

	public Node(E e, Node<E> next) {
		this.value = e;
		this.next = next;
	}
	
	public E getValue() {
		return value;
	}

	public Node<E> getNext() {
		return next;
	}
}