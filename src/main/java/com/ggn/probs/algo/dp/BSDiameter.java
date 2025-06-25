package com.ggn.probs.algo.dp;

public class BSDiameter {
	int max = Integer.MIN_VALUE;
	int maxDP = Integer.MIN_VALUE;

	// O(n*2)
	public void diameter(Node node) {
		if (node == null)
			return;
		int l = height(node.left);
		int r = height(node.right);

		max = Math.max(max, l + r + 1);

		diameter(node.left);
		diameter(node.right);
	}

	private int height(Node node) {
		if (node == null)
			return 0;

		int l = height(node.left);
		int r = height(node.right);

		return 1 + Math.max(l, r);
	}

	public int diameterDP(Node node) {
		if (node == null)
			return 0;

		int l = height(node.left);
		int r = height(node.right);

		int temp = 1 + Math.max(l, r);
		int ans = Math.max(temp, l + r + 1);

		maxDP = Math.max(maxDP, ans);

		return temp;
	}

	public static void main(String[] args) {
		BSDiameter op = new BSDiameter();
		Node root = new Node(5);
		root.left = new Node(8);
		root.right = new Node(6);
		root.left.left = new Node(3);
		root.left.right = new Node(7);
		root.right.left = new Node(9);
		op.diameter(root);
		System.out.println(op.max);
		op.diameterDP(root);
		System.out.println(op.maxDP);
	}

}
