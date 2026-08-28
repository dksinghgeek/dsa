package com.ggn.probs.algo.dp.Knapsack;

public class RodCuttingProblem {

	public int solve(int[] length, int[] price) {
		int t[][] = new int[price.length + 1][length.length + 1];

		for (int i = 0; i < price.length + 1; i++) {
			for (int j = 0; j < length.length + 1; j++) {
				if (i == 0) {
					t[i][j] = 0;
				}

				if (j == 0) {
					t[i][j] = 0;
				}
			}
		}

		for (int i = 1; i < price.length + 1; i++) {
			for (int j = 1; j < length.length + 1; j++) {
				if (length[i - 1] <= j) {
					t[i][j] = Math.max(price[i - 1] + t[i][j - length[i - 1]], t[i - 1][j]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}

		return t[price.length][length.length];
	}

	public static void main(String[] args) {
		RodCuttingProblem op = new RodCuttingProblem();
		int[] length = {1, 2, 3, 4, 5, 6, 7, 8 };
		int[] price = {1, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println(op.solve(length, price));
	}

}
