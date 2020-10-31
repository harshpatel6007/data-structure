package com.harsh.ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T> {

	private TreeNode<T> root;
	
	public void add(T value) {
		
		if(root == null) {
			root = new TreeNode<T>(value);
			return;
		}
		
		Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
		// add root
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode<T> current = queue.poll();
			
			//add left
			if(current.left == null) {
				current.left = new TreeNode<T>(value);
				break;
			} else {
				queue.add(current.left);
			}
			
			//add right
			if(current.right == null) {
				current.right = new TreeNode<T>(value);
				break;
			} else {
				queue.add(current.right);
			}
		}
	}
	
	public TreeNode<T> getRoot() {
		return this.root;
	}

	public boolean delete(T value) {
		if(root == null) {
			return false;
		}
		
		Queue<TreeNode<T>> queue = new LinkedList<>();
		queue.add(root);
		
		TreeNode<T> nodeToDelete = null;
		TreeNode<T> deepest = null;
		
		//iterate whole tree to find deepest node
		while(!queue.isEmpty()) {
			deepest = queue.poll();
			
			//assign node to delete if we found value
			if(deepest.value.equals(value)) {
				nodeToDelete = deepest;
			}
			
			if(deepest.left != null) {
				queue.add(deepest.left);
			}
			
			if(deepest.right != null) {
				queue.add(deepest.right);
			}
		}
		
		if(nodeToDelete == null) {
			return false;
		}
		
		deleteDeepestNode(deepest);
		nodeToDelete.value = deepest.value;
		return true;
	}
	
	private void deleteDeepestNode(TreeNode<T> deepest) {
		if(root == null) {
			return;
		}
		
		Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode<T> current = queue.poll();
			
			if(current.left == deepest) {
				current.left = null;
				break;
			} else {
				queue.add(current.left);
			}
			
			if(current.right == deepest) {
				current.right = null;
				break;
			} else {
				queue.add(current.right);
			}
			
		}
	}
	
	public void printBFS() {
		if(root == null) {
			System.out.println("Empty Tree");
		}
		
		Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode<T> current = queue.poll();
			System.out.print(current.value);
			if(current.left != null) {
				queue.add(current.left);
			}
			if(current.right != null) {
				queue.add(current.right);
			}
			System.out.print((!queue.isEmpty() ? " -> " : "\n"));
		}
	}
	
	public void printInOrder() {
		if(root == null) {
			System.out.println("Empty Tree");
		}
		
		printInOrderRecursively(root);
		System.out.println();
	}

	private void printInOrderRecursively(TreeNode<T> current) {
		if(current == null) {
			return;
		}
		
		printInOrderRecursively(current.left);
		System.out.print(current.value + " -> ");
		printInOrderRecursively(current.right);
	}

	public void printInOrderStack() {
		if(root == null) {
			System.out.println("Empty Tree");
		}
		
		Stack<TreeNode<T>> stack = new Stack<>();
		TreeNode<T> current = root;
		
		while(current != null || !stack.isEmpty()) {
			while(current != null) {
				stack.push(current);
				current = current.left;
			}
			TreeNode<T> endNode = stack.pop();
			System.out.print(endNode.value + " -> ");
			current = endNode.right;
		}
		
		System.out.println();
	}
	
	public int sum() {
		if(root == null) {
			return 0;
		}
		return sumRecursively(root);
	}

	private int sumRecursively(TreeNode<T> current) {
		if(current == null) {
			return 0;
		}
		return sumRecursively(current.left) + Integer.valueOf(current.value.toString()) + sumRecursively(current.right);
	}

	public int getSumOfParent(T value) {
		if(root == null) {
			return 0;
		}
		sum = 0;
		getSumOfParentRecursively(root, value);
		return sum;
	}

	int sum = 0;
	private void getSumOfParentRecursively(TreeNode<T> current, T value) {
		if(current == null) {
			return;
		} else if(current.left != null && value.equals(current.left.value) || current.right != null && value.equals(current.right.value)) {
			sum += Integer.valueOf(current.value.toString());
		}
		getSumOfParentRecursively(current.left, value);
		getSumOfParentRecursively(current.right, value);
	}
	
	public int getSumOfLeftLeaves() {
		if(root == null) {
			return 0;
		}
		sum = 0;
		getSumOfLeftLeavesRecursively(root);
		return sum;
	}
	
	private boolean isLeafNode(TreeNode<T> node) {
		if(node == null) return false;
		if(node.left == null && node.right == null) {
			return true;
		}
		return false;
	}

	private void getSumOfLeftLeavesRecursively(TreeNode<T> current) {
		if(current == null) {
			return;
		}
		
		if(current.left != null && isLeafNode(current.left)) {
			sum += Integer.valueOf(current.left.value.toString());
		} else {
			getSumOfLeftLeavesRecursively(current.left);
		}
		
		if(current.right != null && !isLeafNode(current.right)) {
			getSumOfLeftLeavesRecursively(current.right);
		}
	}
}
