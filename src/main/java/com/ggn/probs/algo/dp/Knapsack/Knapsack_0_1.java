package com.ggn.probs.algo.dp.Knapsack;

public class Knapsack_0_1 {
	public int solve(int[] w, int[] v, int W, int n) {
		if (W == 0 || n == 0)
			return 0;

		if (w[n - 1] <= W) {
			return Math.max(v[n - 1] + solve(w, v, W - w[n - 1], n - 1), solve(w, v, W, n - 1));
		} else {
			return solve(w, v, W, n - 1);
		}
	}

	public static void main(String[] args) {
		int[] v = { 1, 2, 5, 6 };
		int[] w = { 2, 3, 4, 5 };
		int W = 8;

		Knapsack_0_1 op = new Knapsack_0_1();

		System.out.println(op.solve(w, v, W, 4));
	}

}
