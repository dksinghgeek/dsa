package com.ggn.probs.algo.dp;

public class MaxPathSum {
	int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		MaxPathSum op = new MaxPathSum();
		
	    // Constructed binary tree is
        //          5
        //        /   \
        //       8     6
        //      / \   /
        //     3   7 9
        Node root = new Node(5);
        root.left = new Node(8);
        root.right = new Node(6);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(9);
        
        op.solve(root);
        
        System.out.println(op.max);
	}

	private int solve(Node node) {
		if (node == null)
			return 0;
		int l = solve(node.left);
		int r = solve(node.right);

		int temp = Math.max(Math.max(l, r) + node.data, node.data);
		int ans = Math.max(temp, l + r + node.data);
		max = Math.max(max, ans);

		return temp;
	}

}
