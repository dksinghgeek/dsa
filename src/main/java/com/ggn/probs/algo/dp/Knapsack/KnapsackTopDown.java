package com.ggn.probs.algo.dp.Knapsack;

public class KnapsackTopDown {

	public static void main(String[] args) {
		KnapsackTopDown op = new KnapsackTopDown();

		int[] v = { 1, 2, 5, 6 };
		int[] w = { 2, 3, 4, 5 };
		int W = 8;

		System.out.println(op.solve(w, v, W, 4));
	}

	private int solve(int[] w, int[] v, int W, int n) {
		int[][] t = new int[n + 1][W + 1];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < W + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				}
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < W + 1; j++) {
				if (w[i - 1] <= j) {
					t[i][j] = Math.max(v[i-1] + t[i-1][j - w[i-1]], t[i-1][j]);
				} else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		
		return t[n][W];
	}

}
