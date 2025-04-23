package com.ggn.probs.dsa.ds.bst;

import com.ggn.probs.dsa.ds.bst.BSTProblems.Node;

public class BSTTraversal {
	
	public void postOrder(Node node) {
		java.util.Stack<Node> st = new java.util.Stack<>();
		
		while(node != null || !st.isEmpty()) {
			if(node != null) {
				st.push(node);
				node = node.left;
			} else {
				node = st.pop();
				
				if(node.data > 0) {
					node.data = -node.data;
					st.push(node);
					node = node.right;
				} else {
					System.out.println(-node.data);
					node = null;
				}
			}
		}
	}

	public static void main(String[] args) {

	}

}
