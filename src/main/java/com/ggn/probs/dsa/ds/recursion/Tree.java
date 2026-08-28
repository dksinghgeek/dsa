package com.ggn.probs.dsa.ds.recursion;

public class Tree {

	public int height(Node node) {
		if (node == null)
			return 0;
		
		int l = height(node.left);
		int r = height(node.right);
		
		return 1 + Math.max(l, r);

	}

	public static void main(String[] args) {
		Tree op = new Tree();
		System.out.println("Height : " + op.height(null));
	}

	class Node {
		int data;
		Node left;
		Node right;
	}

}
