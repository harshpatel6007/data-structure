package com.harsh.ds.tree;

public class IsBalancedBinaryTree {

	public static void main(String[] args) {
		
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		tree.add(5);
		
		System.out.println("Height of tree : " + height(tree.getRoot()));
		System.out.println("Height of tree : " + isBalanced(tree.getRoot()));
	}

	private static Integer height(TreeNode<Integer> root) {
		if(root == null) return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	private static boolean isBalanced(TreeNode<Integer> root) {
		if(root == null) return true;
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		if(Math.abs(rightHeight - leftHeight) <=1 && isBalanced(root.left) && isBalanced(root.right)) return true;
		
		return false;
	} 
}
