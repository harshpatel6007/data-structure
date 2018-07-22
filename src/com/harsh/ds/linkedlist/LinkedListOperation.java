package com.harsh.ds.linkedlist;

public class LinkedListOperation {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("One");
		list.add("Two");
//		list.add("Three");
		list.add("four");
		list.add("five");
//		list.add("Six");
		
		System.out.println("Size : " + list.size());
		
		System.out.print("revrese : ");
		list.printReverse();
		
		System.out.print("\nMiddle elemnt : ");
		list.printMiddleElement();
		
		System.out.println("Is palindrome : " + list.isPalindrome());
		System.out.println("Delete 3 : " + list.deleteElement("five"));
		
		System.out.print("List : ");
		list.print();
		
		System.out.println("\nSize : " + list.size());
		System.out.println("Contains 5 : " + list.contains("five"));
		
		System.out.print("List : ");
		list.print();
		
		int position = 2;
		System.out.println("\nNode at " + (position + 1) + " position : " + list.getNodeAtPosition(position));
		System.out.println("Node at " + (position + 1) + " position from end: " + list.getNodeAtPositionFromEnd(position));
		
	}
	
}




