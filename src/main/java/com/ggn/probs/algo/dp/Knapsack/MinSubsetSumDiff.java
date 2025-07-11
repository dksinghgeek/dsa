package com.ggn.probs.algo.dp.Knapsack;

import java.util.ArrayList;
import java.util.List;

public class MinSubsetSumDiff {

	private List<Integer> subSetSum(int[] arr, int sum) {
		boolean[][] t = new boolean[arr.length + 1][sum + 1];

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
					t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}

		List<Integer> datas = new ArrayList<>();

		for (int j = 0; j <= sum/2; j++) {
			if (t[arr.length][j]) {
				datas.add(j);
			}
		}

		return datas;
	}

	public int solve(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		List<Integer> datas = subSetSum(arr, sum);

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < datas.size(); i++) {
			min = Math.min(min, sum - 2 * datas.get(i));
		}

		return min;
	}

	public static void main(String[] args) {
		MinSubsetSumDiff op = new MinSubsetSumDiff();
		int[] arr = { 1, 3, 7 };
		System.out.println(op.solve(arr));
	}

}
