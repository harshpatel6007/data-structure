package com.harsh.ds.tree;

public class TreeMainProgram {

	public static void main(String[] args) {
		
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		tree.add(5);
		tree.add(6);
		tree.add(7);
		
		tree.printBFS();

		tree.delete(1);
		
		tree.printBFS();
		tree.printInOrder();
		tree.printInOrderStack();
		System.out.println("Sum : " + tree.sum());
		
		
		BinaryTree<Integer> tree2 = new BinaryTree<Integer>();
		tree2.add(4);
		tree2.add(2);
		tree2.add(5);
		tree2.add(7);
		tree2.add(2);
		tree2.add(2);
		tree2.add(3);
		System.out.println("sum of parent of 6 : " + tree2.getSumOfParent(2));
		System.out.println("sum fo left tree " + tree2.getSumOfLeftLeaves());
		tree2.printBFS();
		
		System.out.println("sum fo left tree " + tree.getSumOfLeftLeaves());
		
	}
}
