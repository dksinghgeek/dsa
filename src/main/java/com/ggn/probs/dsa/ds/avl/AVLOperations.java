package com.ggn.probs.dsa.ds.avl;

public class AVLOperations {
	Node root = null;

	public int height(Node node) {
		int hl = (node != null && node.left != null) ? node.left.height : 0;
		int hr = (node != null && node.right != null) ? node.right.height : 0;

		return hl > hr ? hl + 1 : hr + 1;
	}

	public int balanceFactor(Node node) {
		int hl = (node != null && node.left != null) ? node.left.height : 0;
		int hr = (node != null && node.right != null) ? node.right.height : 0;

		return hl - hr;
	}

	public Node insert(Node node, int key) {
		if (node == null) {
			Node t = new Node();
			t.data = key;
			t.left = null;
			t.right = null;
			t.height = 1;

			return t;
		}

		if (key < node.data) {
			node.left = insert(node.left, key);
		} else if (key > node.data) {
			node.right = insert(node.right, key);
		}

		node.height = height(node);
		if (balanceFactor(node) == 2 && balanceFactor(node) == 1) {
			return LLRotation(node);
		} else if (balanceFactor(node) == 2 && balanceFactor(node) == -1) {
			return LRRotation(node);
		} else if (balanceFactor(node) == -2 && balanceFactor(node) == -1) {
			return RRRotaion(node);
		} else if (balanceFactor(node) == -2 && balanceFactor(node) == 1) {
			return RLRoation(node);
		}

		return node;
	}

	private Node RLRoation(Node p) {
		Node pl = p.right;
		Node plr = pl.left;

		pl.left = plr.right;
		p.right = plr.left;

		plr.right = pl;
		plr.left = p;
		
		plr.height = height(plr);
		p.height = height(p);
		pl.height = height(pl);

		if (p == root) {
			root = plr;
		}
		return plr;
	}

	private Node RRRotaion(Node p) {
		Node pl = p.right;
		Node plr = pl.left;

		pl.left = p;
		p.right = plr;
		
		p.height = height(p);
		pl.height = height(pl);

		if (p == root) {
			root = pl;
		}
		return pl;
	}

	private Node LRRotation(Node p) {
		Node pl = p.left;
		Node plr = pl.right;

		pl.right = plr.left;
		p.left = plr.right;

		plr.left = pl;
		plr.right = p;
		
		plr.height = height(plr);
		p.height = height(p);
		pl.height = height(pl);

		if (p == root) {
			root = plr;
		}
		return plr;
	}

	private Node LLRotation(Node p) {
		Node pl = p.left;
		Node plr = pl.right;

		pl.right = p;
		p.left = plr;
		
		p.height = height(p);
		pl.height = height(pl);

		if (p == root) {
			root = pl;
		}
		return pl;
	}
	
	public void inorder(Node node) {
		if(node != null) {
			inorder(node.left);
			System.out.print(" " + node.data + " : "+ balanceFactor(node));
			inorder(node.right);
		}
	}

	public static void main(String[] args) {
		AVLOperations op = new AVLOperations();
		op.root = op.insert(op.root, 30);
		op.root = op.insert(op.root, 20);
		op.root = op.insert(op.root, 10);
		op.inorder(op.root);
	}

	class Node {
		Node left;
		int data;
		Node right;
		int height;
	}

}
