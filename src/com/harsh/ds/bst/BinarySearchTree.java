package com.harsh.ds.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	private BSTNode root;
	
	public void add(Integer value) {
		if(root == null) {
			root = new BSTNode(value);
			return;
		}
		
		Queue<BSTNode> queue = new LinkedList<BSTNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			BSTNode current = queue.poll();
			if(value < current.getValue()) {
				if(current.getLeft() == null) {
					current.setLeft(new BSTNode(value));
				} else {
					queue.add(current.getLeft());
				}
			} else {
				if(current.getRight() == null) {
					current.setRight(new BSTNode(value));
				} else {
					queue.add(current.getRight());
				}
			}
		}
	}
	
	public BSTNode getRoot() {
		return root; 
	}
	
	/**
	 * should print in ascending order
	 * 
	 * @param current 
	 */
	public void printInOrder(BSTNode current) {
		if(current != null) {
			printInOrder(current.getLeft());
			System.out.print(current.getValue() + " ");
			printInOrder(current.getRight());
		}
	}
	
	public boolean effectiveDelete(Integer value) {
		if(root == null) {
			return false;
		}
		
		deleteNode(root, value);
		return true;
	}
	
	
	
	private BSTNode deleteNode(BSTNode current, Integer value) {
		if(value < current.getValue()) {
			current.setLeft(deleteNode(current.getLeft(), value));
		} else if (value > current.getValue()) {
			current.setRight(deleteNode(current.getRight(), value));
		} else {
			if(current.getLeft() != null && current.getRight() != null) {
				//get successor, change current's value as per successor, delete successor
				BSTNode successor = getSuccessor(current.getRight(), current.getRight().getValue());
				current.setValue(successor.getValue());
				current.setRight(deleteNode(current.getRight(), successor.getValue()));
			} else if(current.getLeft() != null) {
				//left child is not null so return left child
				return current.getLeft();
			} else if (current.getRight() != null) {
				//right child is not null so return right child
				return current.getRight();
			} else {
				//both children are null, so returning null;
				return null;
			}
		}
		return current;
	}

	private BSTNode getSuccessor(BSTNode currentNode, Integer maxValue) {
		while(currentNode.getLeft() != null) {
			currentNode = currentNode.getLeft();
		}
		return currentNode;
	}

	public boolean delete(Integer value) {
		
		Queue<BSTNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			BSTNode current = queue.poll();
			
			if(current.getLeft() != null) {
				//node to be delete is left child
				if(current.getLeft().getValue() == value) {
					deleteNode(current, "left");
					return true;
				}
				queue.add(current.getLeft());
			}
			
			if(current.getRight() != null) {
				//node to be deleted is right child
				if(current.getRight().getValue() == value) {
					deleteNode(current, "right");
					return true;
				}
				queue.add(current.getRight());
			}
		}
		
		return false;
	}

	private void deleteNode(BSTNode current, String position) {
		if("left".equals(position)) {
			if(!deleteNodeBasedOnChildren(current.getLeft())) {
				current.setLeft(null);
			}
		} else {
			if(!deleteNodeBasedOnChildren(current.getRight())) {
				current.setRight(null);
			}
		}
	}

	private boolean deleteNodeBasedOnChildren(BSTNode current) {
		if(current.getLeft() != null && current.getRight() != null) {
			// both children exist
		} else if(current.getLeft() != null) {
			// left child exists
			current.setValue(current.getLeft().getValue());
			current.setLeft(null);
		} else if(current.getRight() != null) {
			// right child exists
			current.setValue(current.getRight().getValue());
			current.setRight(null);
		} else {
			return false;
		}
		return true;
	}

	private BSTNode getNodeForValue(Integer value) {
		if(root == null) {
			return null;
		}
		if(root.getValue() == value) {
			return root;
		}
		
		Queue<BSTNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			BSTNode current = queue.poll();
			
			if(current.getLeft() != null) {
				if(current.getLeft().getValue() == value) {
					return current.getLeft();
				} else {
					queue.add(current.getLeft());
				}
			}
			
			if(current.getRight() != null) {
				if(current.getRight().getValue() == value) {
					return current.getRight();
				} else {
					queue.add(current.getRight());
				}
			}
		}
		
		return null;
	}
}
