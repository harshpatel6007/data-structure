package com.harsh.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertInBinaryTree {

	public static void main(String[] args) {
		
		TreeNode<Integer> root = new TreeNode<Integer>(10);
		
		root.left = new TreeNode<Integer>(11);
		root.left.left = new TreeNode<Integer>(7);

		root.right = new TreeNode<Integer>(9);
		root.right.left = new TreeNode<Integer>(15);
		root.right.right = new TreeNode<Integer>(8);
		
		System.out.print("Before : ");
		inorderTraversal(root);
		insertNode(root, 12);
		deleteNode(root, new TreeNode<>(7));
		deleteNode(root, new TreeNode<>(8));
		deleteNode(root, new TreeNode<>(15));
		System.out.print("\nAfter : ");
		inorderTraversal(root);
	}
	
	public static <E> void inorderTraversal(TreeNode<E> node) {
		if(node == null) {
			return;
		}
		
		inorderTraversal(node.left);
		System.out.print(node.value + " ");
		inorderTraversal(node.right);
	}
	
	/**
	 * Iterate through all nodes and add element when find node with either left/right with null in last level
	 * 
	 * @param root
	 * @param value
	 */
	public static <E> void insertNode(TreeNode<E> root, E value) {
		Queue<TreeNode<E>> queue = new LinkedList<>();
		
		queue.add(root);
		while(!queue.isEmpty()) {
			
			TreeNode<E> current = queue.peek();
			queue.remove();
			
			if(current.left == null) {
				current.left = new TreeNode<E>(value);
				break;
			} else {
				queue.add(current.left);
			}
			
			if(current.right == null) {
				current.right = new TreeNode<E>(value);
				break;
			} else {
				queue.add(current.right);
			}
		}
	}
	
	/**
	 * Algo : 
	 *  Starting at root, find the deepest and rightmost node in binary tree and node which we want to delete.
	 *  Replace the deepest rightmost node’s data with node to be deleted.
	 *  Then delete the deepest rightmost node.
	 * 
	 * @param root
	 * @param nodeToDelete
	 */
	public static <E> void deleteNode(TreeNode<E> root, TreeNode<E> nodeToDelete) {
		Queue<TreeNode<E>> queue = new LinkedList<>();
		queue.add(root);
		
		TreeNode<E> deepest = null;//node to remove
		
		//find the deepest right/left element who's value will be replaced with node to delete
		while(!queue.isEmpty()) {
			 deepest = queue.poll();
			 
			 //this step is useful when node is not given
			 if(deepest.value == nodeToDelete.value) {
				 nodeToDelete = deepest;
			 }
			 
			 //left will be removed first if this is last condition
			 if(deepest.left != null) {
				 queue.add(deepest.left);
			 } 
			 
			 //right will be removed first
			 if(deepest.right != null) {
				 queue.add(deepest.right);
			 }
		}
		
		deleteNodeInternal(root, deepest);
		nodeToDelete.value = deepest.value;//replace deepest node's value to node to delete
	}

	/**
	 * Iterate through all nodes, when found node to delete set it to null and break flow
	 * 
	 * @param root
	 * @param deepest
	 */
	private static <E> void deleteNodeInternal(TreeNode<E> root, TreeNode<E> deepest) {
		Queue<TreeNode<E>> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode<E> current = queue.poll();
			
			if(current.left != null) {
				if(current.left == deepest) {
					current.left = null;
					break;
				} else {
					queue.add(current.left);
				}
			}
			
			if(current.right != null) {
				if(current.right == deepest) {
					current.right = null;
					break;
				} else {
					queue.add(current.right);
				}
			}
		}
	}
	
}


