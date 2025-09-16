package com.ggn.probs.algo.dp.mcm;

import java.util.Arrays;

public class MatrixChainMultiplicationMemoization {
	private static int[][] t = new int[1001][1001];

	public static void main(String[] args) {
		MatrixChainMultiplicationMemoization op = new MatrixChainMultiplicationMemoization();

		int[] arr = { 2, 1, 3, 4 };
		int i = 1;
		int j = arr.length - 1;

		Arrays.stream(t).forEach(row -> Arrays.fill(row, -1));

		System.out.println(op.solve(arr, i, j));
	}

	private int solve(int[] arr, int i, int j) {
		if (i >= j) {
			return 0;
		}

		if (t[i][j] != -1) {
			return t[i][j];
		}

		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int temp = solve(arr, i, k) + solve(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];

			if (temp < min)
				min = temp;
		}

		return t[i][j] = min;
	}

}
