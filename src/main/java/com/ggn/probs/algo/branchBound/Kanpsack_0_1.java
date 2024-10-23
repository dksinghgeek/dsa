package com.ggn.probs.algo.branchBound;

import java.util.ArrayList;
import java.util.List;

public class Kanpsack_0_1 {
	private static int UPPER = Integer.MAX_VALUE;

	public static void kanpsack(int[][] costs, int W) {
		List<Node> queue = new ArrayList<>();

		for (int i = 0; i < costs[0].length; i++) {
			Node node = new Node(i);
			node.profit = costs[0][i];
			node.weight = costs[1][i];
			
			double cost = -calNSetCost(costs, W, i, null);
			if(cost > UPPER) {
				continue;
			}
			node.cost = cost;
			
			int upper = -calNSetUpper(costs, W, i, null);
			if(upper < UPPER) {
				UPPER = upper;
			}
			node.upper = upper;
			
			queue.add(node);
		}
		
		while(!queue.isEmpty()) {
			Node previousNode = queue.remove(0);
			
			if(previousNode.upper > UPPER)
				continue;
			
			for(int i = previousNode.nodeId + 1 ; i < costs[0].length; i++) {
				Node node = new Node(i);
				node.profit = costs[0][i];
				node.weight = costs[1][i];
				
				double cost = -calNSetCost(costs, W, i, previousNode);
				if(cost > UPPER) {
					continue;
				}
				node.cost = cost;
				
				int upper = -calNSetUpper(costs, W, i, previousNode);
				if(upper < UPPER) {
					UPPER = upper;
				}
				node.upper = upper;
				
				previousNode.child = node;
				node.parent = previousNode;
				
				queue.add(node);
			}
			
			if(queue.isEmpty()) {
				while(previousNode != null) {
					System.out.print(previousNode.nodeId + " ");
					previousNode = previousNode.parent;
				}
			}
		}
	}

	private static int calNSetUpper(int[][] costs, int W, int index, Node previousNode) {
		int p = 0;
		
		while(previousNode != null) {
			if (previousNode.weight <= W) {
				W -= previousNode.weight;
				p += previousNode.profit;
			} 
			
			previousNode = previousNode.parent;
		}

		for (int i = index; i < costs[0].length; i++) {
			if (costs[1][i] <= W) {
				W -= costs[1][i];
				p += costs[0][i];
			} 
		}
		return p;
	}

	private static double calNSetCost(int[][] costs, int W, int index, Node previousNode) {
		double c = 0.0;
		
		while(previousNode != null) {
			if (previousNode.weight <= W) {
				W -= previousNode.weight;
				c += previousNode.profit;
			} else {
				if (W > 0) {
					c += (previousNode.profit/ previousNode.weight) * W;
				}
			}
			
			previousNode = previousNode.parent;
		}

		for (int i = index; i < costs[0].length; i++) {
			if (costs[1][i] <= W) {
				W -= costs[1][i];
				c += costs[0][i];
			} else {
				if (W > 0) {
					c += (costs[0][i]/ costs[1][i]) * W;
				}
			}
		}
		return c;
	}

	public static void main(String[] args) {
		int[][] costs = { { 10, 10, 12, 18 }, { 2, 4, 6, 9 } };

		kanpsack(costs, 15);
	}

}

class Node {
	int nodeId;
	int profit;
	int weight;
	Node parent;
	Node child;
	double cost;
	int upper;

	public Node(int nodeId) {
		this.nodeId = nodeId;
	}
}
