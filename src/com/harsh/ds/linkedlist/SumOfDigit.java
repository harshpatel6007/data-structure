package com.harsh.ds.linkedlist;

public class SumOfDigit {

	public static void main(String[] args) {
		
		LinkedList<Integer> digit1 = new LinkedList<>();
		digit1.add(7);
		digit1.add(5);
		digit1.add(9);
		digit1.add(4);
		digit1.add(6);
		
		LinkedList<Integer> digit2 = new LinkedList<>();
		digit2.add(8);
		digit2.add(4);
		
		
		printSum(digit1.getHead(), digit2.getHead());
		LinkedList<Integer> finalList = new LinkedList<Integer>();
		printSumRecursively(digit1.getHead(), digit2.getHead(), 0, finalList);
		System.out.println("Final List " + finalList);
	}

	private static void printSumRecursively(Node<Integer> head1, Node<Integer> head2, int carry, LinkedList<Integer> linkedList) {
		int digitSum = carry;
		if(head1 == null && head2 == null) {
			if(digitSum != 0) {
				linkedList.add(digitSum);
			}
			return;
		}
		if(head1 != null) {
			digitSum += head1.value;
			head1 = head1.next;
		}
		if(head2 != null) {
			digitSum += head2.value;
			head2 = head2.next;
		}
		if(digitSum >= 10) {
			carry = digitSum / 10;
		} else {
			carry = 0;
		}
		digitSum = digitSum % 10;
		linkedList.add(digitSum);
		printSumRecursively(head1, head2, carry, linkedList);
	}
	
	private static int getLength(Node<Integer> head) {
		int count = 0;
		while(head != null) {
			count++;
			head = head.next;
		}
		return count;
	}

	private static void printSum(Node<Integer> digit1, Node<Integer> digit2) {
		int index1 = 0;
		int power = 0;
		while(digit1 != null) {
			index1 += digit1.value * Math.pow(10, power);
			digit1 = digit1.next;
			power++;
		}
		
		int index2 = 0;
		power = 0;
		while(digit2 != null) {
			index2 += digit2.value * Math.pow(10, power);
			digit2 = digit2.next;
			power++;
		}
		
		int sum = index1 + index2;
		
		LinkedList<Integer> finalList = new LinkedList<>();
		while(sum > 0) {
			finalList.add(sum % 10);
			sum = sum / 10;
		}
		System.out.println(finalList);
	}
}
