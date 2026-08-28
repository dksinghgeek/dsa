package com.ggn.probs.algo.dp.Knapsack;

public class KnapsackMemoization {
	int[][] M = new int[100][100];

	public int solve(int[] w, int[] v, int W, int n) {
		if (W == 0 || n == 0)
			return 0;

		if (M[n][W] != -1)
			return M[n][W];

		if (w[n - 1] <= W) {
			M[n][W] = Math.max(v[n - 1] + solve(w, v, W - w[n - 1], n - 1), solve(w, v, W, n - 1));
			return M[n][W];
		} else {
			M[n][W] = solve(w, v, W, n - 1);
			return solve(w, v, W, n - 1);
		}
	}

	public void print() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				System.out.print(M[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		KnapsackMemoization op = new KnapsackMemoization();

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				op.M[i][j] = -1;
			}
		}

		int[] v = { 1, 2, 5, 6 };
		int[] w = { 2, 3, 4, 5 };
		int W = 8;

		System.out.println(op.solve(w, v, W, 4));

		op.print();
	}

}
