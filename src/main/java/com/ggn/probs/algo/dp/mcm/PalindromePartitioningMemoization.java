package com.ggn.probs.algo.dp.mcm;

import java.util.Arrays;

public class PalindromePartitioningMemoization {
	private static int[][] t = new int[1001][1001];

	public int solve(char[] ch, int i, int j) {
		if (i >= j)
			return 0;

		if (isPalindrome(ch, i, j))
			return 0;

		if (t[i][j] != -1)
			return t[i][j];

		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int temp = solve(ch, i, k) + solve(ch, k + 1, j) + 1;

			if (temp < min)
				min = temp;
		}

		return t[i][j] = min;
	}

	public boolean isPalindrome(char[] ch, int i, int j) {
		if (i > j)
			return false;
		if (i == j)
			return true;

		while (i < j) {
			if (ch[i] != ch[j])
				return false;

			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromePartitioningMemoization op = new PalindromePartitioningMemoization();

		Arrays.stream(t).forEach(row -> Arrays.fill(row, -1));

		char[] ch = { 'n', 'i', 't', 'i', 'k' };

		if (op.isPalindrome(ch, 0, ch.length - 1)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

		System.out.println(op.solve(ch, 0, ch.length - 1));
	}

}
