package com.ggn.probs.algo.dp.Knapsack;

public class EqualSumPartitionProblem {

	public static void main(String[] args) {
		EqualSumPartitionProblem op = new EqualSumPartitionProblem();

		int[] arr = { 1, 5, 11, 5 };
		int sum = 11;

		System.out.println(op.solve(arr, sum));
	}

	private boolean solve(int[] arr, int sum) {
		boolean[][] t = new boolean[arr.length + 1][sum + 1];

		int agg = 0;
		for (int i = 0; i < arr.length; i++) {
			agg += arr[i];
		}

		int W = agg / 2;

		for (int i = 0; i < arr.length + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0) {
					t[i][j] = false;
				}

				if (j == 0) {
					t[i][j] = true;
				}
			}
		}

		for (int i = 1; i < arr.length + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (arr[i - 1] <= j) {
					t[i][j] = t[i-1][j - arr[i - 1]] || t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}

		return t[arr.length][sum];
	}

}
