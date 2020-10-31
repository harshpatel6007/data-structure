package com.harsh.ds.tree;

public class IsBinarySearchTree {

	public static void main(String[] args) {
		
		BinaryTree<Integer> tree = new BinaryTree<>();
		
		tree.add(3);
		tree.add(2);
		tree.add(5);
		tree.add(1);
		tree.add(4);
		
		System.out.println("Is binary search tree : " + isBST(tree.getRoot()));
		System.out.println("Is binary search tree : " + isBST(tree.getRoot(), null, null));
	}

	/**
	 * Not working in given case
	 * 
	 * @param root
	 * @return
	 */
	private static boolean isBST(TreeNode<Integer> root) {
		if(root == null) {
			return true;
		}
		if(root.left != null && root.left.value > root.value) {
			return false;
		}
		if(root.right != null && root.right.value < root.value) {
			return false;
		}
		return isBST(root.left) && isBST(root.right); 
	}
	
	private static boolean isBST(TreeNode<Integer> root, TreeNode<Integer> left, TreeNode<Integer> right) {
	    // Base condition  
	    if (root == null)  
	        return true;  
	  
	    if (left != null && root.value <= left.value)  
	        return false;  
	  
	    if (right != null && root.value >= right.value)  
	        return false;  
	  
	    //for left child we should check it should be less than root, so root will be right
	    //for right child we should check it should be greater than root, so root will be the left
	    return isBST(root.left, left, root) &&  
	        isBST(root.right, root, right);  
	}
}
