package com.harsh.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstTraversal {

	public static void main(String[] args) {
		
		TreeNode<Integer> root = new TreeNode<Integer>(10);
		
		root.left = new TreeNode<Integer>(11);
		root.left.left = new TreeNode<Integer>(7);
		root.left.left.left = new TreeNode<Integer>(17);
		root.left.left.right = new TreeNode<Integer>(18);

		root.right = new TreeNode<Integer>(9);
		root.right.left = new TreeNode<Integer>(15);
		root.right.right = new TreeNode<Integer>(8);
		
		traverseBFS1(root);
	}
	
	public static <E> void traverseBFS(TreeNode<E> root) {
		Queue<TreeNode<E>> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			TreeNode<E> current = queue.poll();
			System.out.print(current.value + " ");
			
			if(current.left != null) {
				queue.add(current.left);
			}
			
			if(current.right != null) {
				queue.add(current.right);
			}
		}
	} 
	
	private static <E> void traverseBFS1(TreeNode<E> root) {
		System.out.print(root.value + " ");
		if(root.left != null)
			traverseBFS1(root.left);
		if(root.right != null)
			traverseBFS1(root.right);
	}
}
