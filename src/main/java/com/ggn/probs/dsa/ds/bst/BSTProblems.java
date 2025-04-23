package com.ggn.probs.dsa.ds.bst;

import java.util.ArrayList;
import java.util.List;
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
	
	public boolean isIdentical(Node n1, Node n2) {
		if(n1 == null && n2 == null) {
			return true;
		}
		
		if(n1 == null || n2 == null) {
			return false;
		}
		
		return (n1.data == n2.data) && isIdentical(n1.left, n2.left) && isIdentical(n1.right, n2.right);
	}

	public static void main(String[] args) {

	}
	
	public boolean isIdenticalBfs(Node n1, Node n2) {
		if(n1 == null && n2 == null)
			return true;
		
		if(n1 == null || n2 == null)
			return false;
		
		List<Node> q1 = new ArrayList<>();
		List<Node> q2 = new ArrayList<>();
		
		q1.add(n1);
		q2.add(n2);
		
		while(!q1.isEmpty() && !q2.isEmpty()) {
			Node t1 = q1.get(0);
			Node t2 = q2.get(0);
			
			if(t1.data != t2.data)
				return false;
			
			if(t1.left != null && t2.left != null) {
				q1.add(t1.left);
				q2.add(t2.left);
			} else if(t1.left != null || t2.left != null) {
				return false;
			}
			
			if(t1.right != null && t2.right != null) {
				q1.add(t1.right);
				q2.add(t2.right);
			} else if(t1.right != null || t2.right != null) {
				return false;
			}
		}
		
		return q1.isEmpty() && q2.isEmpty();
		
	}
	
	class Node {
		int data;
		Node left;
		Node right;
	}

}
