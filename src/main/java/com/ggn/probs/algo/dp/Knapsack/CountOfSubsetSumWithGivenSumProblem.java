package com.ggn.probs.algo.dp.Knapsack;

public class CountOfSubsetSumWithGivenSumProblem {

	public static void main(String[] args) {
		CountOfSubsetSumWithGivenSumProblem op = new CountOfSubsetSumWithGivenSumProblem();

		int[] arr = { 1, 5, 11, 5 };
		int sum = 11;

		System.out.println(op.solve(arr, sum));
	}

	private int solve(int[] arr, int sum) {
		int[][] t = new int[arr.length + 1][sum + 1];

		for (int i = 0; i < arr.length + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0) {
					t[i][j] = 0;
				}

				if (j == 0) {
					t[i][j] = 1;
				}
			}
		}

		for (int i = 1; i < arr.length + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (arr[i - 1] <= j) {
					t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}

		return t[arr.length][sum];
	}

}
