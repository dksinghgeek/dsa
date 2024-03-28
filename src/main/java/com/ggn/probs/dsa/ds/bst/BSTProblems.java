package com.ggn.probs.dsa.ds.bst;

import java.util.Stack;

public class BSTProblems {
	Node root;
	
	public int height(Node node) {
		if(node == null)
			return 0;
		
		int x = height(node.left);
		int y = height(node.right);
		
		return x>y ? x+1:y+1;
	}
	
	public Node inPre(Node node) {
		while(node != null && node.right != null) {
			node = node.right;
		}
		
		return node;
	}
	
	public Node inSucc(Node node) {
		while(node != null && node.left != null) {
			node = node.left;
		}
		
		return node;
	}
	
	public Node delete(Node node, int k) {
		
		if(node == null)
			return null;
		
		if(node.left == null && node.right != null) {
			if(node == root)
				root = null;
			
			return null;
		}
		
		if(k < node.data) {
			node.left = delete(node.left, k);
		} else if(k > node.data) {
			node.right = delete(node.right, k);
		} else {
			if(height(node.left) > height(node.right)) {
				Node q = inPre(node.left);
				node.data = q.data;
				node.left = delete(node.left, q.data);
			} else {
				Node q = inSucc(node.right);
				node.data = q.data;
				node.right = delete(node.right, q.data);
			}
		}
		
		return node;
	}
	
	public void createBSTWithPreOrder(int[] keys) {
		Stack<Node> st = new Stack<>();
		Node p = null;
		int i = 0;
		
		Node t = new Node();
		t.data = keys[i++];
		t.right = null; t.left = null;
		root = t;
		p = root;
		
		while(i < keys.length) {
			if(keys[i] < p.data) {
				t = new Node();
				t.data = keys[i++];
				t.left = null; t.right = null;
				st.push(p);
				p.left = t;
				p = t;
				
			} else {
				if(keys[i] > p.data && keys[i] < st.peek().data) {
					t = new Node();
					t.data = keys[i++];
					t.left = null;
					t.right = null;
					p.right = t;
					p = t;
				}else {
					p = st.pop();
				}
			}
		}
	}

	public static void main(String[] args) {

	}
	
	class Node {
		int data;
		Node left;
		Node right;
	}

}
