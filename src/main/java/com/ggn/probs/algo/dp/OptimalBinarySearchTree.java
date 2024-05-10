package com.ggn.probs.algo.dp;

import java.util.Arrays;

public class OptimalBinarySearchTree {

	public void optimalBinarySearchTreeAlgo(int[] keys, int[] p, int[] q, int n) {
		Entry[][] cost = new Entry[n][n];

		Entry entry = null;
		for (int d = 0; d < n; d++) {
			for (int i = 0; i < n - d; i++) {
				int j = i + d;
				entry = new Entry();
				if (j - i == 0) {
					entry.weight = q[i];
					entry.cost = 0;
					cost[i][j] = entry;
				} else {
					entry.weight = cost[i][j - 1].weight + q[j] + p[j];
					cost[i][j] = entry;
					
					int min = Integer.MAX_VALUE;
					for(int k = i+1 ; k <= j ; k++) {
						int r = cost[i][k-1].cost + cost[k][j].cost;
						if(r < min) {
							min = r;
							cost[i][j].k = k;
						}
					}
					cost[i][j].cost = min  + cost[i][j].weight;
				}
			}
		}
		
		System.out.println("Optimal BST " + cost[0][n-1].cost);

		print(cost, n);
	}

	private void print(Entry[][] cost, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (cost[i][j] == null) {
					System.out.print(" N,N,N");
					continue;
				}
				System.out.print(" " + cost[i][j].weight + "," + cost[i][j].cost + "," + cost[i][j].k);
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		OptimalBinarySearchTree op = new OptimalBinarySearchTree();
		int[] keys = { 0, 10, 20, 30, 40 };
		int[] p = { 0, 3, 3, 1, 1 };
		int[] q = { 2, 3, 1, 1, 1 };

		op.optimalBinarySearchTreeAlgo(keys, p, q, 5);
	}

}

class Entry {
	int weight;
	int cost;
	int k;
}
