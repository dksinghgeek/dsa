package com.ggn.probs.algo.dp.mcm;

public class MatrixChainMultiplicationRecursive {
	public int solve(int[] arr, int i, int j) {
		if (i >= j)
			return 0;

		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int temp = solve(arr, i, k) + solve(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];

			if (temp < min)
				min = temp;
		}

		return min;
	}

	public static void main(String[] args) {
		MatrixChainMultiplicationRecursive op = new MatrixChainMultiplicationRecursive();
		int[] arr = { 2, 1, 3, 4 };
		int i = 1;
		int j = arr.length - 1;

		System.out.println(op.solve(arr, i, j));

	}

}
