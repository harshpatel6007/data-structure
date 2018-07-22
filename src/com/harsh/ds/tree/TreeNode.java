package com.harsh.ds.tree;

public class TreeNode<E> {

	public E value;
	public TreeNode<E> right, left;
	
	public TreeNode(E value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}