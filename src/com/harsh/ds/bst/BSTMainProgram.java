package com.harsh.ds.bst;

public class BSTMainProgram {

	public static void main(String[] args) {
		
		BinarySearchTree tree = new BinarySearchTree();
		tree.add(3);
		tree.add(1);
		tree.add(2);
		tree.add(4);
		tree.add(5);
		
//		tree.delete(1);
		tree.effectiveDelete(3);
		tree.printInOrder(tree.getRoot());
	}
}
