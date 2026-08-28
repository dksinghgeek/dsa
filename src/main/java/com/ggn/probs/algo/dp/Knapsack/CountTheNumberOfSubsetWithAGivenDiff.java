package com.ggn.probs.algo.dp.Knapsack;

import java.util.ArrayList;
import java.util.List;

public class CountTheNumberOfSubsetWithAGivenDiff {
	public int solve(int[] arr, int diff) {
		List<Integer> numbers = new ArrayList<>();
		numbers.addAll(numbers);

		int s = 0;
		for (int i = 0; i < arr.length; i++) {
			s += arr[i];
		}

		System.out.println("S : " + s);

		int sum = (s + diff) / 2;

		System.out.println("sum : " + sum);

		return subsetCountWithGivenSum(arr, sum);
	}

	private int subsetCountWithGivenSum(int[] arr, int sum) {
		int[][] T = new int[arr.length + 1][sum + 1];

		for (int i = 0; i < arr.length + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0) {
					T[i][j] = 0;
				}

				if (j == 0) {
					T[i][j] = 1;
				}
			}
		}

		for (int i = 1; i < arr.length + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (arr[i - 1] <= j) {
					T[i][j] = T[i - 1][j - arr[i - 1]] + T[i - 1][j];
				} else {
					T[i][j] = T[i - 1][j];
				}
			}
		}

		return T[arr.length][sum];
	}

	public static void main(String[] args) {
		CountTheNumberOfSubsetWithAGivenDiff op = new CountTheNumberOfSubsetWithAGivenDiff();

		int[] arr = { 1, 1, 3, 4 };
		int diff = 1;

		System.out.println(op.solve(arr, diff));
	}

}
