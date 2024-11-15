package com.ggn.probs.algo.branchBound;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TSP {
	private static int I = Integer.MAX_VALUE;
	private static int NODE_ID = 0;
	
	public static void tps(int[][] costs, int V) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		int[] mRow = new int[costs.length];
		int[] mCol = new int[costs[0].length];
		int[][] tCosts = Arrays.copyOf(costs, costs[0].length);

		rowReduction(mRow, tCosts);

		columnReduction(mCol, tCosts);

		int reduction = calNSetRowNColReduction(mRow, mCol);
		Node node = new Node(NODE_ID++);
		node.nodeId = V;
		node.cost = reduction;
		node.costs = costs;

		int[][] uCosts = deepCopy(tCosts);
		int i = node.nodeId;
		for (int j = 0; j < uCosts[0].length; j++) {
			if (uCosts[i][j] != I && (i != j)) {
				mRow = new int[costs.length];
				mCol = new int[costs[0].length];
				int[][] lCosts = deepCopy(uCosts);

				lCosts[j][i] = I;
				updateRowToInfinity(lCosts, i);
				updateColToInfinity(lCosts, j);

				rowReduction(mRow, lCosts);
				columnReduction(mCol, lCosts);

				int nextRed = calNSetRowNColReduction(mRow, mCol);
				Node next = new Node(NODE_ID++);
				next.cost = reduction + nextRed + uCosts[i][j];
				next.nodeId = j;
				next.parent = node;
				next.costs = lCosts;

				queue.add(next);
			}

		}

		Node lowCostNode = null;
		while (!queue.isEmpty()) {
			lowCostNode = queue.poll();
			queue.clear();

			uCosts = deepCopy(lowCostNode.costs);

			i = lowCostNode.nodeId;
			for (int j = 0; j < uCosts[0].length; j++) {
				if (uCosts[i][j] != I && (i != j)) {
					mRow = new int[costs.length];
					mCol = new int[costs[0].length];
					int[][] lCosts = deepCopy(uCosts);

					lCosts[j][0] = I;
					updateRowToInfinity(lCosts, i);
					updateColToInfinity(lCosts, j);

					rowReduction(mRow, lCosts);
					columnReduction(mCol, lCosts);

					int nextRed = calNSetRowNColReduction(mRow, mCol);
					Node next = new Node(NODE_ID++);
					next.cost = lowCostNode.cost + nextRed + uCosts[i][j];
					next.nodeId = j;
					next.parent = lowCostNode;
					next.costs = lCosts;

					queue.add(next);
				}
			}
		}

		if (queue.isEmpty()) {
			Node t = lowCostNode;
			Node[] path = new Node[costs[0].length];
			i=costs[0].length - 1;
			while (t != null) {
				path[i--] = t;
				t = t.parent;
			}
			
			for(int j = 0 ; j < costs[0].length; j++) {
				System.out.print(">" + path[j].nodeId);
			}

		}

	}

	private static int[][] deepCopy(int[][] tCosts) {
		int[][] deepCopy = new int[tCosts.length][tCosts[0].length];
		
		for(int i = 0; i < tCosts.length; i++) {
			for(int j = 0; j < tCosts[0].length; j++) {
				deepCopy[i][j] = tCosts[i][j];
			}
		}
		return deepCopy;
	}

	private static void updateColToInfinity(int[][] uCosts, int j) {
		for(int i = 0; i < uCosts[0].length; i++) {
			uCosts[i][j] = I;
		}
	}

	private static void updateRowToInfinity(int[][] uCosts, int i) {
		for(int j = 0; j < uCosts.length; j++) {
			uCosts[i][j] = I;
		}
	}

	private static int calNSetRowNColReduction(int[] mRow, int[] mCol) {
		int total = 0;

		for (int i = 0; i < mRow.length; i++) {
			total += mRow[i];
		}

		for (int i = 0; i < mCol.length; i++) {
			total += mCol[i];
		}

		return total;
	}

	private static void columnReduction(int[] mCol, int[][] tCosts) {
		int min;
		for (int j = 0; j < tCosts[0].length; j++) {
			min = I;

			for (int i = 0; i < tCosts.length; i++) {
				if (tCosts[i][j] != I && tCosts[i][j] < min) {
					min = tCosts[i][j];
				}
			}

			if (min != I) {
				mCol[j] = min;
			}

		}

		for (int j = 0; j < tCosts[0].length; j++) {
			for (int i = 0; i < tCosts.length; i++) {
				if (tCosts[i][j] != I) {
					tCosts[i][j] -= mCol[j];
				}
			}
		}
	}

	private static void rowReduction(int[] mRow, int[][] tCosts) {
		int min;
		for (int i = 0; i < tCosts.length; i++) {
			min = I;

			for (int j = 0; j < tCosts.length; j++) {
				if (tCosts[i][j] != I && tCosts[i][j] < min) {
					min = tCosts[i][j];
				}
			}

			if (min != I) {
				mRow[i] = min;
			}
		}

		for (int i = 0; i < tCosts.length; i++) {
			for (int j = 0; j < tCosts[0].length; j++) {
				if (tCosts[i][j] != I) {
					tCosts[i][j] -= mRow[i];
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] costs = {
				{I, 20, 30, 10, 11},
				{15, I, 16, 4,  2},
				{3,  5 , I, 2,  4},
				{19, 6, 18, I,  3},
				{16, 4,  7, 16, I}
		};
		
		tps(costs, 0);
	}
}

class Node implements Comparable<Node>{
	int nodeNo;
	int cost;
	Node parent;
	int nodeId;
	int[][] costs;
	
	public Node(int nodeNo) {
		this.nodeNo = nodeNo;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}
