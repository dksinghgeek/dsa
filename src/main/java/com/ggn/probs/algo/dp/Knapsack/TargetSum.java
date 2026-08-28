package com.ggn.probs.algo.dp.Knapsack;

public class TargetSum {

	public static void main(String[] args) {
		TargetSum op = new TargetSum();
		int[] arr = { 1, 1, 2, 3 };
		int sum = 1;

		System.out.println(op.solve(arr, sum));

	}

	private int solve(int[] arr, int sum) {
		int s = 0;
		for (int i = 0; i < arr.length; i++) {
			s += arr[i];
		}

		int agg = (sum + s) / 2;

		int[][] t = new int[arr.length + 1][agg + 1];
		for (int i = 0; i < arr.length + 1; i++) {
			for (int j = 0; j < agg + 1; j++) {
				if (i == 0) {
					t[i][j] = 0;
				}

				if (j == 0) {
					t[i][j] = 1;
				}
			}
		}

		for (int i = 1; i < arr.length + 1; i++) {
			for (int j = 1; j < agg + 1; j++) {
				if (arr[i - 1] <= j) {
					t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}

		return t[arr.length][agg];
	}

}
